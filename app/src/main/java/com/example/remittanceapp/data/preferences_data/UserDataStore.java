package com.example.remittanceapp.data.preferences_data;

import android.content.SharedPreferences;

import com.example.remittanceapp.domain.model.UserData;
import com.google.gson.Gson;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;

public class UserDataStore {

    private SharedPreferences sharedPreferences;
    private Gson gson;

    @Inject
    public UserDataStore(SharedPreferences sharedPreferences, Gson gson) {
        this.sharedPreferences = sharedPreferences;
        this.gson = gson;
    }

    public Completable saveUserData(UserData userData) {
        return Completable.fromAction(() -> {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            String userDataJson = gson.toJson(userData);
            editor.putString("user_data", userDataJson);
            editor.apply();
        });
    }

    public Single<UserData> getUserData() {
        return Single.fromCallable(() -> {
            String userDataJson = sharedPreferences.getString("user_data", null);
            if (userDataJson != null) {
                return gson.fromJson(userDataJson, UserData.class);
            } else {
                return new UserData();
            }
        });
    }

    public UserData returnUserData() {
        String userDataJson = sharedPreferences.getString("user_data", null);
        if (userDataJson != null) {
            return gson.fromJson(userDataJson, UserData.class);
        } else {
            return new UserData();
        }
    }

    public String getUserToken() {
        UserData userData = returnUserData();
        return userData.getToken();
    }

}
