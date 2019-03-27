package com.example.PraktikumPPB_D2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Tugas3Activity extends AppCompatActivity implements View.OnClickListener {

    TextView tNama, tMenu,  tSajian, tJumlah, tInputUang, tv_total;
    EditText eNama,  eJumlah1, eJumlah2, eJumlah3, eUang;
    CheckBox cArabica, cAmerican, cRobusta;
    RadioButton rDingin1, rHangat1, rDingin2, rHangat2, rDingin3, rHangat3, rSatu;
    RadioGroup rgSajian1, rgSajian2,rgSajian3;

    Button btnMin1, btnPlus1, btnMin2, btnPlus2, btnMin3, btnPlus3, btnPesan;

    int count1 =1, count2 = 1, count3 = 1;

    Bundle bundle = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tugas3);

        rgSajian1 = findViewById(R.id.rgSajian1);
        rgSajian2 = findViewById(R.id.rgSajian2);
        rgSajian3 = findViewById(R.id.rgSajian3);

        rDingin1 = findViewById(R.id.rbDingin1);
        rHangat1 = findViewById(R.id.rbHangat1);
        rDingin2 = findViewById(R.id.rbDingin2);
        rHangat2 = findViewById(R.id.rbHangat2);
        rDingin3 = findViewById(R.id.rbDingin3);
        rHangat3 = findViewById(R.id.rbDingin3);

        cArabica = findViewById(R.id.cArabica);
        cAmerican = findViewById(R.id.cAmerican);
        cRobusta = findViewById(R.id.cRobusta);

        eJumlah1 = findViewById(R.id.eJumlah1);
        eJumlah2 = findViewById(R.id.eJumlah2);
        eJumlah3 = findViewById(R.id.eJumlah3);
        eUang = findViewById(R.id.eUang);
        eNama = findViewById(R.id.eNama);

        btnMin1 = findViewById(R.id.btnMin1);
        btnPlus1 = findViewById(R.id.btnPlus1);
        btnMin2 = findViewById(R.id.btnMin2);
        btnPlus2 = findViewById(R.id.btnPlus2);
        btnMin3 = findViewById(R.id.btnMin3);
        btnPlus3 = findViewById(R.id.btnPlus3);
        btnPesan = findViewById(R.id.btnPesan);

        tNama = findViewById(R.id.tNama);
        tMenu = findViewById(R.id.tMenu);

        tv_total = findViewById(R.id.tv_total);
        tSajian = findViewById(R.id.tSajian);
        tJumlah = findViewById(R.id.tJumlah);
        tInputUang = findViewById(R.id.tInputUang);

        eNama = findViewById(R.id.eNama);


        btnMin1.setOnClickListener(this);
        btnPlus1.setOnClickListener(this);
        btnMin2.setOnClickListener(this);
        btnPlus2.setOnClickListener(this);
        btnMin3.setOnClickListener(this);
        btnPlus3.setOnClickListener(this);



    }

    public void toID(){
        rDingin1.setText(R.string.dingin);
        rDingin2.setText(R.string.dingin);
        rDingin3.setText(R.string.dingin);
        rHangat1.setText(R.string.hangat);
        rHangat2.setText(R.string.hangat);
        rHangat3.setText(R.string.hangat);
        cArabica.setText(R.string.arabica);
        cAmerican.setText(R.string.american);
        cRobusta.setText(R.string.robusta);
        tNama.setText(R.string.tNama);
        tInputUang.setText(R.string.masukan_uang);
        btnPesan.setText(R.string.pesan);
        eNama.setHint(R.string.hNama);


    }
    public void toEN(){
        rDingin1.setText(R.string.dinginEn);
        rDingin2.setText(R.string.dinginEn);
        rDingin3.setText(R.string.dinginEn);
        rHangat1.setText(R.string.hangatEn);
        rHangat2.setText(R.string.hangatEn);
        rHangat3.setText(R.string.hangatEn);
        cArabica.setText(R.string.arabicaEn);
        cAmerican.setText(R.string.americanEn);
        cRobusta.setText(R.string.robustaEn);
        tNama.setText(R.string.tNamaEn);
        tInputUang.setText(R.string.masukan_uangEn);
        btnPesan.setText(R.string.pesanEn);
        eNama.setHint(R.string.hNamaEn);

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
            case R.id.ID:
                toID();
                return true;
            case R.id.EN:
                toEN();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public int hitung(){
        bundle.clear();
        int value = 0;
        int jumlah = 0;
        int total = 0;
        if (cArabica.isChecked()){
            rSatu = findViewById(rgSajian1.getCheckedRadioButtonId());
            String sajian = rSatu.getText().toString();
            jumlah = Integer.parseInt(eJumlah1.getText().toString());
            total += 2000*jumlah;
            bundle.putString("menu1","Arabica");
            bundle.putString("sajian1",sajian);
            bundle.putString("jumlah1", String.valueOf(jumlah));
        }if (cAmerican.isChecked()){
            rSatu = findViewById(rgSajian2.getCheckedRadioButtonId());
            String sajian = rSatu.getText().toString();
            jumlah = Integer.parseInt(eJumlah2.getText().toString());
            total += 2500*jumlah;
            bundle.putString("menu2","American");
            bundle.putString("sajian2",sajian);
            bundle.putString("jumlah2", String.valueOf(jumlah));
        }if (cRobusta.isChecked()){
            rSatu = findViewById(rgSajian3.getCheckedRadioButtonId());
            String sajian = rSatu.getText().toString();
            jumlah = Integer.parseInt(eJumlah3.getText().toString());
            total += 1500*jumlah;
            bundle.putString("menu3","Robusta");
            bundle.putString("sajian3",sajian);
            bundle.putString("jumlah3", String.valueOf(jumlah));
        }

        return total;
    }

    public void onTotal(View view) {
        int total = hitung();
        tv_total.setText(String.format("%s", total));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnMin1:
                if (count1 <= 1){
                    count1 =1;
                }else {
                    count1--;
                }
                eJumlah1.setText(Integer.toString(count1));
                break;
            case R.id.btnPlus1:
                count1++;
                eJumlah1.setText(Integer.toString(count1));
                break;
            case R.id.btnMin2:
                if (count2 <= 1){
                    count2 =1;
                }else {
                    count2--;
                }
                eJumlah2.setText(Integer.toString(count2));
                break;
            case R.id.btnPlus2:
                count2++;
                eJumlah2.setText(Integer.toString(count2));
                break;
            case R.id.btnMin3:
                if (count3 <= 1){
                    count3 =1;
                }else {
                    count3--;
                }
                eJumlah3.setText(Integer.toString(count3));
                break;
            case R.id.btnPlus3:
                count3++;
                eJumlah3.setText(Integer.toString(count3));
                break;
        }
    }

    public void onPesan(View view) {
        String vUang = eUang.getText().toString();
        String vNama = eNama.getText().toString();
        String vTotal = tv_total.getText().toString();

        int kembalian = 0, uang = 0, total = 0;

        if (vUang.equals("")){
            eUang.setError(getString(R.string.erEmpty));
        }if (vNama.equals("")){
            eNama.setError(getString(R.string.erEmpty));
        }
        if (!vNama.equals("") && !vUang.equals("")){
            uang = Integer.parseInt(vUang);
            total = Integer.parseInt(vTotal);
            if (uang >= total){
                kembalian = uang-total;
                bundle.putString("nama", vNama);
                bundle.putString("uang", vUang);
                bundle.putString("total", vTotal);
                bundle.putString("kembalian", String.valueOf(kembalian));

                Intent intent = new Intent(Tugas3Activity.this, ResultCoffeActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }else {
                eUang.setError(getString(R.string.erUang));
            }


        }
    }
}
