package com.example.activityintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ActivityKedua extends AppCompatActivity {

    String Data_mhs;
    String nama;
    String nim;
    String tgl;
    String jk;
    String jurusan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kedua);

        //intent
        Bundle b = getIntent().getExtras();
        //parcelable
        Intent intent = getIntent();
        MainActivity JenisData = intent.getParcelableExtra("Parcelable");
        startActivity(intent);
        String type = intent.getStringExtra(String.valueOf(JenisData));
                if(type.equals("Percelable")){
                nama = JenisData.getNama();
                nim = JenisData.getNim();
                tgl = JenisData.getTgl();
                jk = JenisData.getJk();
                jurusan = JenisData.getJurusan();
                    nama = String.valueOf((TextView) findViewById(R.id.edtNama));
                    nim = String.valueOf((TextView) findViewById(R.id.edtNIM));
                    tgl = String.valueOf((TextView) findViewById(R.id.edtTanggalLahir));
                    jk = String.valueOf((TextView) findViewById(R.id.edtJenisKelamin));
                    jurusan = String.valueOf((TextView) findViewById(R.id.edtJurusan));
                } else {
                    //membuat obyek dari widget textview
                    TextView nama = (TextView) findViewById(R.id.edtNama);
                    TextView nim = (TextView) findViewById(R.id.edtNIM);
                    TextView tanggalLahir = (TextView) findViewById(R.id.edtTanggalLahir);
                    TextView jeniskelamin = (TextView) findViewById(R.id.edtJenisKelamin);
                    TextView jurusan = (TextView) findViewById(R.id.edtJurusan);
                    //menset nilai dari widget textview
                    nama.setText(b.getCharSequence("nama"));
                    nim.setText(b.getCharSequence("nim"));
                    tanggalLahir.setText(b.getCharSequence("tanggalLahir"));
                    jeniskelamin.setText(b.getCharSequence("jeniskelamin"));
                    jurusan.setText(b.getCharSequence("jurusan"));
                }


    }

}