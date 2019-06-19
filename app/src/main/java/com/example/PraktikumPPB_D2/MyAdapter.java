package com.example.PraktikumPPB_D2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private ArrayList<Coffee> mDataset;
    private Context mContext;
    Bundle bundle = new Bundle();
    private int REQUEST_CODE = 100;

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(Context context, ArrayList<Coffee> myDataset) {
        mContext = context;
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = (View) LayoutInflater.from(parent.getContext()).inflate(R.layout.list_coffee, parent, false);

        MyViewHolder vh = new MyViewHolder(v, this);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        holder.nama.setText(mDataset.get(position).getNama());
        holder.harga.setText(String.valueOf(mDataset.get(position).getHarga()));
        holder.gambar.setImageResource(mDataset.get(position).getGambar());
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bundle.putString("nama", holder.nama.getText().toString());
                bundle.putString("idGambar", String.valueOf(mDataset.get(holder.getLayoutPosition()).getGambar()));
                bundle.putString("jumlah", String.valueOf(mDataset.get(holder.getLayoutPosition()).getJumlah()));
                bundle.putString("position", String.valueOf(holder.getLayoutPosition()));
                Intent intent = new Intent(mContext, OrderCoffee.class);
                intent.putExtras(bundle);
                ((Activity)mContext).startActivity(intent);
//                ((Activity)mContext).startActivityForResult(intent,REQUEST_CODE);
            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return (mDataset != null) ? mDataset.size() : 0;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder  {
        // each data item is just a string in this case
        private TextView nama, harga;
        private ImageView gambar;
        private CardView parentLayout;
        final MyAdapter myAdapter;

        public MyViewHolder(View v, MyAdapter myAdapter) {
            super(v);
            nama = v.findViewById(R.id.namacoffe);
            harga = v.findViewById(R.id.hargacoffe);
            gambar = v.findViewById(R.id.icon_coffee);
            parentLayout = v.findViewById(R.id.parent_layout);
            this.myAdapter = myAdapter;
        }
    }
}
