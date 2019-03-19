package com.example.PraktikumPPB_D2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnTugas1, btnTugas2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTugas1 = findViewById(R.id.btnTugas1);
        btnTugas2 = findViewById(R.id.btnTugas2);
    }

    public void tugas1(View view) {
        Intent intent = new Intent(MainActivity.this, Tugas1Activity.class);
        startActivity(intent);
    }

    public void tugas2(View view) {
        Intent intent = new Intent(MainActivity.this, Tugas2Activity.class);
        startActivity(intent);
    }

    public void tugas3(View view) {
        Intent intent = new Intent(MainActivity.this, Tugas3Activity.class);
        startActivity(intent);
    }
}
