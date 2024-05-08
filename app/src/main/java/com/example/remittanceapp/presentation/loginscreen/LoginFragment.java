package com.example.remittanceapp.presentation.loginscreen;

import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.remittanceapp.R;
import com.example.remittanceapp.databinding.FragmentLoginBinding;
import com.example.remittanceapp.domain.model.LoginResponse;
import com.example.remittanceapp.presentation.common.ProgressDialog;
import com.example.remittanceapp.presentation.sendRemittanceScreen.SendRemittanceFragment;

import java.util.Objects;


public class LoginFragment extends Fragment {

    LoginViewModel loginViewModel;
    FragmentLoginBinding binding ;

    private Dialog progressDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_login, container, false);

        binding = FragmentLoginBinding.inflate(inflater, container, false);
        //View view = binding.getRoot();
        progressDialog = ProgressDialog.createProgressDialog(requireActivity());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        loginViewModel = new ViewModelProvider(requireActivity()).get(LoginViewModel.class);
        binding.setViewModel(loginViewModel);
        binding.setLifecycleOwner(this);



        loginViewModel.getLoginState().observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean){
                    Navigation.findNavController(requireView()).navigate(R.id.action_loginFragment_to_mainFragment);
                }
            }
        });

        loginViewModel.getDialogState().observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean){
                    progressDialog.show();
                }else {
                    progressDialog.dismiss();
                }
            }
        });

        loginViewModel.getLoginError().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                if (s != ""){
                    Toast.makeText(requireContext(), s, Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}