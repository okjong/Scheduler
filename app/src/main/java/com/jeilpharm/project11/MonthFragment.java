package com.jeilpharm.project11;

import static android.content.Context.MODE_APPEND;
import static android.content.Context.MODE_PRIVATE;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.datepicker.MaterialCalendar;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

public class MonthFragment extends Fragment {

    MaterialCalendarView calendarView;
    ArrayList<Item> items= new ArrayList<>();
    TodoRecyclerAdapter adapter;
    RecyclerView recyclerView;
    Button btn;


    int category=0;
    String[] categorytitle= new String[]{"웹심포지움","당일심포지움","숙박심포지움","점심식사","저녁식사","조조판촉","간식"};
    
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_month,container,false);

        btn=view.findViewById(R.id.btn_done);
        calendarView=view.findViewById(R.id.month_calendarview);
        recyclerView=view.findViewById(R.id.recyclerview);
        adapter= new TodoRecyclerAdapter(getActivity(),items);
        recyclerView.setAdapter(adapter);

        clickDate();

        return view;

    }

    void clickDate(){
        calendarView.setOnDateChangedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
                items.clear();
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                SQLiteDatabase db= SQLiteDatabase.openOrCreateDatabase("Schedule",null);



            }
        });
    }


    }























































































