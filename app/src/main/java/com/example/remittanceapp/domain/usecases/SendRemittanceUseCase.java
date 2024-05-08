package com.example.remittanceapp.domain.usecases;

import android.annotation.SuppressLint;
import android.util.Log;

import com.example.remittanceapp.data.repo.Repository;
import com.example.remittanceapp.domain.model.SendRemittance;
import com.example.remittanceapp.domain.model.SendRemittanceRequestBody;
import com.example.remittanceapp.domain.utils.ResponseState;

import javax.inject.Inject;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class SendRemittanceUseCase {
    IncomingSystemFeeUseCase systemFeeUseCase;
    private Repository repository;

    @Inject
    public SendRemittanceUseCase(
            IncomingSystemFeeUseCase systemFeeUseCase,
            Repository repository
    ) {
        this.systemFeeUseCase = systemFeeUseCase;
        this.repository = repository;
    }

    @SuppressLint("CheckResult")
    public Observable<ResponseState<String>> sendRemittance(
            int feeId,
            String expressID,
            String senderName,
            String senderPhone,
            String receiverName,
            String reciverPhone,
            String amountPaid
    ) {
        int expressId = Integer.parseInt(expressID);
        int senderMobile = Integer.parseInt(senderPhone);
        int receiverMobile = Integer.parseInt(reciverPhone);
        int amount = Integer.parseInt(amountPaid);

        Log.d("SendRemittance" , "expressId: "+expressId);
        Log.d("SendRemittance" , "senderName: "+senderName);
        Log.d("SendRemittance" , "senderMobile: "+senderMobile);
        Log.d("SendRemittance" , "reciverName: "+receiverName);
        Log.d("SendRemittance" , "reciverMobile: "+receiverMobile);
        Log.d("SendRemittance" , "amount: "+amount);

        return Observable.<ResponseState<String>>create(emitter -> {

            emitter.onNext(new ResponseState.Loading<>());
            try {


                Single<SendRemittance> observable = repository.sendRemittance(
                            new SendRemittanceRequestBody(expressId, senderName , senderMobile , receiverName , receiverMobile, amount , feeId)
                        )
                        //.subscribeOn(Schedulers.io()) // to fetch the data on io thread
                        .observeOn(AndroidSchedulers.mainThread());
                observable.subscribe(
                        response ->{
                            if (response.isStatus()){
                                Log.d("SendRemittance" , "response.isStatus(): "+response.isStatus());
                                emitter.onNext(new ResponseState.Success<>(response.getDescription()+", referance: "+response.getReferance()+", referance2: "+response.getReferance2()));
                            }else {
                                Log.e("SendRemittance" , "response.isStatus(): "+response.isStatus());
                                emitter.onNext(new ResponseState.Error<>(response.getDescription()));
                            }
                        } ,
                        error ->{
                            Log.e("SendRemittance" , "error.getMessage(): "+error.getMessage());
                            emitter.onNext(new ResponseState.Error<>(error.getMessage()));
                        }
                );

            } catch (Exception ex) {
                emitter.onNext(new ResponseState.Error<>(ex.getMessage()));
                Log.e("SendRemittance" , ex.getMessage());
            }
            //emitter.onComplete();
        }).subscribeOn(Schedulers.io());
    }

    @SuppressLint("CheckResult")
    public void printFeeID(){
        systemFeeUseCase.getSystemFeeID()
                .subscribeOn(Schedulers.io())
                .subscribe(
                        feeID-> {
                            Log.d("ResponseLogin" , feeID+"");
                        },
                        error -> {
                            Log.e("ResponseLogin" , error.getMessage());
                        }
                );
    }
}
