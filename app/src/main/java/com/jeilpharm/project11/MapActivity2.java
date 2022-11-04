package com.jeilpharm.project11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.jeilpharm.project11.databinding.ActivityMap2Binding;


public class MapActivity2 extends AppCompatActivity {

    ActivityMap2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMap2Binding.inflate(getLayoutInflater());
        setContentView(binding.mapContainer);




    }
}