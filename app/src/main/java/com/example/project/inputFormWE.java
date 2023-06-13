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
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.Map;

public class inputFormWE extends AppCompatActivity {
    TextView TVnama, TVlokasi, TVdeskripsi, TvImage;
    private DatabaseReference database;
    String nama, lokasi , deskripsi, imageName;
    Button simpan;
    WisataEdukasiModel wisataEdukasi;
    ImageView imagePreview;
    Uri filePath;
    FirebaseStorage storage = FirebaseStorage.getInstance();
    private static final int PICK_IMAGE_REQUEST = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_form_we);


//        mengambil textView
        TVnama = findViewById(R.id.nama);
        TVlokasi = findViewById(R.id.lokasi);
        TVdeskripsi = findViewById(R.id.deskripsi);;
        TvImage = findViewById(R.id.imageText);
        Button image  = findViewById(R.id.imageButton);
        imagePreview = findViewById(R.id.imagePreview);

        image.setOnClickListener(v->{
            Intent intentMedia = new Intent();
            intentMedia.setType("image/*");
            intentMedia.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(Intent.createChooser(intentMedia,"Select Image"), PICK_IMAGE_REQUEST);

        });
//        menginsialisasi database
        database = FirebaseDatabase.getInstance().getReference();

//        tombol simpan.
        simpan = findViewById(R.id.buttonSimpan);
        Intent intent = getIntent();
        String key = intent.getStringExtra("key");
        if(!key.equals("0")){

//            mengambil 1 data berdasarkan key
            database.child("Wisata Edukasi").child(key).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {

                    String nama = snapshot.child("nama").getValue(String.class);
                    String nim = snapshot.child("lokasi").getValue(String.class);
                    String prodi = snapshot.child("deskripsi").getValue(String.class);
                    imageName = snapshot.child("image").getValue(String.class);

                    getSupportActionBar().setTitle("Edit data " + nama);
                    TVnama.setText(nama);
                    TVlokasi.setText(nim);
                    TVdeskripsi.setText(prodi);

                    if(imageName!=null){
                        TvImage.setText(imageName);
                        previewImageUriFromStorage(imageName);
                    }

                }


                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    finish();
                }
            });
            Toast.makeText(this, "key "+key, Toast.LENGTH_SHORT).show();



            simpan.setOnClickListener(v->{
                nama = TVnama.getText().toString();
                lokasi = TVlokasi.getText().toString();
                deskripsi = TVdeskripsi.getText().toString();
                String newImage = TvImage.getText().toString();
//                membuat hashMap updates yang menyimpan object string
                Map<String, Object> updates = new HashMap<>();
                updates.put("nama", nama);
                updates.put("lokasi", lokasi);
                updates.put("deskripsi", deskripsi);
                Toast.makeText(this, "gile "+filePath, Toast.LENGTH_SHORT).show();
                if(filePath != null){
                    deleteFiles(imageName);
                    uploadImage(filePath);
                    updates.put("image",getFileName(filePath));
                }

//                mengubdate database berdasarkan key
                database.child("Wisata Alam").child(key).updateChildren(updates);
                finish();
            });

        }else{
            getSupportActionBar().setTitle("Tambah Data");



            simpan.setOnClickListener(v->{
                nama = TVnama.getText().toString();
                lokasi = TVlokasi.getText().toString();
                deskripsi = TVdeskripsi.getText().toString();
                WisataEdukasiModel wisataEdukasi = new WisataEdukasiModel("", nama, lokasi, deskripsi);

                if(filePath != null){
                    wisataEdukasi.setImage(getFileName(filePath));
                    uploadImage(filePath);
                }
                submitWisataEdukasi(wisataEdukasi);
                finish();
            });
        }
    }


    public void submitWisataEdukasi(WisataEdukasiModel wisataEdukasi){
        database.child("Wisata Edukasi").push().setValue(wisataEdukasi).addOnSuccessListener(this, new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Toast.makeText(inputFormWE.this, "Berhasil tambah data", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void uploadImage(Uri filePath){
        if (filePath != null) {
            // Mendapatkan referensi Firebase Storage
            StorageReference storageRef = storage.getReference();

            // Membuat referensi ke lokasi penyimpanan yang diinginkan dalam Firebase Storage (misalnya, "images")
            StorageReference imagesRef = storageRef.child("images/" + getFileName(filePath));

            // Melakukan unggakan menggunakan putFile dan menambahkan OnSuccessListener dan OnFailureListener
            imagesRef.putFile(filePath)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            // Unggahan berhasil
                            // Lakukan tindakan yang sesuai, seperti mendapatkan URL unduhan gambar
                            // menggunakan takeSnapshot.getDownloadUrl()
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            // Unggahan gagal
                            // Tangani kegagalan dengan tindakan yang sesuai
                        }
                    });
        }
    }

    @SuppressLint("Range")
    private String getFileName(Uri uri) {
        String result = null;
        if (uri.getScheme().equals("content")) {
            Cursor cursor = getContentResolver().query(uri, null, null, null, null);
            try {
                if (cursor != null && cursor.moveToFirst()) {
                    result = cursor.getString(cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME));
                }
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
        if (result == null) {
            result = uri.getPath();
            int cut = result.lastIndexOf('/');
            if (cut != -1) {
                result = result.substring(cut + 1);
            }
        }
        return result;
    }

    public void deleteFiles(String fileName) {
//        Intent intent = getIntent();
//        String fileName = intent.getStringExtra("fileName");
        StorageReference storageRef = storage.getReference();
        // Create a reference to the file to delete
        StorageReference desertRef = storageRef.child("images/" + fileName);
        desertRef.delete().addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });
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

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            filePath = data.getData();
            String fileName = getFileName(filePath);
            TvImage.setText(fileName);
            // Menampilkan gambar ke preview
            Picasso.get().load(filePath).into(imagePreview);
        }
    }


}