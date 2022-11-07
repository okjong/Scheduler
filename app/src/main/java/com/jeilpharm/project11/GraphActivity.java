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

        ArrayList<BarEntry> result= new ArrayList<>();
        result.add(new BarEntry(1,200));
        result.add(new BarEntry(2,300));
        result.add(new BarEntry(3,400));
        result.add(new BarEntry(4,300));
        result.add(new BarEntry(5,100));
        result.add(new BarEntry(6,500));

        BarDataSet barDataSet= new BarDataSet(result,"result");
        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        barDataSet.setValueTextColor(Color.BLACK);
        barDataSet.setValueTextSize(16f);

        BarData barData= new BarData(barDataSet);

        barChart.setFitBars(true);
        barChart.setData(barData);
        barChart.animateY(2000);


    }
}