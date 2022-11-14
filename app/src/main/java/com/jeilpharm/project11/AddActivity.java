package com.jeilpharm.project11;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.CalendarView;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.jeilpharm.project11.databinding.ActivityAddBinding;

import java.sql.SQLData;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class AddActivity extends AppCompatActivity {

    ActivityAddBinding binding;

    int category;
    String[] categorytitle= new String[]{"웹심포지움","당일심포지움","숙박심포지움","점심식사","저녁식사","조조판촉","간식"};

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
        binding.tvAddCategory.setOnClickListener(view -> showBottomSheetDialogCategory());
        binding.btnAddSave.setOnClickListener(view -> clicksave());


    }

    void clicksave(){
        SQLiteDatabase db=openOrCreateDatabase("Schedule",MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS schedule(num INTEGER PRIMARY KEY AUTOINCREMENT, hospital TEXT, date TEXT, category INTEGER,note TEXT)");

        String hospital=binding.tvAddHospital.getText().toString();
        String memo=binding.etAddMemo.getText().toString();

        db.execSQL("INSERT INTO schedule(hospital,date,category,note)VALUES(?,?,?,?)", new Object[]{hospital,date,category,memo,0});
        onBackPressed();
    }

    void showBottomSheetDialogCategory(){

        bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(R.layout.bs_category);
        bottomSheetDialog.show();

        bottomSheetDialog.findViewById(R.id.tv_bscategory_websimposium).setOnClickListener(view -> clickCategory(1));
        bottomSheetDialog.findViewById(R.id.tv_bscategory_websimposium).setOnClickListener(view -> clickCategory(2));
        bottomSheetDialog.findViewById(R.id.tv_bscategory_websimposium).setOnClickListener(view -> clickCategory(3));
        bottomSheetDialog.findViewById(R.id.tv_bscategory_websimposium).setOnClickListener(view -> clickCategory(4));
        bottomSheetDialog.findViewById(R.id.tv_bscategory_websimposium).setOnClickListener(view -> clickCategory(5));
        bottomSheetDialog.findViewById(R.id.tv_bscategory_websimposium).setOnClickListener(view -> clickCategory(6));
        bottomSheetDialog.findViewById(R.id.tv_bscategory_websimposium).setOnClickListener(view -> clickCategory(7));

    }

    void clickCategory(int category){
        this.category=category;
        binding.tvAddCategory.setText(categorytitle[category]);

        bottomSheetDialog.dismiss();
    }

    void showBottomSheetDialogCalendar(){
         bottomSheetDialog = new BottomSheetDialog(this);
         bottomSheetDialog.setContentView(R.layout.bs_calendar);
         bottomSheetDialog.show();

         CalendarView calendarView= bottomSheetDialog.findViewById(R.id.bsd_calendar);
         calendarView.setOnDateChangeListener((view,year,month,day)->{
             GregorianCalendar gregorianCalendar= new GregorianCalendar(year,month,day);

             date=new SimpleDateFormat("yyyy년 MM월 dd일").format(gregorianCalendar.getTime());
             binding.tvAddDate.setText(date);

             bottomSheetDialog.dismiss();

         });

    }


}
























































