package com.example.remittanceapp.presentation.payRemittanceScreen;

import android.annotation.SuppressLint;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.remittanceapp.domain.usecases.IncomingSystemFeeUseCase;
import com.example.remittanceapp.domain.usecases.PayRemittanceUseCase;
import com.example.remittanceapp.domain.usecases.ValidateInputs;
import com.example.remittanceapp.domain.utils.ResponseState;
import com.example.remittanceapp.domain.utils.ValidationResult;

import java.util.Arrays;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;

@HiltViewModel
public class PayRemittanceViewModel extends ViewModel {


    private ValidateInputs validateInputs;
    private PayRemittanceUseCase payRemittanceUseCase;
    private IncomingSystemFeeUseCase systemFeeUseCase;

    private MutableLiveData<Boolean> sendState = new MutableLiveData<>();
    private MutableLiveData<Boolean> dialogState = new MutableLiveData<>();
    private MutableLiveData<String> sendStateMesssage = new MutableLiveData<>();

    private MutableLiveData<String> receiverName = new MutableLiveData<>("احمد محمد قاسم اليمني");
    private MutableLiveData<String> receiverNameError = new MutableLiveData<>();

    private MutableLiveData<String> senderName = new MutableLiveData<>("محمد علي محمد قاسم");
    private MutableLiveData<String> senderNameError = new MutableLiveData<>();

    private MutableLiveData<String> amount = new MutableLiveData<>("70000");
    private MutableLiveData<String> remId = new MutableLiveData<>("698753948");
    private MutableLiveData<Integer> feeId = new MutableLiveData<>(0);

    @Inject
    public PayRemittanceViewModel(
            ValidateInputs validateInputs,
            PayRemittanceUseCase payRemittanceUseCase,
            IncomingSystemFeeUseCase systemFeeUseCase
    ) {
        this.validateInputs = validateInputs;
        this.payRemittanceUseCase = payRemittanceUseCase;
        this.systemFeeUseCase = systemFeeUseCase;
    }

    public void validateAndPay(){

        if (!formValidation()){
            return;
        }

        getFeeIDAndSend();
    }

    private boolean formValidation() {
        ValidationResult receiverNameResult = validateInputs.validateName(receiverName.getValue());
        ValidationResult senderNameResult = validateInputs.validateName(senderName.getValue());


        boolean hasError = false;
        for (ValidationResult result : Arrays.asList(receiverNameResult,senderNameResult)) {
            if (!result.isSuccessful()) {
                hasError = true;
                break;
            }
        }

        if (hasError){
            receiverNameError.setValue(receiverNameResult.getErrorMessage());
            senderNameError.setValue(senderNameResult.getErrorMessage());
            Log.e("ValidationResponse" , receiverNameResult.getErrorMessage());
            return false;
        }else {
            return true;
        }
    }

    @SuppressLint("CheckResult")
    public void getFeeIDAndSend(){
        dialogState.setValue(true);

        systemFeeUseCase.getSystemFeeID()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        feeID-> {
                            if (feeID > 0){
                                feeId.setValue(feeID);
                                payRemittance();
                            }else {
                                dialogState.setValue(false);
                                sendStateMesssage.setValue("feeID : "+feeID);

                            }
                            Log.d("ResponseLogin" , feeID+"");
                        },
                        error -> {
                            dialogState.setValue(false);
                            sendStateMesssage.setValue(error.getMessage());
                            Log.e("ResponseLogin" , error.getMessage());
                        }
                );
    }

    @SuppressLint("CheckResult")
    public void payRemittance() {
        payRemittanceUseCase.payRemittance(
                        remId.getValue(), senderName.getValue(), receiverName.getValue(), amount.getValue(),feeId.getValue()
                )
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe( responseState -> {

                    // Loading
                    if (responseState instanceof ResponseState.Loading) {
                        // Show loading state
                        dialogState.setValue(true);
                        receiverNameError.setValue("");
                        sendStateMesssage.setValue("");

                    }
                    // Success
                    else if (responseState instanceof ResponseState.Success) {
                        dialogState.setValue(false);
                        sendState.setValue(true);
                        String message = ((ResponseState.Success<String>) responseState).getData();
                        sendStateMesssage.setValue(message);
                    }
                    // Error
                    else if (responseState instanceof ResponseState.Error) {
                        dialogState.setValue(false);
                        String errorMessage = ((ResponseState.Error<String>) responseState).getMessage();
                        sendStateMesssage.setValue(errorMessage);
                    }
                });
    }

    public MutableLiveData<Boolean> getSendState() {
        return sendState;
    }

    public MutableLiveData<Boolean> getDialogState() {
        return dialogState;
    }

    public MutableLiveData<String> getSendStateMesssage() {
        return sendStateMesssage;
    }

    public MutableLiveData<String> getReceiverName() {
        return receiverName;
    }

    public MutableLiveData<String> getReceiverNameError() {
        return receiverNameError;
    }

    public MutableLiveData<String> getSenderName() {
        return senderName;
    }

    public MutableLiveData<String> getSenderNameError() {
        return senderNameError;
    }

    public MutableLiveData<String> getAmount() {
        return amount;
    }

    public MutableLiveData<String> getRemId() {
        return remId;
    }
}
