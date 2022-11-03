package com.jeilpharm.project11;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.jeilpharm.project11.databinding.ActivityIntroBinding;

public class Intro extends AppCompatActivity {

    ActivityIntroBinding binding;

    String profileImage="";
    String name="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityIntroBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnIntroStart.setOnClickListener(view -> {
            savedata();

            Intent intent= new Intent(Intro.this,MainActivity.class);
            startActivity(intent);
            finish();
        });

        binding.ivCircle.setOnClickListener(view -> {

            Intent intent= new Intent(Intent.ACTION_PICK);
            intent.setType("image/*");
            launcher.launch(intent);

        });

        loadData();


    }//oncreate....

    void loadData(){

        SharedPreferences pref=getSharedPreferences("Data", MODE_PRIVATE);

        profileImage= pref.getString("profile","");
        name=pref.getString("name","");
        Glide.with(Intro.this).load(profileImage).into(binding.ivCircle);
        binding.etNicname.setText(name);

    }

    void savedata(){
        name = binding.etNicname.getText().toString();

        SharedPreferences pref=getSharedPreferences("account",MODE_PRIVATE);
        SharedPreferences.Editor editor= pref.edit();
        editor.putString("profile",profileImage);
        editor.putString("name",name);

        editor.commit();
    }



    ActivityResultLauncher launcher= registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if (result.getResultCode()!=RESULT_CANCELED){
                Intent intent= result.getData();
                Uri uri= intent.getData();
                Glide.with(Intro.this).load(uri).into(binding.ivCircle);

            }

        }
    });



}




































































