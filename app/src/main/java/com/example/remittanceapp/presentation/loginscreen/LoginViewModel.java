package com.example.remittanceapp.presentation.loginscreen;

import android.annotation.SuppressLint;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.remittanceapp.domain.model.UserData;
import com.example.remittanceapp.domain.usecases.LoginUseCase;
import com.example.remittanceapp.domain.utils.ResponseState;

import javax.inject.Inject;
import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;

@HiltViewModel
public class LoginViewModel extends ViewModel {
    private LoginUseCase loginUseCase;


    private MutableLiveData<Boolean> loginState = new MutableLiveData<>();
    private MutableLiveData<Boolean> dialogState = new MutableLiveData<>();
    private MutableLiveData<String> loginError = new MutableLiveData<>();



    @Inject
    public LoginViewModel(
            LoginUseCase loginUseCase

    ) {
        this.loginUseCase = loginUseCase;
    }

    @SuppressLint("CheckResult")
    public void login() {

        loginUseCase.login()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe( responseState -> {

            // Loading
            if (responseState instanceof ResponseState.Loading) {
                // Show loading state
                dialogState.setValue(true);
                loginError.setValue("");

            }
            // Success
            else if (responseState instanceof ResponseState.Success) {
                dialogState.setValue(false);
                loginState.setValue(true);

            }
            // Error
            else if (responseState instanceof ResponseState.Error) {
                dialogState.setValue(false);
                String errorMessage = ((ResponseState.Error<String>) responseState).getMessage();
                loginError.setValue(errorMessage);
            }
        });

    }


    public MutableLiveData<Boolean> getDialogState() {return dialogState;}

    public MutableLiveData<String> getLoginError() {return loginError;}

    public MutableLiveData<Boolean> getLoginState() {return loginState;}



}
