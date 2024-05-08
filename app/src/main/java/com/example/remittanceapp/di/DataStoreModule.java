package com.example.remittanceapp.di;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class DataStoreModule {

    @Provides
    @Singleton
    public static SharedPreferences providePreferencesData(Application application) {
        return application.getSharedPreferences("user_data_prefs", Context.MODE_PRIVATE);
    }

    @Provides
    @Singleton
    public static Gson provideGson() {
        return new Gson();
    }

}
