package com.jeilpharm.project11;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.jeilpharm.project11.databinding.ActivityGraphBinding;

import java.util.ArrayList;

public class GraphActivity extends AppCompatActivity {

    ActivityGraphBinding binding;

    BarChart barChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityGraphBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

       barChart=findViewById(R.id.barchart);

       ArrayList<BarEntry> barEntries= new ArrayList<>();

       barEntries.add(new BarEntry(1,20));
       barEntries.add(new BarEntry(2,30));
       barEntries.add(new BarEntry(3,40));
       barEntries.add(new BarEntry(4,50));
       barEntries.add(new BarEntry(5,60));
       barEntries.add(new BarEntry(6,40));
       barEntries.add(new BarEntry(7,20));

       BarDataSet barDataSet= new BarDataSet(barEntries,"barEntries");
       barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
       barDataSet.setValueTextSize(16f);

       BarData barData= new BarData(barDataSet);

       barChart.invalidate();
       barChart.setData(barData);



    }
}