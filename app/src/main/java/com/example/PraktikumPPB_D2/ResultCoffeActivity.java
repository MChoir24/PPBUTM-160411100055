package com.example.PraktikumPPB_D2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ResultCoffeActivity extends AppCompatActivity {
    public static final String EXTRA_PERSON = "extra_person";
    TextView tv_result, tv_hargaTotal, tv_kembali;
    Button btn_bayar;
    EditText edit_bayar;

    Bundle bundle = new Bundle();
    String pesan="";
    int hargaTotal;

    ArrayList<Coffee> coffees;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_coffe);
        tv_result = findViewById(R.id.tv_resultCoffe);
        tv_hargaTotal = findViewById(R.id.tv_hargaTotal);
        tv_kembali = findViewById(R.id.tv_kembalian);
        edit_bayar = findViewById(R.id.edit_bayar);

        coffees = getIntent().getParcelableArrayListExtra(EXTRA_PERSON);

        int jumlah  = 0;
        int hargaPer = 0;
        hargaTotal = 0;
        String pesan="";
        for (int i = 0; i < coffees.size(); i++){
            jumlah = coffees.get(i).getJumlah();
            if(jumlah > 0){
                hargaPer = coffees.get(i).getJumlah()*coffees.get(i).getHarga();
                pesan = pesan + String.format("%s \t %s \t %s \n",coffees.get(i).getNama(), coffees.get(i).getJumlah(),hargaPer);
                hargaTotal = hargaTotal + hargaPer;
            }
            tv_result.setText(pesan);
        }
        tv_hargaTotal.setText(String.valueOf(hargaTotal));

    }

    public void Done(View view)
    {
//        Uri uri = Uri.parse("smsto:082332973046");
//        Intent intent = new Intent(Intent.ACTION_SEND, uri);
//        intent.putExtra(Intent.EXTRA_TEXT, pesan);
//        intent.setType("text/plain");
//        intent.setPackage("com.whatsapp");
//        startActivity(intent);
        finish();
    }

    public void bayar(View view) {
        String uang = edit_bayar.getText().toString().trim();
        int kembali = 0;
        if (edit_bayar.getText().toString().trim().equals("")){
            edit_bayar.setError("tidak boleh kosong");
        }
        else if (Integer.parseInt(uang) >= hargaTotal){
            kembali = Integer.parseInt(uang) - hargaTotal ;
            tv_kembali.setText(String.valueOf(kembali));
        }else {
            Toast.makeText(getApplicationContext(),"uang anda kurang",Toast.LENGTH_SHORT).show();
            tv_kembali.setText(String.valueOf("0"));
        }
    }
}
