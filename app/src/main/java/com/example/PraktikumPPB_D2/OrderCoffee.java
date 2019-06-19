package com.example.PraktikumPPB_D2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class OrderCoffee extends AppCompatActivity implements View.OnClickListener{

    ImageView banner;
    TextView nama_coffe;
    RadioGroup rgSajian;
    RadioButton rbDingin, rbHangat;
    Button btnMin, btnPlus, btnAdd , btnBack;
    EditText editJumlah;
    Bundle bundle = new Bundle();
    android.support.v7.widget.Toolbar Toolbarv2;

    int n = 0;
    public static String EXTRA_SELECTED_VALUE = "extra_selected_value";
    public static int RESULT_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_coffee);

        banner = findViewById(R.id.bannerCofee);
        nama_coffe  = findViewById(R.id.tv_nama_coffe);
        rgSajian = findViewById(R.id.rgSajian);
        rbDingin = findViewById(R.id.rbDingin);
        rbHangat = findViewById(R.id.rbHangat);
        btnMin = findViewById(R.id.btnMin);
        btnPlus = findViewById(R.id.btnPlus);
        btnAdd = findViewById(R.id.btnAdd);
        editJumlah = findViewById(R.id.edit_jumlah);

        btnPlus.setOnClickListener(this);
        btnMin.setOnClickListener(this);
        btnAdd.setOnClickListener(this);

        bundle = getIntent().getExtras();

        banner.setImageResource(Integer.parseInt(bundle.getString("idGambar")));
        nama_coffe.setText(bundle.getString("nama"));
        editJumlah.setText(bundle.getString("jumlah"));
        Log.d("idGambar", String.valueOf(bundle.getInt("idGambar")));
        Log.d("nama", bundle.getString("nama"));
        Toolbarv2 = findViewById(R.id.toolbarv2);
        Toolbarv2.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        setSupportActionBar(Toolbarv2);
        Toolbarv2.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        if (Integer.parseInt(editJumlah.getText().toString())<1){
            btnMin.setEnabled(false);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnMin:
                editJumlah.setText(String.valueOf(Integer.parseInt(editJumlah.getText().toString())-1));
                if (Integer.parseInt(editJumlah.getText().toString())<1){
                    btnMin.setEnabled(false);
                }
                break;
            case R.id.btnPlus:
                btnMin.setEnabled(true);
//                n++;
                editJumlah.setText(String.valueOf(Integer.parseInt(editJumlah.getText().toString())+1));
                break;
            case R.id.btnAdd:
                String nama = nama_coffe.getText().toString();
                String sajian = "";
                String jumlah = editJumlah.getText().toString();
                switch (rgSajian.getCheckedRadioButtonId()){
                    case R.id.rbDingin:
                        sajian = rbDingin.getText().toString();
                        break;
                    case R.id.rbHangat:
                        sajian = rbHangat.getText().toString();
                        break;
                }
                Intent intent = new Intent();
                bundle.putString("nama",nama);
                bundle.putString("sajian",sajian);
                bundle.putString("jumlah",jumlah);
//                intent.putExtras(bundle);
//                setResult(RESULT_CODE, intent);
                Tugas3Activity.coffees.get(Integer.parseInt(bundle.getString("position"))).setJumlah(Integer.parseInt(jumlah));
                finish();
                break;
        }
    }
}
