package com.example.PraktikumPPB_D2;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

class MyAdapterPeople extends RecyclerView.Adapter<MyAdapterPeople.MyViewHolder>  {
    private ArrayList<Person> mDataset;
    private Context mContext;
    DataHelper dbcenter;

    public MyAdapterPeople(Context context, ArrayList<Person> myDataset) {
        mContext = context;
        mDataset = myDataset;
        dbcenter = new DataHelper(mContext);
    }

//    @NonNull
    @Override
    public MyAdapterPeople.MyViewHolder onCreateViewHolder( ViewGroup viewGroup, int i) {
        View v = (View) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_person, viewGroup, false);
        MyViewHolder vh = new MyViewHolder(v, this);

        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, final int i) {
        myViewHolder.tv_nama.setText(mDataset.get(i).getNama());
        myViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final CharSequence[] dialogitem = {"Lihat Biodata", "Update Biodata", "Hapus Biodata"};
                AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                builder.setTitle("Pilihan");
                builder.setItems(dialogitem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which){
                            case 0:
                                Intent intent = new Intent(mContext, ViewBiodataActivity.class);
                                intent.putExtra(ViewBiodataActivity.EXTRA_PERSON,mDataset.get(i));
                                mContext.startActivity(intent);
                                break;
                            case 1:
                                Intent intent1 = new Intent(mContext, UpdateBiodataActivity.class);
                                intent1.putExtra(ViewBiodataActivity.EXTRA_PERSON,mDataset.get(i));
                                mContext.startActivity(intent1);
                                break;
                            case 2 :
                                SQLiteDatabase db = dbcenter.getWritableDatabase();
                                db.execSQL("delete from biodata where nrp = '"+mDataset.get(i).getNrp()+"'");
                                Tugas5Activity.activity.showPerson();
                                Toast.makeText(mContext, "Berhasil", Toast.LENGTH_SHORT).show();
                                break;
                            default:
                                break;
                        }
                    }
                });
                builder.create().show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return (mDataset != null) ? mDataset.size() : 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder  {
        private TextView tv_nama;
        private CardView cardView;
        final MyAdapterPeople myAdapterPeople ;

        public MyViewHolder(View v, MyAdapterPeople myAdapterPeople) {
            super(v);
            tv_nama = v.findViewById(R.id.namaPerson);
            cardView = v.findViewById(R.id.person_layout);
            this.myAdapterPeople = myAdapterPeople;
        }
    }
}
