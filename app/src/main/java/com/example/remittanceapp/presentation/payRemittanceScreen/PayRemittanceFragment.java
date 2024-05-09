package com.example.remittanceapp.presentation.payRemittanceScreen;

import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.remittanceapp.R;
import com.example.remittanceapp.databinding.FragmentPayRemittanceBinding;
import com.example.remittanceapp.databinding.FragmentSendRemittanceBinding;
import com.example.remittanceapp.presentation.common.ProgressDialog;
import com.example.remittanceapp.presentation.sendRemittanceScreen.SendRemittanceViewModel;


public class PayRemittanceFragment extends Fragment {

    FragmentPayRemittanceBinding binding;

    PayRemittanceViewModel viewModel;

    private Dialog progressDialog;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_send_remittance, container, false);
        binding = FragmentPayRemittanceBinding.inflate(inflater, container, false);

        progressDialog = ProgressDialog.createProgressDialog(requireActivity());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = new ViewModelProvider(requireActivity()).get(PayRemittanceViewModel.class);
        binding.setViewModel(viewModel);
        binding.setLifecycleOwner(this);

        viewModel.getDialogState().observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean){
                    progressDialog.show();
                }else {
                    progressDialog.dismiss();
                }
            }
        });

        viewModel.getSendState().observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean){
                    //Navigation.findNavController(requireView()).navigateUp();

                }
            }
        });

        viewModel.getSendStateMesssage().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                if (s != ""){
                    Toast.makeText(requireContext(), s, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}