package com.example.remittanceapp.data.remote;

import com.example.remittanceapp.domain.model.IncomeFeeRequestBody;
import com.example.remittanceapp.domain.model.IncomingFee;
import com.example.remittanceapp.domain.model.LoginRequestBody;
import com.example.remittanceapp.domain.model.LoginResponse;
import com.example.remittanceapp.domain.model.SendRemittance;
import com.example.remittanceapp.domain.model.SendRemittanceRequestBody;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RemoteAPI {

/*    @POST("api/Auth/Login")
    public Call<LoginResponse> login(@Body LoginRequestBody body);*/

    @POST("api/Auth/Login")
    public Single<LoginResponse> login(@Body LoginRequestBody body);


    @POST("api/Remittance/IncommingSystemFee")
    public Single<IncomingFee> incomingSystemFee(@Body IncomeFeeRequestBody body);

    @POST("api/Remittance/SendRemittance")
    public Single<SendRemittance> sendRemittance(@Body SendRemittanceRequestBody body);




}
