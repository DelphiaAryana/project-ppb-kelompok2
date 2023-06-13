package com.example.project;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ItemListAdapterWE extends BaseAdapter {

    private Context context;
    private ArrayList<WisataEdukasiModel> arrayList;

    public ItemListAdapterWE(Context context,ArrayList<WisataEdukasiModel> arrayList){
        this.context = context;
        this.arrayList = arrayList;
    }


    @Override
    public int getCount() {
        return this.arrayList.size();
    }

    @Override
    public Object getItem(int posisiton) {
        return arrayList.get(posisiton);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint({"ViewHolder", "InflateParams"})
    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        assert layoutInflater != null;
        view = layoutInflater.inflate(R.layout.listview_item, null);

        TextView nama = view.findViewById(R.id.nama);
        TextView detail = view.findViewById(R.id.detail);
        TextView nomer = view.findViewById(R.id.nomer);
        nomer.setText(Integer.toString(position + 1));
        WisataEdukasiModel wisataEdukasi = arrayList.get(position);
        nama.setText(wisataEdukasi.getNama());
        detail.setText(wisataEdukasi.getLokasi());

        return view;
    }
}



