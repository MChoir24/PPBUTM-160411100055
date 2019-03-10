package com.example.PraktikumPPB_D2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Tugas2Activity extends AppCompatActivity {

    EditText editBeratBadan, editTinggiBadan;
    Button hitungBMI;
    TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tugas2);

        editBeratBadan = findViewById(R.id.editBerat);
        editTinggiBadan = findViewById(R.id.editTinggi);
        hitungBMI = findViewById(R.id.btnBMI);
        tv_result = findViewById(R.id.tv_result_BMI);

    }

    public void hitungBMI(View view) {
        String berat = editBeratBadan.getText().toString().trim();
        String tinggi = editTinggiBadan.getText().toString().trim();

        if (berat.equals("")){
            editBeratBadan.setError("tidak boleh kosong!");
        }
        if (tinggi.equals("")){
            editTinggiBadan.setError("tidak boleh kosong!");
        }

        Double dBerat = toDouble(berat);
        Double dTinggi = toDouble(tinggi);

        if (dBerat == null){
            editBeratBadan.setError("Inputan harus berupa angka");
        }
        if (dTinggi == null){
            editTinggiBadan.setError("Inputan harus berupa angka");
        }
        if (!berat.isEmpty() && !tinggi.isEmpty() && dBerat != null && dTinggi != null){
            dTinggi = dTinggi/100;
            Double BMI = dBerat/(dTinggi*dTinggi);
            String kelas = null;
            if (BMI < 18.5){
                kelas = String.format("BMI: %s Underweight", BMI);
            }
            if (BMI >= 18.5 && BMI <= 24.9){
                kelas = String.format("BMI: %s Normal weight", BMI);
            }
            if (BMI >= 25 && BMI <= 29.9){
                kelas = String.format("BMI: %s Over weight", BMI);
            }
            if (BMI >= 30 && BMI <= 34.9){
                kelas = String.format("BMI: %s Obesity 1", BMI);
            }
            if (BMI >= 35 && BMI <= 29.9){
                kelas = String.format("BMI: %s Obesity 2", BMI);
            }
            if (BMI >= 40){
                kelas = String.format("BMI: %s Obesity 3", BMI);
            }
            tv_result.setText(kelas);
        }
    }

    Double toDouble(String str){
        try {
            return Double.valueOf(str);
        }catch (NumberFormatException e){
            return null;
        }
    }
}
