//intent
package com.example.PraktikumPPB_D2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

public class tugas4Activity extends AppCompatActivity {

    EditText eNama, ePass;
    TextView tv_err;
    ScrollView formLogin;
    static String username, password;

    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tugas4);

        eNama = findViewById(R.id.eUserName);
        ePass = findViewById(R.id.ePassword);
        formLogin = findViewById(R.id.formLogin);

        tv_err = findViewById(R.id.tv_err);

        username = "miftahul choir";
        password = "160411100055";
        preferences = getSharedPreferences("Login", MODE_PRIVATE);

        if (preferences.getBoolean("logged", false)){
            Intent intent = new Intent(getApplicationContext(),Tugas3Activity.class);
            startActivity(intent);
            finish();
        }
        else {
            formLogin.setVisibility(View.VISIBLE);
        }

    }

    public void login(View view) {
        String sNama = eNama.getText().toString().trim();
        String sPass = ePass.getText().toString().trim();


        if (sNama.equals(username) && sPass.equals(password)){
            preferences.edit().putBoolean("logged",true).apply();
            Intent intent = new Intent(tugas4Activity.this, Tugas3Activity.class);
            startActivity(intent);
            finish();
        }else {
            tv_err.setText("Username atau password salah");
        }
    }

}
