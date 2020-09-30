package com.example.axtivityintent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.activityintent.R;

public class ActivityKedua extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kedua);

        Bundle b = getIntent().getExtras();
        //membuat obyek dari widget textview
        TextView nama = (TextView) findViewById(R.id.edtNama);
        TextView nim = (TextView) findViewById(R.id.edtNim);
        TextView tanggalLahir = (TextView) findViewById(R.id.tanggalLahirValue);
        TextView jeniskelamin = (TextView) findViewById(R.id.jeniskelaminValue);
        TextView jurusan = (TextView) findViewById(R.id.jurusanValue);
        //menset nilai dari widget textview
        nama.setText(b.getCharSequence("nama"));
        nim.setText(b.getCharSequence("nim"));
        tanggalLahir.setText(b.getCharSequence("tanggalLahir"));
        jeniskelamin.setText(b.getCharSequence("jeniskelamin"));
    }
}
