package com.example.PraktikumPPB_D2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Tugas3Activity extends AppCompatActivity{

    private RecyclerView recyclerView;
    private MyAdapter adapter ;
    private RecyclerView.LayoutManager layoutManager;
    public static ArrayList<Coffee> coffees;
    private int REQUEST_CODE = 100;
    private TextView test;
    private Bundle bundle = new Bundle();
    android.support.v7.widget.Toolbar Toolbarv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tugas3);

        addData();

        recyclerView = findViewById(R.id.recycler_view);
        test = findViewById(R.id.test);

        adapter = new MyAdapter(this,coffees);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

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

    private void addData() {
        coffees = new ArrayList<>();
        coffees.add(new Coffee("Arabica", 2000, R.drawable.icon_arabican));
        coffees.add(new Coffee("American", 2000, R.drawable.icon_american));
        coffees.add(new Coffee("Robusta", 2000, R.drawable.icon_robusta));
        coffees.add(new Coffee("Capoccino", 2000, R.drawable.icon_cappucino));
        coffees.add(new Coffee("Mocha", 2000, R.drawable.icon_mocha));
        coffees.add(new Coffee("Expresso", 2000, R.drawable.icon_expresso));
        coffees.add(new Coffee("Vanilla Coffe", 2000, R.drawable.icon_vanilla));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        return super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.item_pesan:
                Boolean adaPesanan  = false;
                for (int i = 0; i< coffees.size(); i++){
                    if (coffees.get(i).getJumlah() > 0){
                        adaPesanan = true;
                        break;
                    }
                }
                if (adaPesanan) {
                    Intent intent = new Intent(this, ResultCoffeActivity.class);
                    intent.putExtra(ResultCoffeActivity.EXTRA_PERSON, coffees);
                    startActivity(intent);
                }else {
                    Toast.makeText(getApplicationContext(),"anda belum pesan.",Toast.LENGTH_SHORT).show();
                }
                return true;
            case R.id.item_about:
                Intent intent2 = new Intent(getApplicationContext(), aboutActivity.class);
                startActivity(intent2);
                return true;
            case R.id.item_logout:
                SharedPreferences sp = getSharedPreferences("Login", MODE_PRIVATE);
                sp.edit().putBoolean("logged",false).apply();
                Intent intent1 = new Intent(getApplicationContext(),tugas4Activity.class);
                startActivity(intent1);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE){
            if (requestCode == OrderCoffee.RESULT_CODE){
                bundle = data.getExtras();
                coffees.get(Integer.parseInt(bundle.getString("position"))).setJumlah(Integer.parseInt(bundle.getString("jumlah")));
//                System.out.print(selectedValue);
                test.setText(String.format("hasil : %s jumlah %s:", coffees.get(Integer.parseInt(bundle.getString("position"))).getNama(), coffees.get(Integer.parseInt(bundle.getString("position"))).getJumlah()));
            }
        }
    }
}
