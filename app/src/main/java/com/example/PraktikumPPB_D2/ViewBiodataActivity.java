package com.example.PraktikumPPB_D2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ViewBiodataActivity extends AppCompatActivity {
    public static final String EXTRA_PERSON = "extra_person";

    TextView tvNRP, tvNama, tvAlamat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_person);

        tvNRP = findViewById(R.id.tv_NRP);
        tvNama = findViewById(R.id.tv_nama_person);
        tvAlamat = findViewById(R.id.tv_alamat);

        Person person = getIntent().getParcelableExtra(EXTRA_PERSON);

        tvNama.setText(person.getNama());
        tvNRP.setText(person.getNrp());
        tvAlamat.setText(person.getAlamat());
    }

    public void selesai(View view) {
        finish();
    }
}
