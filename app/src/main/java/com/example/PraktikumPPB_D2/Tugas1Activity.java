package com.example.PraktikumPPB_D2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class Tugas1Activity extends AppCompatActivity {

    EditText nama;
    Button btnKirim;
    TextView tv_nama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tugas1);

        nama = findViewById(R.id.editNama);
        btnKirim = findViewById(R.id.btnHallo);
        tv_nama = findViewById(R.id.tv_nama);

    }

    public void halloAct(View view) {
        if (nama.getText().toString().equals("")){
            nama.setError("Harus terisi");
        }else {
            String s = nama.getText().toString();
            tv_nama.setText(String.format("hallo %s ",s));
        }
    }
}
