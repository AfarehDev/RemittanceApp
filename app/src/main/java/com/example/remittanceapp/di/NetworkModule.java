package com.example.remittanceapp.di;

import com.example.remittanceapp.ApplicationClass;
import com.example.remittanceapp.data.preferences_data.UserDataStore;
import com.example.remittanceapp.data.remote.RemoteAPI;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(SingletonComponent.class)
public class NetworkModule {

    @Provides
    @Singleton
    public static Interceptor provideInterceptor(UserDataStore userDataStore){
        return chain -> {
            Request original = chain.request();

            // Retrieve the token from the UserDataStore
            String token = userDataStore.getUserToken();

            // Add the token to the request header
            Request.Builder requestBuilder = original.newBuilder()
                    .header("Authorization", "Bearer " + token);

            Request request = requestBuilder.build();
            return chain.proceed(request);
        };
    }

    @Provides
    @Singleton
    public static OkHttpClient provideOkHttpClient(Interceptor interceptor){
        return new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();
    }

    @Provides
    @Singleton
    public static RemoteAPI provideRemoteAPI(OkHttpClient client){
        return new Retrofit.Builder()
                .baseUrl("https://dev2.cismobile.net/API2/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .client(client)
                .build()
                .create(RemoteAPI.class);
    }





}
