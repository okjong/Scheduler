package com.jeilpharm.project11;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupMenu;
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


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvTitle=view.findViewById(R.id.tv_title);
        tvList=view.findViewById(R.id.tv_list);
        btnSet=view.findViewById(R.id.btn_set);

        btnSet.setOnClickListener(view1 -> {
            Intent intent= new Intent(getActivity(),List2Fragment.class);
            startActivity(intent);
        });


        tvList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PopupMenu popupMenu= new PopupMenu(getActivity(),tvList);
                MenuInflater inflater= popupMenu.getMenuInflater();
                inflater.inflate(R.menu.popup_list, popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {

                        switch (menuItem.getItemId()){
                            case R.id.popup_schedule:
                                Intent intent= new Intent(getActivity(),ScheduleActivity.class);
                                startActivity(intent);
                                break;
                            case R.id.popup_graph:
                                Intent intent1= new Intent(getActivity(),GraphActivity.class);
                                startActivity(intent1);
                                break;
                            case R.id.popup_location:
                                Intent intent2= new Intent(getActivity(),MapActivity2.class);
                                startActivity(intent2);
                                break;
                        }



                        return false;
                    }
                });

                popupMenu.show();


            }
        });




    }
}























































































