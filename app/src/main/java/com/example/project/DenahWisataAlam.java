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
public class DenahWisataAlam extends AppCompatActivity implements OnMapReadyCallback {
    private MapView mapView;
    private GoogleMap googleMap;
    private Button btnAll, btnWisataAlam, btnWisataReligi, btnWisataEdukasi, btnWisataKuliner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_denah_wisata_alam);

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
                Intent intent = new Intent(DenahWisataAlam.this, Denah.class);
                startActivity(intent);
            }
        });

        btnWisataReligi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DenahWisataAlam.this, DenahWisataReligi.class);
                startActivity(intent);
            }
        });

        btnWisataEdukasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DenahWisataAlam.this, DenahWisataEdukasi.class);
                startActivity(intent);
            }
        });

        btnWisataKuliner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DenahWisataAlam.this, DenahWisataKuliner.class);
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

        LatLng location1 = new LatLng(-3.7709309, 115.5951221);
        MarkerOptions markerOptions1 = new MarkerOptions().position(location1).title("Pantai Angsana");
        markerOptions1.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
        googleMap.addMarker(markerOptions1);

        LatLng location2 = new LatLng(-3.4512244, 115.5681084);
        MarkerOptions markerOptions2 = new MarkerOptions().position(location2).title("Pantai Pagatan");
        markerOptions2.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
        googleMap.addMarker(markerOptions2);

        LatLng location3 = new LatLng(-3.15605, 114.50814);
        MarkerOptions markerOptions3 = new MarkerOptions().position(location3).title("Mt. Halau-Halau");
        markerOptions3.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
        googleMap.addMarker(markerOptions3);

        LatLng location4 = new LatLng(-4.04933883052, 116.052889221);
        MarkerOptions markerOptions4 = new MarkerOptions().position(location4).title("Teluk Tamiang");
        markerOptions4.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
        googleMap.addMarker(markerOptions4);

        LatLng location5 = new LatLng(-3.31757174029, 114.589279934);
        MarkerOptions markerOptions5 = new MarkerOptions().position(location5).title("Pulau Samber Gelap");
        markerOptions5.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
        googleMap.addMarker(markerOptions5);

        LatLng location6 = new LatLng(-3.32396, 114.612015);
        MarkerOptions markerOptions6 = new MarkerOptions().position(location6).title("Air Terjun Bajuin");
        markerOptions6.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
        googleMap.addMarker(markerOptions6);

        LatLng location7 = new LatLng(-3.12548667, 115.17680333);
        MarkerOptions markerOptions7 = new MarkerOptions().position(location7).title("Goa Batu Hapu");
        markerOptions7.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
        googleMap.addMarker(markerOptions7);

        LatLng location8 = new LatLng(-3.33333, 114.583);
        MarkerOptions markerOptions8 = new MarkerOptions().position(location8).title("Bukit Matang Kaladan");
        markerOptions8.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
        googleMap.addMarker(markerOptions8);
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