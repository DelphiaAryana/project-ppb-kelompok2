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

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Admin extends AppCompatActivity {

    FirebaseAuth auth;
    Button button, buttonWisataAlam, buttonWisataReligi, buttonWisataEdukasi, buttonWisataKuliner;
    TextView textview;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        getSupportActionBar().setTitle("Halaman Admin");

        auth = FirebaseAuth.getInstance();
        buttonWisataAlam = findViewById(R.id.btn_wisataalam);
        buttonWisataReligi = findViewById(R.id.btn_wisatareligi);
        buttonWisataEdukasi = findViewById(R.id.btn_wisataedukasi);
        buttonWisataKuliner = findViewById(R.id.btn_wisatakuliner);
        textview = findViewById(R.id.user_details);
        button = findViewById(R.id.logout);
        user = auth.getCurrentUser();

        if (user == null){
            Intent intent = new Intent(getApplicationContext(), Login.class);
            startActivity(intent);
            finish();
        }
        else {
            textview.setText(user.getEmail());
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
                finish();
            }
        });

        buttonWisataAlam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Admin.this, WisataAlamAdmin.class));
            }
        });

        buttonWisataReligi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Admin.this, WisataReligiAdmin.class));
            }
        });

        buttonWisataEdukasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Admin.this, WisataEdukasiAdmin.class));
            }
        });

        buttonWisataKuliner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Admin.this, WisataKulinerAdmin.class));
            }
        });
    }
}