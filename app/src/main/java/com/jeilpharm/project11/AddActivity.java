package com.jeilpharm.project11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CalendarView;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.jeilpharm.project11.databinding.ActivityAddBinding;

import java.text.SimpleDateFormat;
import java.util.Date;

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
        binding.tvAddCategory.setText(categorytitle[category]);

        date=new SimpleDateFormat("yyyy년MM월dd일").format(new Date());
        binding.tvAddDate.setText(date);

        binding.tvAddDate.setOnClickListener(view -> showBottomSheetDialogCalendar());



    }

    void showBottomSheetDialogCalendar(){
         bottomSheetDialog = new BottomSheetDialog(this);
         bottomSheetDialog.setContentView(R.layout.bs_calendar);
         bottomSheetDialog.show();

        CalendarView calendarView= bottomSheetDialog.findViewById(R.id.calendarView);
    }


}
























































