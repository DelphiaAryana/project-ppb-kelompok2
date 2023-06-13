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

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ListWisataAlam extends AppCompatActivity {

    private DatabaseReference database;
    ListView listView;
    private ArrayList<WisataAlamModel> listWisataAlam;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_wisata_alam);
        listView = findViewById(R.id.itemsList);
        getSupportActionBar().setTitle("Wisata Alam Kalsel");

//        menginsiasi database Firebase
        database = FirebaseDatabase.getInstance().getReference();
        populateDataWisataAlam();


    }

    public void populateListview() {
        try {
            ItemListAdapter itemsAdopter = new ItemListAdapter(this, listWisataAlam);
            listView.setAdapter(itemsAdopter);
            itemsAdopter.notifyDataSetChanged();
            registerForContextMenu(listView);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void populateDataWisataAlam() {
        database.child("Wisata Alam").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listWisataAlam = new ArrayList<>();
                for (DataSnapshot wisataAlamSnapshot : snapshot.getChildren()) {
                    WisataAlamModel wisataAlam = wisataAlamSnapshot.getValue(WisataAlamModel.class);
                    wisataAlam.setKey(wisataAlamSnapshot.getKey());
                    listWisataAlam.add(wisataAlam);
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
        populateDataWisataAlam();
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);

    }

    public boolean onContextItemSelected(MenuItem item) {

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        WisataAlamModel wisataAlam = listWisataAlam.get(info.position);
        switch (item.getItemId()) {
            case R.id.detail:
                Intent intent = new Intent(ListWisataAlam.this, DeskripsiWisataAlam.class);
                intent.putExtra("key", wisataAlam.getkey());
                startActivity(intent);
                return true;
            default:
                return super.onContextItemSelected(item);
        }

    }

    private void showConfirmationDialog(String getkey) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Konfirmasi")
                .setMessage("Apakah Anda yakin ingin menghapus data?")
                .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    private String key;

                    public void onClick(DialogInterface dialog, int id) {
                        database.child("Wisata Alam").child(key).removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(ListWisataAlam.this, "Data dihapus!", Toast.LENGTH_SHORT).show();
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
}