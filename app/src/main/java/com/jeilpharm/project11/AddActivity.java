package com.jeilpharm.project11;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.renderscript.ScriptGroup;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.jeilpharm.project11.databinding.ActivityAddBinding;

public class AddActivity extends AppCompatActivity {

    ActivityAddBinding binding;

    int category;
    String[] categorytitle= new String[]{"웹심포지움","저녁세미나","숙박심포지움","점심식사","저녁식사","조조판촉","간식"};

    String date="2022년11월3일(수) 22:00PM";

    BottomSheetDialog bottomSheetDialog = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityAddBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("일정 추가");

        category=getIntent().getIntExtra("category",0);



    }
}