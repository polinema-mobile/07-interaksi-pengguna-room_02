package com.example.activityintent;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityKeduaParcelable extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kedua_parcel);

                    TextView nama = (TextView) findViewById(R.id.edtNama);
                    TextView nim = (TextView) findViewById(R.id.edtNIM);
                    TextView tanggal = (TextView) findViewById(R.id.edtTanggalLahir);
                    TextView jk = (TextView) findViewById(R.id.edtJenisKelamin);
                    TextView jurusan = (TextView) findViewById(R.id.edtJurusan);

                    DataMahasiswa dataMahasiswa = getIntent().getParcelableExtra("Parcelable");

                    nama.setText( dataMahasiswa.getNama());
                    nim.setText(dataMahasiswa.getNim());
                    tanggal.setText(dataMahasiswa.getTgl());
                    jk.setText (dataMahasiswa.getJk());
                    jurusan.setText(dataMahasiswa.getJurusan());



    }
}
