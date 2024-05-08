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

    MutableLiveData<UserData> responseMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<Boolean> loginState = new MutableLiveData<>();
    private MutableLiveData<Boolean> dialogState = new MutableLiveData<>();
    private MutableLiveData<String> loginError = new MutableLiveData<>();
    private MutableLiveData<String> name = new MutableLiveData<>();
    private MutableLiveData<String> nameError = new MutableLiveData<>();
    private MutableLiveData<String> phone = new MutableLiveData<>();
    private MutableLiveData<String> phoneError = new MutableLiveData<>();


    @Inject
    public LoginViewModel(
            LoginUseCase loginUseCase

    ) {
        this.loginUseCase = loginUseCase;
        //getUserData();
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
                nameError.setValue("");
                phoneError.setValue("");
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


    public MutableLiveData<UserData> getResponseMutableLiveData() {return responseMutableLiveData;}
    public MutableLiveData<Boolean> getDialogState() {return dialogState;}

    public MutableLiveData<String> getLoginError() {return loginError;}

    public MutableLiveData<Boolean> getLoginState() {return loginState;}

    public MutableLiveData<String> getName() {return name;}

    public void setName(String nameValue) {name.setValue(nameValue);}
    public MutableLiveData<String> getPhone() {return phone;}
    public void setPhone(String phoneValue) {phone.setValue(phoneValue);}
    public MutableLiveData<String> getNameError() {return nameError;}
    public MutableLiveData<String> getPhoneError() {return phoneError;}
    public void loginWithCallBack(){

        /*LoginRequestBody loginRequestBody = new LoginRequestBody();

        RemoteClient.getInstant().login(loginRequestBody).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

                if (response.body() != null ) {
                    //responseMutableLiveData.setValue(response.body());
                    Log.d("LoginViewModel" , response.body().getAccountName());
                }

            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

                Log.e("LoginViewModel" , t.getMessage());
            }
        });*/
    }

}
