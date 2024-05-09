package com.example.remittanceapp.domain.usecases;

import android.annotation.SuppressLint;
import android.util.Log;

import com.example.remittanceapp.data.repo.Repository;
import com.example.remittanceapp.domain.model.PayRemittRequestBody;
import com.example.remittanceapp.domain.model.PayRemittance;
import com.example.remittanceapp.domain.model.SendRemittance;
import com.example.remittanceapp.domain.model.SendRemittanceRequestBody;
import com.example.remittanceapp.domain.utils.ResponseState;

import javax.inject.Inject;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class PayRemittanceUseCase{

    private Repository repository;

    @Inject
    public PayRemittanceUseCase(Repository repository) {
        this.repository = repository;
    }

    @SuppressLint("CheckResult")
    public Observable<ResponseState<String>> payRemittance(
            String remID,
            String senderName,
            String receiverName,
            String amountPaid,
            int feeId
    ) {
        int remId = Integer.parseInt(remID);
        int amount = Integer.parseInt(amountPaid);

        PayRemittRequestBody body = new PayRemittRequestBody(remId,amount,senderName,receiverName,feeId);

        return Observable.<ResponseState<String>>create(emitter -> {

            emitter.onNext(new ResponseState.Loading<>());
            try {
                Single<PayRemittance> observable = repository.payRemittance(body)
                        .observeOn(AndroidSchedulers.mainThread());
                observable.subscribe(
                        response ->{
                            if (response.isStatus()){
                                Log.d("PayRemittance" , "response.isStatus(): "+response.isStatus());
                                emitter.onNext(new ResponseState.Success<>(response.getDescription()+", referance: "+response.getReferance()+", referance2: "+response.getReferance2()));
                            }else {
                                Log.e("PayRemittance" , "response.isStatus(): "+response.isStatus());
                                emitter.onNext(new ResponseState.Error<>(response.getDescription()));
                            }
                        } ,
                        error ->{
                            Log.e("PayRemittance" , "error.getMessage(): "+error.getMessage());
                            emitter.onNext(new ResponseState.Error<>(error.getMessage()));
                        }
                );

            } catch (Exception ex) {
                emitter.onNext(new ResponseState.Error<>(ex.getMessage()));
                Log.e("PayRemittance" , ex.getMessage());
            }
        }).subscribeOn(Schedulers.io());
    }
}
