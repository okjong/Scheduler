package com.jeilpharm.project11;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentManager;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.jeilpharm.project11.databinding.ActivityMap2Binding;

import java.util.List;


public class MapActivity2 extends AppCompatActivity {

    ActivityMap2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMap2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // xml에 추가한 SupportMapFragment 를 찾아와서 참조하기
        FragmentManager fm = getSupportFragmentManager();
        SupportMapFragment mapFragment = (SupportMapFragment) fm.findFragmentById(R.id.map);

        // 비동기 방식(Thread를 이용)으로 구글 서버에서 맴의 데이터를 읽어오도록...
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(@NonNull GoogleMap googleMap) {
                // 여기가 실행된다면 지도 데이터가 온저히 잘 불러진것임.

                // 마커가 표시될 좌표객체
                LatLng mrhi = new LatLng(37.5653, 127.0253);

                //마커객체
                MarkerOptions marker = new MarkerOptions();
                marker.title("미래IT캠퍼스");
                marker.snippet("왕십리에 있는 미래IT캠퍼스");
                marker.position(mrhi);

                googleMap.addMarker(marker);

                // 지도를 원하는 위치로 이동 [ 지도를 보여주는 카메라 이동 ]
                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(mrhi, 17));//줌 :1~25

                // 마커를 클릭시에 보여지는 InfoWindow(툴팁박스) 를 클릭했을때 반응하기
                googleMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
                    @Override
                    public void onInfoWindowClick(@NonNull Marker marker) {

                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("http://www.mrhi.or.kr"));
                        startActivity(intent);
                    }
                });

                UiSettings settings = googleMap.getUiSettings();
                settings.setZoomControlsEnabled(true);


                settings.setMyLocationButtonEnabled(true);

                if (ActivityCompat.checkSelfPermission(MapActivity2.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(MapActivity2.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                googleMap.setMyLocationEnabled(true);

            }
        });


        // 내 위치정보제공에 대한 동적퍼미션
        String[] permissions= new String[]{Manifest.permission.ACCESS_FINE_LOCATION};
        if( checkSelfPermission(permissions[0]) == PackageManager.PERMISSION_DENIED) requestPermissions(permissions, 100);

    }//onCreate method..

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==100 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
            Toast.makeText(this, "내 위치 탐색 허용", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "내 위치 탐색 불허", Toast.LENGTH_SHORT).show();
        }

    }

    }


