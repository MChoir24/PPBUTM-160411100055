//intent
package com.example.PraktikumPPB_D2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class tugas4Activity extends AppCompatActivity {

    EditText eNama, ePass;
    TextView tv_err;
    static String username, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tugas4);

        eNama = findViewById(R.id.eUserName);
        ePass = findViewById(R.id.ePassword);

        tv_err = findViewById(R.id.tv_err);

        username = "Choir";
        password = "Choir";
    }

    public void login(View view) {
        String sNama = eNama.getText().toString().trim();
        String sPass = ePass.getText().toString().trim();

        if (sNama.equals(username) && sPass.equals(password)){
            Intent intent = new Intent(tugas4Activity.this, Tugas3Activity.class);
            startActivity(intent);
        }else {
            tv_err.setText("Username atau password salah");
        }
    }
}
