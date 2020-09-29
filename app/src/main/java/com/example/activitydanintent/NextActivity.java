package com.example.activitydanintent;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class NextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.next_activity);

        Bundle b = getIntent().getExtras();
        //membuat obyek dari widget textview
        TextView nama = (TextView) findViewById(R.id.hasil_nama);
        TextView nim = (TextView) findViewById(R.id.hasil_nim);
        TextView tanggalLahir = (TextView) findViewById(R.id.hasil_tanggalLahir);
        TextView jeniskelamin = (TextView) findViewById(R.id.hasil_jk);
        TextView jurusan = (TextView) findViewById(R.id.hasil_jurusan);
        //menset nilai dari widget textview
        nama.setText(b.getCharSequence("nama"));
        nim.setText(b.getCharSequence("nim"));
        tanggalLahir.setText(b.getCharSequence("tanggalLahir"));
        jeniskelamin.setText(b.getCharSequence("jeniskelamin"));
        jurusan.setText(b.getCharSequence("jurusan"));

    }
}