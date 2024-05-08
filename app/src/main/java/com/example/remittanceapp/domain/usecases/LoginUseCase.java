package com.example.remittanceapp.domain.usecases;

import android.annotation.SuppressLint;
import android.util.Log;

import com.example.remittanceapp.data.preferences_data.UserDataStore;
import com.example.remittanceapp.data.repo.Repository;
import com.example.remittanceapp.domain.model.LoginRequestBody;
import com.example.remittanceapp.domain.model.LoginResponse;
import com.example.remittanceapp.domain.model.UserData;
import com.example.remittanceapp.domain.utils.ResponseState;

import javax.inject.Inject;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class LoginUseCase {
    private Repository repository;
    private UserDataStore userDataStore;
    @Inject
    public LoginUseCase(
            Repository repository,
            UserDataStore userDataStore
    ) {
        this.userDataStore = userDataStore;
        this.repository = repository;
    }

    @SuppressLint("CheckResult")
    public Observable<ResponseState<String>> login() {

        return Observable.<ResponseState<String>>create(emitter -> {

            emitter.onNext(new ResponseState.Loading<>());

            LoginRequestBody loginRequestBody = new LoginRequestBody();

            try {
                Single<LoginResponse> observable = repository.login(loginRequestBody)
                        .subscribeOn(Schedulers.io()) // to fetch the data on io thread
                        .observeOn(AndroidSchedulers.mainThread());
                observable.subscribe(
                        response ->{
                            if (response.getToken() != null && response.getToken() != ""){
                                userDataStore
                                        .saveUserData(new UserData(response))
                                        .subscribeOn(Schedulers.io())
                                        .subscribe(() -> {
                                            // Data saved successfully
                                            emitter.onNext(new ResponseState.Success<>("success"));
                                        }, throwable -> {
                                            emitter.onNext(new ResponseState.Error<>(throwable.getMessage()));
                                        });

                            }else {
                                emitter.onNext(new ResponseState.Error<>(response.getDescription()));
                            }
                        } ,
                        error ->{
                            emitter.onNext(new ResponseState.Error<>(error.getMessage()));
                        }
                );

            } catch (Exception ex) {
                emitter.onNext(new ResponseState.Error<>(ex.getMessage()));
                Log.e("ResponseLogin" , ex.getMessage());
            }
            //emitter.onComplete();
        }).subscribeOn(Schedulers.io());
    }
}
