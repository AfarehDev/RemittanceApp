package com.example.remittanceapp.data.remote;


import com.example.remittanceapp.domain.model.LoginRequestBody;
import com.example.remittanceapp.domain.model.LoginResponse;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RemoteClient {
    private static final String BaseUrl = "https://dev2.cismobile.net/API2/";

    private RemoteAPI remoteAPI;

    private static RemoteClient Instant;

    public RemoteClient() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        remoteAPI = retrofit.create(RemoteAPI.class);
    }

    public static RemoteClient getInstant() {
        if (Instant == null){
            return new RemoteClient();
        }
        return Instant;
    }

    /*public Call<LoginResponse> login(LoginRequestBody requestBody){
        return remoteAPI.login(requestBody);
    }*/

}
