//menu
package com.example.PraktikumPPB_D2;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class Tugas5Activity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MyAdapterPeople adapter ;
    private RecyclerView.LayoutManager layoutManager;
    android.support.v7.widget.Toolbar Toolbarv2;

    public static ArrayList<Person> people;

    protected Cursor cursor;
    DataHelper dbcenter;
    public static Tugas5Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tugas5);

//        activity = this;

        dbcenter = new DataHelper(this);
        showPerson();


        Toolbarv2 = findViewById(R.id.toolbarv2);
        Toolbarv2.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        setSupportActionBar(Toolbarv2);
        Toolbarv2.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }
    public void showPerson(){
        SQLiteDatabase db = dbcenter.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM biodata",null);
        people = new ArrayList<>();
        Person person ;
        cursor.moveToFirst();
        for (int i = 0 ; i < cursor.getCount(); i++){
            cursor.moveToPosition(i);
            person = new Person(cursor.getString(0), cursor.getString(1), cursor.getString(2));
            people.add(person);
        }
        recyclerView = findViewById(R.id.person_recycler_view);

        adapter = new MyAdapterPeople(this,people);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    public void tambahData(View view) {
        Intent intent = new Intent(getApplicationContext(), FormBiodataActivity.class);
        startActivity(intent);
    }
}
