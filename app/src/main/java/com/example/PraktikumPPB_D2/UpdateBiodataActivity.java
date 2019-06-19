package com.example.PraktikumPPB_D2;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateBiodataActivity extends AppCompatActivity {
    public static final String EXTRA_PERSON = "extra_person";
    public Person person;

    protected Cursor cursor;
    DataHelper dbHelper;

    EditText editNrp, editNamaPerson, editAlamat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_biodata);

        person = getIntent().getParcelableExtra(EXTRA_PERSON);

        dbHelper = new DataHelper(this);

        editNrp = findViewById(R.id.edit_NRP);
        editNamaPerson = findViewById(R.id.edit_nama_person);
        editAlamat = findViewById(R.id.edit_alamat);


        editNrp.setText(person.getNrp());
        editNamaPerson.setText(person.getNama());
        editAlamat.setText(person.getAlamat());

    }

    public void update(View view) {
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
            db.execSQL("update biodata set nrp='"+
                    editNrp.getText().toString() +"', nama='" +
                    editNamaPerson.getText().toString()+"', alamat='"+
                    editAlamat.getText().toString() +"'where nrp='" +
                    person.getNrp()+"'");
            Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_SHORT).show();
            Tugas5Activity.activity.showPerson();
            finish();
        }
    }

    public void batal(View view) {
        finish();
    }
}
