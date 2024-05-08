package com.example.remittanceapp.presentation.mainScreen;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.remittanceapp.R;
import com.example.remittanceapp.databinding.FragmentLoginBinding;
import com.example.remittanceapp.databinding.FragmentMainBinding;
import com.example.remittanceapp.presentation.common.ProgressDialog;


public class MainFragment extends Fragment {


    FragmentMainBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_main, container, false);

        binding = FragmentMainBinding.inflate(inflater, container, false);
        //View view = binding.getRoot();
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.sendRemCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(requireView()).navigate(R.id.action_mainFragment_to_sendRemittanceFragment);
            }
        });
    }
}