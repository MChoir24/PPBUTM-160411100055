package com.example.PraktikumPPB_D2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class aboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
    }

    public void btninish(View view) {
        finish();
    }
}
