package com.example.remittanceapp.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.remittanceapp.R;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {
    //LoginViewModel loginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the Binding File
        //ActivityMainBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

    }

}