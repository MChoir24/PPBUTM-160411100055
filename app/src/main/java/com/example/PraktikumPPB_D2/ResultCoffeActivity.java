package com.example.PraktikumPPB_D2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Objects;

public class ResultCoffeActivity extends AppCompatActivity {
    TextView tv_result;
    Bundle bundle = new Bundle();
    String pesan="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_coffe);
        tv_result = findViewById(R.id.tv_resultCoffe);

        bundle = getIntent().getExtras();

        String nama = bundle.getString("nama");
        String total = bundle.getString("total");
        String uang = bundle.getString("uang");
        String kembalian = bundle.getString("kembalian");
        pesan+=String.format("Nama : %s\n Menu %5s Sajian %5s total %5s \n", nama,"","","");
        if (bundle.getString("menu1") != null){
            String menu = bundle.getString("menu1");
            String sajian = bundle.getString("sajian1");
            String jumlah = bundle.getString("jumlah1");
            pesan += String.format("%5s  %5s 2000x%5s %5s\n" ,menu,sajian,jumlah, 2000*Integer.parseInt(jumlah));
        }
        if (bundle.getString("menu2") != null){
            String menu = bundle.getString("menu2");
            String sajian = bundle.getString("sajian2");
            String jumlah = bundle.getString("jumlah2");
            pesan += String.format("%5s %5s 2500x%5s %5s\n" ,menu,sajian,jumlah, 2500*Integer.parseInt(jumlah));
        }
        if (bundle.getString("menu3") != null){
            String menu = bundle.getString("menu3");
            String sajian = bundle.getString("sajian3");
            String jumlah = bundle.getString("jumlah3");
            pesan += String.format("%5s %5s 1500x%5s %5s\n" ,menu,sajian,jumlah, 1500*Integer.parseInt(jumlah));
        }
        pesan+=String.format("Total : %s\nTunai : %s\nKembalian : %s", total,uang,kembalian);
        tv_result.setText(pesan);
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
}
