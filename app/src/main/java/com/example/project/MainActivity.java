package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.project.databinding.ActivityMainBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    FirebaseAuth auth;
    Button button, buttonWisataAlam, buttonWisataReligi, buttonWisataEdukasi, buttonWisataKuliner;
    TextView textview;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Wisata KalSel");

        auth = FirebaseAuth.getInstance();
        buttonWisataAlam = findViewById(R.id.btn_wisataalam);
        buttonWisataReligi = findViewById(R.id.btn_wisatareligi);
        buttonWisataEdukasi = findViewById(R.id.btn_wisataedukasi);
        buttonWisataKuliner = findViewById(R.id.btn_wisatakuliner);
        user = auth.getCurrentUser();

        buttonWisataAlam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ListWisataAlam.class));
            }
        });

        buttonWisataReligi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ListWisataReligi.class));
            }
        });

        buttonWisataEdukasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ListWisataEdukasi.class));
            }
        });

        buttonWisataKuliner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ListWisataKuliner.class));
            }
        });
    }
}