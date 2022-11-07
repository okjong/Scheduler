package com.jeilpharm.project11;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.jeilpharm.project11.databinding.ActivityMap2Binding;


public class MapActivity2 extends AppCompatActivity {

    ActivityMap2Binding binding;
    private GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMap2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SupportMapFragment mapFragment= (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map_view);
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(@NonNull GoogleMap googleMap) {

                LatLng mrhi2 = new LatLng(37.5653, 127.0253);

                MarkerOptions marker= new MarkerOptions();
                marker.title("서울");
                marker.snippet("한국의 수도");
                marker.position(mrhi2);
                googleMap.addMarker(marker);

                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(mrhi2,17));

                googleMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
                    @Override
                    public void onInfoWindowClick(@NonNull Marker marker) {
                        Intent intent= new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("www.google.com"));
                        startActivity(intent);
                    }
                });

                UiSettings settings= googleMap.getUiSettings();
                settings.setZoomControlsEnabled(true);

                settings.setMyLocationButtonEnabled(true);

                if (ActivityCompat.checkSelfPermission(MapActivity2.this, Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED){
                    return;
                }
                googleMap.setMyLocationEnabled(true);
            }
        });

        String[] permission= new String[]{Manifest.permission.ACCESS_FINE_LOCATION};
        if (checkSelfPermission(permission[0])==PackageManager.PERMISSION_DENIED) requestPermissions(permission,100);

    }
}