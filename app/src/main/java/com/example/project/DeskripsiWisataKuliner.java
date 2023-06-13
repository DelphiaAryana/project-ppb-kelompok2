package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.OpenableColumns;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.Map;

public class DeskripsiWisataKuliner extends AppCompatActivity {

    TextView TVnama, TVlokasi, TVdeskripsi;
    private DatabaseReference database;
    String nama, lokasi , deskripsi;
    WisataKulinerModel wisataKuliner;
    String imageName;
    ImageView imagePreview;
    Uri filePath;
    FirebaseStorage storage = FirebaseStorage.getInstance();
    private static final int PICK_IMAGE_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deskripsi_wisata_kuliner);

        //        mengambil textView
        TVnama = findViewById(R.id.nama);
        TVlokasi = findViewById(R.id.lokasi);
        TVdeskripsi = findViewById(R.id.deskripsi);
        imagePreview = findViewById(R.id.imagePreview);

//        menginsialisasi database
        database = FirebaseDatabase.getInstance().getReference();

        Intent intent = getIntent();
        String key = intent.getStringExtra("key");
        if(!key.equals("0")){

//            mengambil 1 data berdasarkan key
            database.child("Wisata Kuliner").child(key).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {

                    String nama = snapshot.child("nama").getValue(String.class);
                    String lokasi = snapshot.child("lokasi").getValue(String.class);
                    String deskripsi = snapshot.child("deskripsi").getValue(String.class);
                    imageName = snapshot.child("image").getValue(String.class);

                    getSupportActionBar().setTitle(nama);
                    TVnama.setText(nama);
                    TVlokasi.setText(lokasi);
                    TVdeskripsi.setText(deskripsi);
                    if (imageName != null) {
                        previewImageUriFromStorage(imageName);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    finish();
                }
            });
            Toast.makeText(this, "key "+ key, Toast.LENGTH_SHORT).show();
        }
    }

    @SuppressLint("Range")
    private String getFileName(Uri uri){
        String result = null;
        if (uri.getScheme().equals("content")){
            Cursor cursor = getContentResolver().query(uri, null, null, null, null);
            try {
                if (cursor != null && cursor.moveToFirst()){
                    result = cursor.getString(cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME));
                }
            } finally {
                if (cursor != null){
                    cursor.close();
                }
            }
        }
        if (result == null){
            result = uri.getPath();
            int cut = result.lastIndexOf('/');
            if (cut != -1){
                result = result.substring(cut+1);
            }
        }
        return result;
    }
    public void previewImageUriFromStorage(String filename){
        StorageReference storageRef = storage.getReference();
        storageRef.child("images").child(filename).getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.get().load(uri).into(imagePreview);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                // Handle any errors
            }
        });
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null){
            filePath = data.getData();
            String fileName = getFileName(filePath);
            // Menampilkan gambar ke preview
            Picasso.get().load(filePath).into(imagePreview);
        }
    }
}