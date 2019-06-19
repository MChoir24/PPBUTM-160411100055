package com.example.PraktikumPPB_D2;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FormBiodataActivity extends AppCompatActivity {

    protected Cursor cursor;
    DataHelper dbHelper;

    EditText editNrp, editNamaPerson, editAlamat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_biodata);

        dbHelper = new DataHelper(this);

        editNrp = findViewById(R.id.edit_NRP);
        editNamaPerson = findViewById(R.id.edit_nama_person);
        editAlamat = findViewById(R.id.edit_alamat);
    }

    public void add(View view) {
        if (editNrp.getText().toString().equals("")){
            editNrp.setError("harus diisi");
        }
        if (editNamaPerson.getText().toString().equals("")){
            editNamaPerson.setError("harus diisi");
        }
        if (editAlamat.getText().toString().equals("")){
            editAlamat.setError("harus diisi");
        }
        else {
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            db.execSQL("insert into biodata(nrp, nama, alamat) values('" +
                    editNrp.getText().toString()+"','"+
                    editNamaPerson.getText().toString() +"','" +
                    editAlamat.getText().toString()+ "')");
            Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_SHORT).show();
            Tugas5Activity.activity.showPerson();
            finish();
        }
    }

    public void batal(View view) {
        finish();
    }
}
