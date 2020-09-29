package com.example.formactivedanintent;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText date;
    EditText nama;
    EditText nim;
    private Spinner jurusan;
    private String gender;
    DatePickerDialog datePickerDialog;
    RadioGroup opsi;
    private Spinner spinner;
    private static final String[] paths = {"Akuntansi", "Teknologi Informasi", "Teknik Elektro", "Teknik Sipil", "Teknik Mesin"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nama = (EditText) findViewById(R.id.edtNama);
        nim = (EditText) findViewById(R.id.edtNim);

        // initiate the date picker and a button
        date = (EditText) findViewById(R.id.edtTanggalLahir);
        // perform click event on edit text

        spinner = (Spinner)findViewById(R.id.spinnerJurusan);
        List<String> ListJurusan = new ArrayList<String>();
        ListJurusan.add("AKUNTANSI");
        ListJurusan.add("TEKNIK INFORMATIKA");
        ListJurusan.add("TEKNIK KIMIA");
        ListJurusan.add("TEKNIK ELEKTRO");
        ListJurusan.add("ADMINISTRASI NIAGA");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, ListJurusan);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calender class's instance and get current date , month and year from calender
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                // date picker dialog
                datePickerDialog = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                date.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

        opsi = (RadioGroup) findViewById(R.id.rg_jeniskelamin);
        opsi.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rb_laki:
                        gender = "Laki-Laki";
                        break;
                    case R.id.rb_perempuan:
                        gender = "Perempuan";
                        break;
                }
            }
        });


        Button button = findViewById(R.id.Simpan);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NextActivity.class);
                intent.putExtra("nama", nama.getText().toString());
                intent.putExtra("nim", nim.getText().toString());
                intent.putExtra("tanggalLahir", date.getText().toString());
                intent.putExtra("jeniskelamin", gender);
                intent.putExtra("jurusan", jurusan.getSelectedItem().toString());
                startActivity(intent);
            }
        });
    }

}