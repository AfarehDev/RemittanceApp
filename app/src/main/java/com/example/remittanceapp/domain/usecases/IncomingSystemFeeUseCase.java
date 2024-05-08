package com.example.remittanceapp.domain.usecases;

import android.annotation.SuppressLint;

import com.example.remittanceapp.data.preferences_data.UserDataStore;
import com.example.remittanceapp.data.repo.Repository;
import com.example.remittanceapp.domain.model.IncomeFeeRequestBody;
import com.example.remittanceapp.domain.utils.ResponseState;

import javax.inject.Inject;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class IncomingSystemFeeUseCase {

    private Repository repository;
    private UserDataStore userDataStore;

    @Inject
    public IncomingSystemFeeUseCase(
            Repository repository,
            UserDataStore userDataStore
    ) {
        this.userDataStore = userDataStore;
        this.repository = repository;
    }

    public Single<Integer> getSystemFeeID(){

        return repository.incomingSystemFee(new IncomeFeeRequestBody())
                .subscribeOn(Schedulers.io())
                .map(incomingFee -> incomingFee.getSearchData().getFeeId());
    }

}
