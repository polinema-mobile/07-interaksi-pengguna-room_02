package com.example.activityintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.InputType;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.app.DatePickerDialog;
import android.widget.DatePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements Parcelable {
    private DatePickerDialog datePickerDialog;
    private SimpleDateFormat dateFormatter;
    private String gender;
    EditText nama;
    EditText nim;
    EditText tanggalLahir;
    RadioButton lakilaki;
    RadioButton perempuan;
    RadioGroup jeniskelamin;
    Spinner jurusan;
    Button buttonIntent;
    Button buttonPercelable;
    String JenisData;
    String Data_mhs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nama = (EditText) findViewById(R.id.edtNama);
        nim = (EditText) findViewById(R.id.edtNim);
        tanggalLahir = (EditText) findViewById(R.id.edtTanggalLahir);
        lakilaki = (RadioButton) findViewById(R.id.radioLakilaki);
        perempuan = (RadioButton) findViewById(R.id.radioPerempuan);
        jeniskelamin = (RadioGroup) findViewById(R.id.radioGroup);
        jurusan = (Spinner) findViewById(R.id.listJurusan);
        buttonIntent = findViewById(R.id.btnSimpanIntent);
        buttonPercelable = findViewById(R.id.btnSimpanParcel);


        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        tanggalLahir.setInputType(InputType.TYPE_NULL);
        tanggalLahir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDateDialog();
            }
        });
        jeniskelamin.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.radioLakilaki:
                        gender = "Laki-Laki";
                        break;
                    case R.id.radioPerempuan:
                        gender = "Perempuan";
                        break;
                }
            }
        });
        jurusan.setOnItemSelectedListener(new ItemSelectedListener());
        buttonIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ActivityKedua.class);
                int id = jeniskelamin.getCheckedRadioButtonId();
                RadioButton selectedGender = (RadioButton) findViewById(id);

                //Menyisipkan tipe data String ke dalam obyek bundle
                intent.putExtra(JenisData,"Intent");
                intent.putExtra("nama", nama.getText().toString());
                intent.putExtra("nim", nim.getText().toString());
                intent.putExtra("tanggalLahir", tanggalLahir.getText().toString());
                intent.putExtra("jeniskelamin", selectedGender.getText().toString());
                intent.putExtra("jurusan", jurusan.getSelectedItem().toString());

                //memulai Activity kedua
                startActivity(intent);
            }
        });
        buttonPercelable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ActivityKedua.class);
                int id = jeniskelamin.getCheckedRadioButtonId();
                RadioButton selectedGender = (RadioButton) findViewById(id);

                intent.putExtra(JenisData,"Parcelable");
                startActivity(intent);
            }
        });
    }

    private void showDateDialog() {
        //Calendar untuk mendapatkan tanggal sekarang
        Calendar newCalendar = Calendar.getInstance();

        //Initiate DatePicker dialog
        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                //Method ini dipanggil saat kita selesai memilih tanggal di DatePicker
                //Set Calendar untuk menampung tanggal yang dipilih
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);

                //Update TextView dengan tanggal yang kita pilih
                tanggalLahir.setText(dateFormatter.format(newDate.getTime()));
            }
        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        //Tampilkan DatePicker dialog
        datePickerDialog.show();
    }

    public class ItemSelectedListener implements AdapterView.OnItemSelectedListener {

        //get strings of first item
        String firstItem = String.valueOf(jurusan.getSelectedItem());

        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
            firstItem.equals(String.valueOf(jurusan.getSelectedItem()));
            {

            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable((Parcelable) this.nama, flags);
        dest.writeParcelable((Parcelable) this.nim, flags);
        dest.writeParcelable((Parcelable) this.tanggalLahir, flags);
        dest.writeParcelable((Parcelable) this.jurusan, flags);
        dest.writeParcelable((Parcelable) this.jeniskelamin, flags);
        dest.writeParcelable((Parcelable) this.lakilaki, flags);
        dest.writeParcelable((Parcelable) this.perempuan, flags);

    }

    public MainActivity(EditText nm, EditText nonim, EditText tglLahir, Spinner jrsn, RadioGroup jk) {
        this.nama = nm;
        this.nim = nonim;
        this.tanggalLahir = tglLahir;
        this.jurusan = jrsn;
        this.jeniskelamin = jk;
    }

    public MainActivity() {

    }

    protected MainActivity(Parcel in) {
        nama = in.readParcelable(EditText.class.getClassLoader());
        nim = in.readParcelable(EditText.class.getClassLoader());
        tanggalLahir = in.readParcelable(EditText.class.getClassLoader());
        jurusan = in.readParcelable(Spinner.class.getClassLoader());
        jeniskelamin = in.readParcelable(RadioGroup.class.getClassLoader());
        lakilaki = in.readParcelable(RadioButton.class.getClassLoader());
        perempuan = in.readParcelable(RadioButton.class.getClassLoader());
    }

    public static final Parcelable.Creator<MainActivity> CREATOR = new Parcelable.Creator<MainActivity>() {
        @Override
        public MainActivity createFromParcel(Parcel source) {
            return new MainActivity(source);
        }

        @Override
        public MainActivity[] newArray(int size) {
            return new MainActivity[size];
        }
    };
    public String getNama(){ return String.valueOf(nama); }
    public String getNim(){ return String.valueOf(nim); }
    public String getTgl(){ return String.valueOf(tanggalLahir); }
    public String getJk(){ return String.valueOf(jeniskelamin); }
    public String getJurusan(){ return String.valueOf(jurusan); }
}