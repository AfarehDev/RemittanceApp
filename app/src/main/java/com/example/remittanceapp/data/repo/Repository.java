package com.example.remittanceapp.data.repo;

import com.example.remittanceapp.data.remote.RemoteAPI;
import com.example.remittanceapp.domain.model.IncomeFeeRequestBody;
import com.example.remittanceapp.domain.model.IncomingFee;
import com.example.remittanceapp.domain.model.LoginRequestBody;
import com.example.remittanceapp.domain.model.LoginResponse;
import com.example.remittanceapp.domain.model.PayRemittRequestBody;
import com.example.remittanceapp.domain.model.PayRemittance;
import com.example.remittanceapp.domain.model.SendRemittance;
import com.example.remittanceapp.domain.model.SendRemittanceRequestBody;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Body;

public class Repository {
    private RemoteAPI remoteAPI;

    @Inject
    public Repository(RemoteAPI remoteAPI) {
        this.remoteAPI = remoteAPI;
    }

    public Single<LoginResponse> login(LoginRequestBody requestBody){
        return remoteAPI.login(requestBody);
    }

    public Single<IncomingFee> incomingSystemFee(IncomeFeeRequestBody body) {
        return remoteAPI.incomingSystemFee(body);
    }

    public Single<SendRemittance> sendRemittance(SendRemittanceRequestBody body) {
        return remoteAPI.sendRemittance(body);
    }

    public Single<PayRemittance> payRemittance(PayRemittRequestBody body) {
        return remoteAPI.payRemittance(body);
    }

}
