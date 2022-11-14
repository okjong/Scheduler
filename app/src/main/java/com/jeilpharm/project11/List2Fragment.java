package com.jeilpharm.project11;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.jeilpharm.project11.databinding.ActivityMainBinding;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class List2Fragment extends AppCompatActivity {

    ArrayList<List2item> list2items= new ArrayList<>();
    List2Adapter list2Adapter;
    RecyclerView recyclerView;
    Button btn;

    String apikey="266dab6435574f46baa66dd18771c8e9";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_list2);

        recyclerView=findViewById(R.id.recyclerview);
        btn=findViewById(R.id.btn_save_list2);

        list2Adapter = new List2Adapter(this,list2items);
        recyclerView.setAdapter(list2Adapter);

        findViewById(R.id.btn_load_list2).setOnClickListener(view -> {

            Thread thread= new Thread(){
                @Override
                public void run() {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            list2items.clear();
                            list2Adapter.notifyDataSetChanged();
                        }
                    });

                    String address= "https://openapi.gg.go.kr/PrivateHospital"
                            +"?key="+apikey;

                    try {
                        URL url= new URL(address);
                        InputStream is= url.openStream();
                        InputStreamReader isr= new InputStreamReader(is);

                        XmlPullParserFactory factory=XmlPullParserFactory.newInstance();
                        XmlPullParser xpp= factory.newPullParser();

                        xpp.setInput(isr);

                        int eventType = xpp.getEventType();
                        List2item list2item=null;

                        while (eventType!= XmlPullParser.END_DOCUMENT){
                            switch (eventType){
                                case XmlPullParser.START_DOCUMENT:
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            Toast.makeText(List2Fragment.this, "파싱시작", Toast.LENGTH_SHORT).show();

                                        }
                                    });

                                    break;

                                    case XmlPullParser.START_TAG:
                                        String tagName= xpp.getName();
                                        if (tagName.equals("row")){
                                            list2item=new List2item();
                                        }
                                        else if (tagName.equals("LICENSG_DE")){
                                            xpp.next();
                                            list2item.tvNum=xpp.getText();
                                        }
                                        else if (tagName.equals("SIGUN_NM")){
                                            xpp.next();
                                            list2item.tvSigun=xpp.getText();
                                        }else if (tagName.equals("BIZPLC_NM")){
                                            xpp.next();
                                            list2item.tvName=xpp.getText();
                                        }
                                        break;

                                        case XmlPullParser.TEXT:
                                            break;

                                            case XmlPullParser.END_TAG:
                                                if (xpp.getName().equals("row")){
                                                    list2items.add(list2item);
                                                }
                                                break;

                            }
                            eventType=xpp.next();
                        }

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(List2Fragment.this, "개 :"+list2items.size(), Toast.LENGTH_SHORT).show();
                                list2Adapter.notifyDataSetChanged();
                            }
                        });


                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (XmlPullParserException e) {
                        e.printStackTrace();
                    }
                }
            };
            thread.start();

        });
    }
}



























































