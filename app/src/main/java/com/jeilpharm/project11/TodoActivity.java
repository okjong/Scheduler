package com.jeilpharm.project11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.jeilpharm.project11.databinding.ActivityTodoBinding;

public class TodoActivity extends AppCompatActivity {

    ActivityTodoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityTodoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



    }
}