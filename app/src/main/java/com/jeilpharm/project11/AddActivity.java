package com.jeilpharm.project11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.jeilpharm.project11.databinding.ActivityAddBinding;

public class AddActivity extends AppCompatActivity {

    ActivityAddBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityAddBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



    }
}