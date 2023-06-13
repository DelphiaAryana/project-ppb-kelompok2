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

public class Denah extends AppCompatActivity implements OnMapReadyCallback {
    private MapView mapView;
    private GoogleMap googleMap;
    private Button btnAll, btnWisataAlam, btnWisataReligi, btnWisataEdukasi, btnWisataKuliner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_denah);

        mapView = findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);

        btnAll = findViewById(R.id.btnAll);
        btnWisataAlam = findViewById(R.id.btnWisataAlam);
        btnWisataReligi = findViewById(R.id.btnWisataReligi);
        btnWisataEdukasi = findViewById(R.id.btnWisataEdukasi);
        btnWisataKuliner = findViewById(R.id.btnWisataKuliner);

        btnWisataAlam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Denah.this, DenahWisataAlam.class);
                startActivity(intent);
            }
        });

        btnWisataReligi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Denah.this, DenahWisataReligi.class);
                startActivity(intent);
            }
        });

        btnWisataEdukasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Denah.this, DenahWisataEdukasi.class);
                startActivity(intent);
            }
        });

        btnWisataKuliner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Denah.this, DenahWisataKuliner.class);
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