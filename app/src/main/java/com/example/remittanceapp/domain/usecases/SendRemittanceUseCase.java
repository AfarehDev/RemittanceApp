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

    private Repository repository;

    @Inject
    public SendRemittanceUseCase(Repository repository) {this.repository = repository;}


    /**
     * This method sends a remittance and returns an Observable with ResponseState containing
     * the result of the operation.
     *
     * @param feeId        The ID of the fee associated with the remittance.
     * @param expressID    The express ID associated with the remittance.
     * @param senderName   The name of the sender.
     * @param senderPhone  The phone number of the sender.
     * @param receiverName The name of the receiver.
     * @param reciverPhone The phone number of the receiver.
     * @param amountPaid   The amount paid for the remittance.
     * @return An Observable<ResponseState<String>> representing the result of the remittance operation.
     */
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

        return Observable.<ResponseState<String>>create(emitter -> {

            emitter.onNext(new ResponseState.Loading<>());
            try {
                Single<SendRemittance> observable = repository.sendRemittance(
                            new SendRemittanceRequestBody(expressId, senderName , senderMobile , receiverName , receiverMobile, amount , feeId)
                        )
                        .observeOn(AndroidSchedulers.mainThread());
                observable.subscribe(
                        response ->{
                            if (response.isStatus()){
                                Log.d("SendRemittance" , "response.isStatus(): "+response.isStatus()+", referance: "+response.getReferance()+", referance2: "+response.getReferance2());
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
        }).subscribeOn(Schedulers.io());
    }
}
