package com.example.project;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class DenahWisataReligi extends AppCompatActivity implements OnMapReadyCallback {

    private MapView mapView;
    private GoogleMap googleMap;
    private Button btnAll, btnWisataAlam, btnWisataReligi, btnWisataEdukasi, btnWisataKuliner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_denah_wisata_edukasi);

        mapView = findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);

        btnAll = findViewById(R.id.btnAll);
        btnWisataAlam = findViewById(R.id.btnWisataAlam);
        btnWisataReligi = findViewById(R.id.btnWisataReligi);
        btnWisataEdukasi = findViewById(R.id.btnWisataEdukasi);
        btnWisataKuliner = findViewById(R.id.btnWisataKuliner);

        btnAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DenahWisataReligi.this, Denah.class);
                startActivity(intent);
            }
        });

        btnWisataKuliner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DenahWisataReligi.this, DenahWisataKuliner.class);
                startActivity(intent);
            }
        });

        btnWisataAlam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DenahWisataReligi.this, DenahWisataAlam.class);
                startActivity(intent);
            }
        });

        btnWisataEdukasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DenahWisataReligi.this, DenahWisataEdukasi.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap map) {
        googleMap = map;

        // Mengatur tipe peta menjadi peta jalan
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        // Mengatur koordinat tengah peta
        LatLng center = new LatLng(-3.316694, 114.590111);
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(center, 5));

        LatLng location9 = new LatLng(-3.31905993755, 114.590893332);
        MarkerOptions markerOptions9 = new MarkerOptions().position(location9).title("Masjid Raya Sabilal Muhtadin");
        markerOptions9.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
        googleMap.addMarker(markerOptions9);

        LatLng location10 = new LatLng(-3.3065505, 114.5954182);
        MarkerOptions markerOptions10 = new MarkerOptions().position(location10).title("Masjid Jami Sungai Jingah");
        markerOptions10.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
        googleMap.addMarker(markerOptions10);

        LatLng location11 = new LatLng(-3.30602, 114.59709);
        MarkerOptions markerOptions11 = new MarkerOptions().position(location11).title("Makam Pangeran Antasari");
        markerOptions11.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
        googleMap.addMarker(markerOptions11);

        LatLng location12 = new LatLng(-3.3065519, 114.6103708);
        MarkerOptions markerOptions12 = new MarkerOptions().position(location12).title("Makam Datu Amin");
        markerOptions12.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
        googleMap.addMarker(markerOptions12);

        LatLng location13 = new LatLng(-3.3125421, 114.5995975);
        MarkerOptions markerOptions13 = new MarkerOptions().position(location13).title("Makam Guru Surgi Mufti");
        markerOptions13.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
        googleMap.addMarker(markerOptions13);

        LatLng location14 = new LatLng(-3.42738720504, 114.854938167);
        MarkerOptions markerOptions14 = new MarkerOptions().position(location14).title("Kubah Guru Sekumpul");
        markerOptions14.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
        googleMap.addMarker(markerOptions14);

        LatLng location15 = new LatLng(-3.346162, 114.5645516);
        MarkerOptions markerOptions15 = new MarkerOptions().position(location15).title("Kubah Basirih");
        markerOptions15.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
        googleMap.addMarker(markerOptions15);

        LatLng location16 = new LatLng(-3.3207786, 114.5943536);
        MarkerOptions markerOptions16 = new MarkerOptions().position(location16).title("Klenteng Suci Nurani");
        markerOptions16.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
        googleMap.addMarker(markerOptions16);
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

}