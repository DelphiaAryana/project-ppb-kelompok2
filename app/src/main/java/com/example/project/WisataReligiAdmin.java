package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

public class WisataReligiAdmin extends AppCompatActivity {

    private DatabaseReference database;
    ListView listView;
    FloatingActionButton FAB;
    private ArrayList<WisataReligiModel> listWisataReligi;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wisata_religi_admin);
        listView = findViewById(R.id.itemsList);
        FAB = findViewById(R.id.tambahData);
        getSupportActionBar().setTitle("Wisata Religi Kalsel");

//        menginsiasi database Firebase
        database = FirebaseDatabase.getInstance().getReference();
        populateDataWisataReligi();
        FAB.setOnClickListener(v -> {
            Intent intent = new Intent(WisataReligiAdmin.this, inputFormWR.class);
            intent.putExtra("key", "0");
            startActivity(intent);
        });


    }

    public void populateListview() {
        try {
            ItemListAdapterWR itemsAdopter = new ItemListAdapterWR(this, listWisataReligi);
            listView.setAdapter(itemsAdopter);
            itemsAdopter.notifyDataSetChanged();
            registerForContextMenu(listView);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void populateDataWisataReligi() {
        database.child("Wisata Religi").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listWisataReligi= new ArrayList<>();
                for (DataSnapshot wisataReligiSnapshot : snapshot.getChildren()) {
                    WisataReligiModel wisataReligi = wisataReligiSnapshot.getValue(WisataReligiModel.class);
                    wisataReligi.setKey(wisataReligiSnapshot.getKey());
                    listWisataReligi.add(wisataReligi);
                }

                populateListview();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        populateDataWisataReligi();
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_admin, menu);

    }

    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        WisataReligiModel wisataReligi = listWisataReligi.get(info.position);
        switch (item.getItemId()) {
            case R.id.detail:
                Intent intent = new Intent(WisataReligiAdmin.this, DeskripsiWisataReligi.class);
                intent.putExtra("key", wisataReligi.getkey());
                startActivity(intent);
                return true;
            case R.id.edit:
                Intent intentUpdate = new Intent(WisataReligiAdmin.this, inputFormWR.class);
                intentUpdate.putExtra("key", wisataReligi.getkey());
                startActivity(intentUpdate);
                return true;
            case R.id.hapus:
                showConfirmationDialog(wisataReligi.getkey());
                populateDataWisataReligi();
                deleteImageFromStorage(wisataReligi.image);
                return true;
            default:
                return super.onContextItemSelected(item);
        }

    }

    private void showConfirmationDialog(String key) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Konfirmasi")
                .setMessage("Apakah Anda yakin ingin menghapus data?")
                .setPositiveButton("Ya", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int id) {
                        database.child("Wisata Religi").child(key).removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(WisataReligiAdmin.this, "Data dihapus!", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                })
                .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Tindakan yang dilakukan ketika user menekan tombol Tidak
                        // Contoh: tutup dialog
                        dialog.dismiss();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void deleteImageFromStorage(String imageName) {
        StorageReference storageRef = FirebaseStorage.getInstance().getReference();
        StorageReference imageRef = storageRef.child("images").child(imageName);

        imageRef.delete().addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                // Gambar berhasil dihapus dari storage
                Toast.makeText(WisataReligiAdmin.this, "Gambar dihapus dari storage", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                // Gagal menghapus gambar dari storage
                Toast.makeText(WisataReligiAdmin.this, "Gagal menghapus gambar dari storage", Toast.LENGTH_SHORT).show();
            }
        });
    }
}