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

    @Inject
    public IncomingSystemFeeUseCase(
            Repository repository
    ) {
        this.repository = repository;
    }

    /**
     * This method retrieves the system fee ID witch we need it in (SendRemittance) use case.
     *
     * @return A Single<Integer> representing the system fee ID.
     */
    public Single<Integer> getSystemFeeID(){

        return repository.incomingSystemFee(new IncomeFeeRequestBody())
                .subscribeOn(Schedulers.io())
                .map(incomingFee -> incomingFee.getSearchData().getFeeId());
    }

}
