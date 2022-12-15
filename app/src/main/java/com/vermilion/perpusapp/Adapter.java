package com.vermilion.perpusapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    Context con;
    ArrayList<Buku> bukuArrayList;

    public Adapter(Context context, ArrayList<Buku> bukuArrayList) {
        this.con            = context;
        this.bukuArrayList  = bukuArrayList;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(con).inflate(R.layout.template_list_buku,parent,false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Buku buku = bukuArrayList.get(position);
        holder.txt_judul_buku.setText(buku.judulBuku);
    }

    @Override
    public int getItemCount() {
        return bukuArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txt_judul_buku;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            txt_judul_buku = itemView.findViewById(R.id.txt_judul_buku);
        }
    }
}
