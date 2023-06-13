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

public class DenahWisataEdukasi extends AppCompatActivity implements OnMapReadyCallback {

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
                Intent intent = new Intent(DenahWisataEdukasi.this, Denah.class);
                startActivity(intent);
            }
        });

        btnWisataReligi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DenahWisataEdukasi.this, DenahWisataReligi.class);
                startActivity(intent);
            }
        });

        btnWisataAlam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DenahWisataEdukasi.this, DenahWisataAlam.class);
                startActivity(intent);
            }
        });

        btnWisataKuliner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DenahWisataEdukasi.this, DenahWisataKuliner.class);
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
        LatLng center = new LatLng(-3.092642, 115.283758);
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(center, 5));

        LatLng location17 = new LatLng(-3.4612991, 114.8111991);
        MarkerOptions markerOptions17 = new MarkerOptions().position(location17).title("Amanah Borneo Park");
        markerOptions17.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
        googleMap.addMarker(markerOptions17);

        LatLng location18 = new LatLng(-3.3171088, 114.5908798);
        MarkerOptions markerOptions18 = new MarkerOptions().position(location18).title("Taman PKK Banjarmasin");
        markerOptions18.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
        googleMap.addMarker(markerOptions18);

        LatLng location19 = new LatLng(-3.30385277778, 114.609069444);
        MarkerOptions markerOptions19 = new MarkerOptions().position(location19).title("Museum Wasaka");
        markerOptions19.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
        googleMap.addMarker(markerOptions19);

        LatLng location20 = new LatLng(-3.5319977,114.8888879);
        MarkerOptions markerOptions20 = new MarkerOptions().position(location20).title("Alaska Park");
        markerOptions20.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
        googleMap.addMarker(markerOptions20);

        LatLng location21 = new LatLng(	-3.32163085658, 114.586961296);
        MarkerOptions markerOptions21 = new MarkerOptions().position(location21).title("Taman Kamboja");
        markerOptions21.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
        googleMap.addMarker(markerOptions21);

        LatLng location22 = new LatLng(-3.3184996, 114.5925817);
        MarkerOptions markerOptions22 = new MarkerOptions().position(location22).title("Taman Siring 0km Banjarmasin");
        markerOptions22.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
        googleMap.addMarker(markerOptions22);

        LatLng location23 = new LatLng(-3.4486, 114.8057);
        MarkerOptions markerOptions23 = new MarkerOptions().position(location23).title("Kiram Park Banjarbaru");
        markerOptions23.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
        googleMap.addMarker(markerOptions23);

        LatLng location24 = new LatLng(-3.463109, 114.776734);
        MarkerOptions markerOptions24 = new MarkerOptions().position(location24).title("Aquatica Waterpark & Playground");
        markerOptions24.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
        googleMap.addMarker(markerOptions24);
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