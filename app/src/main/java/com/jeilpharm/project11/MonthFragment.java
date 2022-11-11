package com.jeilpharm.project11;

import android.content.Intent;
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
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class MonthFragment extends Fragment {

    MaterialCalendarView materialCalendarView;
    ArrayList<Item> items= new ArrayList<>();
    TodoRecyclerAdapter adapter;
    RecyclerView recyclerView;

    int category=0;
    String[] categorytitle= new String[]{"웹심포지움","당일심포지움","숙박심포지움","점심식사","저녁식사","조조판촉","간식"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_month,container,false);

        Intent intent= new Intent();
        category=intent.getIntExtra("category",0);

        materialCalendarView=view.findViewById(R.id.calendarView);
        recyclerView=view.findViewById(R.id.recyclerview);
        adapter= new TodoRecyclerAdapter(getActivity(),items);
        recyclerView.setAdapter(adapter);



        return view;

    }
}




















































































