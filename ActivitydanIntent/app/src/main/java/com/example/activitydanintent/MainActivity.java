package com.example.activitydanintent

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.app.DatePickerDialog;
import android.support.annotation.Nullable;
import android.widget.DatePicker;

import androidx.annotation.Nullable;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    Button buttonsimpan;
    EditText txtNim, txtNama;
    DatePickerDialog txtTanggalLahir;
    RadioGroup x;
    Spinner list_jurusan;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // inisialisasi
        buttonsimpan = (Button) findViewById(R.id.buttonsimpan);
        txtNim = (EditText) findViewById(R.id.txtNim);
        txtNama = (EditText) findViewById(R.id.txtNama);
        txtTanggalLahir = (EditText) findViewById(R.id.txtNama);
        rgjk = (RadioGroup) findViewById(R.id.jk);
        etanggallahir = (EditText) findViewById(R.id.tanggallahir);


        buttonsimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputnim = String.valueOf(txtNim.getText().toString());
                String inputnama = String.valueOf(txtNama.getText().toString());
                String inputtanggallahir = String.valueOf(txtTanggalLahir.getText().toString());
                int gender = rgjk.getCheckedRadioButtonId();
                RadioButton jk = (RadioButton) findViewById(gender);
                String inputjk = String.valueOf(jk.getText().toString());
                hasil.setText(“\n” + “NIM\t\t\t\t\t\t\t\t\t\t\t: “ + inputnim + “\n” +
                “Nama\t\t\t\t\t\t\t\t\t\t: “ + inputnama + “\n” +
                “Jenis Kelamin\t\t: “ + inputjk + “\n” +
                “Jenis Kelamin\t\t: “ + inputtempatlahir + “\n” +
                “Tanggal Lahir\t\t\t: “ + inputtanggallahir + “\n”);
            }
        });
    }
}