package com.jeilpharm.project11;

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
import androidx.fragment.app.Fragment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MonthFragment extends Fragment {

    public String readDay = null;
    public String str = null;
    public CalendarView calendarView;
    public Button cha_Btn, del_Btn, save_Btn;
    public TextView diaryTextView, textView2, textView3;
    public EditText contextEditText;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_month,container,false);


        calendarView=view.findViewById(R.id.calendarView);
        cha_Btn=view.findViewById(R.id.cha_Btn);
        del_Btn=view.findViewById(R.id.del_Btn);
        save_Btn=view.findViewById(R.id.save_Btn);
        diaryTextView=view.findViewById(R.id.diaryTextView);
        textView2=view.findViewById(R.id.textView2);
        textView3=view.findViewById(R.id.textView3);
        contextEditText=view.findViewById(R.id.contextEditText);

        calendarView.setOnDateChangeListener((calendarView1, year, month, dayOfMonth) -> {
            diaryTextView.setVisibility(View.VISIBLE);
            save_Btn.setVisibility(View.VISIBLE);
            contextEditText.setVisibility(View.VISIBLE);
            textView2.setVisibility(View.VISIBLE);
            cha_Btn.setVisibility(View.INVISIBLE);
            del_Btn.setVisibility(View.INVISIBLE);
            diaryTextView.setText(String.format(year +"/"+month+"/"+dayOfMonth));
            contextEditText.setText("");
            checkday(year,month,dayOfMonth);
        });

        save_Btn.setOnClickListener(view1 -> {
            savediary(readDay);
            str=contextEditText.getText().toString();
            textView2.setText(str);
            save_Btn.setVisibility(View.INVISIBLE);
            cha_Btn.setVisibility(View.VISIBLE);
            del_Btn.setVisibility(View.VISIBLE);
            contextEditText.setVisibility(View.INVISIBLE);
            textView2.setVisibility(View.VISIBLE);
        });

        return view;

    }

    public void checkday(int cyear,int cmonth,int cday){
        readDay=""+cyear+"-"+(cmonth+1)+"-"+cday+".txt";
        try {
            FileInputStream fis= new FileInputStream(readDay);
            byte[] Filedata= new byte[fis.available()];
            fis.read(Filedata);
            fis.close();

            str= new String(Filedata);

            contextEditText.setVisibility(View.INVISIBLE);
            textView2.setVisibility(View.VISIBLE);
            textView2.setText(str);

            save_Btn.setVisibility(View.INVISIBLE);
            del_Btn.setVisibility(View.VISIBLE);
            cha_Btn.setVisibility(View.VISIBLE);

            cha_Btn.setOnClickListener(view -> {
                contextEditText.setVisibility(View.VISIBLE);
                textView2.setVisibility(View.INVISIBLE);
                contextEditText.setText(str);

                save_Btn.setVisibility(View.VISIBLE);
                cha_Btn.setVisibility(View.INVISIBLE);
                del_Btn.setVisibility(View.INVISIBLE);
                textView2.setText(contextEditText.getText());
            });

            del_Btn.setOnClickListener(view -> {
                textView2.setVisibility(View.INVISIBLE);
                contextEditText.setText("");
                contextEditText.setVisibility(View.VISIBLE);
                save_Btn.setVisibility(View.VISIBLE);
                cha_Btn.setVisibility(View.INVISIBLE);
                del_Btn.setVisibility(View.INVISIBLE);
                removediary(readDay);
            });

            if (textView2.getText()==null){
                textView2.setVisibility(View.INVISIBLE);
                diaryTextView.setVisibility(View.VISIBLE);
                save_Btn.setVisibility(View.VISIBLE);
                cha_Btn.setVisibility(View.INVISIBLE);
                del_Btn.setVisibility(View.INVISIBLE);
                contextEditText.setVisibility(View.VISIBLE);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void removediary(String readDay){
        try {
            FileOutputStream fos= new FileOutputStream(readDay);
            String content = "";
            fos.write(content.getBytes());
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void savediary(String readDay)  {
        try {
            FileOutputStream fos= new FileOutputStream(readDay);
            String content = contextEditText.getText().toString();
            fos.write(content.getBytes());
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
