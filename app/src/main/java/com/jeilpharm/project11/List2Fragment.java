package com.jeilpharm.project11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.jeilpharm.project11.databinding.ActivityMainBinding;

public class List2Fragment extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_list2);

        btn=findViewById(R.id.btn_save_list2);
        btn.setOnClickListener(view -> {
            Intent intent= new Intent(this,ListFragmnet.class);
            startActivity(intent);
        });



    }
}