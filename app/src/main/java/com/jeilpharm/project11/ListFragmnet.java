package com.jeilpharm.project11;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.jeilpharm.project11.databinding.FragmentListBinding;

public class ListFragmnet extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list,container,false);
    }

    TextView tvTitle;
    TextView tvList;
    Button btnSet;
    Context context;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvTitle=view.findViewById(R.id.tv_title);
        tvList=view.findViewById(R.id.tv_list);
        btnSet=view.findViewById(R.id.btn_set);

        btnSet.setOnClickListener(view1 -> {
            Intent intent= new Intent(context,List2Fragment.class);
            startActivity(intent);
        });

        //fragment는 context가 없음.

    }
}
