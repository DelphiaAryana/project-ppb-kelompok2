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

public class DenahWisataKuliner extends AppCompatActivity implements OnMapReadyCallback {

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
                Intent intent = new Intent(DenahWisataKuliner.this, Denah.class);
                startActivity(intent);
            }
        });

        btnWisataReligi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DenahWisataKuliner.this, DenahWisataReligi.class);
                startActivity(intent);
            }
        });

        btnWisataAlam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DenahWisataKuliner.this, DenahWisataAlam.class);
                startActivity(intent);
            }
        });

        btnWisataEdukasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DenahWisataKuliner.this, DenahWisataEdukasi.class);
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

        LatLng location25 = new LatLng(-3.30432587698, 114.613071831);
        MarkerOptions markerOptions25 = new MarkerOptions().position(location25).title("Soto Banjar Bang Amat");
        markerOptions25.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
        googleMap.addMarker(markerOptions25);

        LatLng location26 = new LatLng(	-3.3326626, 114.611726);
        MarkerOptions markerOptions26 = new MarkerOptions().position(location26).title("Kuliner Baiman Banjarmasin");
        markerOptions26.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
        googleMap.addMarker(markerOptions26);

        LatLng location27 = new LatLng(-3.4659295, 114.70732);
        MarkerOptions markerOptions27 = new MarkerOptions().position(location27).title("Danau Wisata Kuliner Cangkir Coffee");
        markerOptions27.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
        googleMap.addMarker(markerOptions27);

        LatLng location28 = new LatLng(-3.4472948,114.8283131);
        MarkerOptions markerOptions28 = new MarkerOptions().position(location28).title("Kampung Pelangi Banjarbaru");
        markerOptions28.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
        googleMap.addMarker(markerOptions28);

        LatLng location29 = new LatLng(-3.3193719,114.5907589);
        MarkerOptions markerOptions29 = new MarkerOptions().position(location29).title("Pasar Terapung Banjarmasin");
        markerOptions29.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
        googleMap.addMarker(markerOptions29);

        LatLng location30 = new LatLng(-3.3053974, 114.6104851);
        MarkerOptions markerOptions30 = new MarkerOptions().position(location30).title("Kawasan Wisata Kuliner Benua Anyar");
        markerOptions30.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
        googleMap.addMarker(markerOptions30);

        LatLng location31 = new LatLng(-3.32205044198, 114.594146643);
        MarkerOptions markerOptions31 = new MarkerOptions().position(location31).title("Kawasan Wisata Kuliner Mandiri");
        markerOptions31.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
        googleMap.addMarker(markerOptions31);

        LatLng location32 = new LatLng(-3.2959592,114.6000025);
        MarkerOptions markerOptions32 = new MarkerOptions().position(location32).title("Rumah Makan Haji Fauzan");
        markerOptions32.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
        googleMap.addMarker(markerOptions32);
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