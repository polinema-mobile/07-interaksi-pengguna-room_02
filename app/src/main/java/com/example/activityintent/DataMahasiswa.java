package com.example.activityintent;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class DataMahasiswa implements Parcelable{
    String nama;
    String nim;
    String tanggalLahir;
    String jeniskelamin;
    String jurusan;

    protected DataMahasiswa(Parcel in) {
        nama = in.readString();
        nim = in.readString();
        tanggalLahir = in.readString();
        jurusan = in.readString();
        jeniskelamin = in.readString();
    }
    public DataMahasiswa(String nama, String nim, String tanggalLahir, String jurusan, String jeniskelamin) {
        this.nama = nama;
        this.nim = nim;
        this.tanggalLahir = tanggalLahir;
        this.jurusan = jurusan;
        this.jeniskelamin = jeniskelamin;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nama);
        dest.writeString(nim);
        dest.writeString(tanggalLahir);
        dest.writeString(jeniskelamin);
        dest.writeString(jurusan);
    }

    public static final Parcelable.Creator<DataMahasiswa> CREATOR = new Parcelable.Creator<DataMahasiswa>() {
        @Override
        public DataMahasiswa createFromParcel(Parcel source) {
            return new DataMahasiswa(source);
        }

        @Override
        public DataMahasiswa[] newArray(int size) {
            return new DataMahasiswa[size];
        }
    };
    @Override
    public int describeContents() {
        return 0;
    }
    public String getNama(){ return nama; }
    public String getNim(){ return nim; }
    public String getTgl(){ return tanggalLahir; }
    public String getJk(){ return jeniskelamin; }
    public String getJurusan(){ return jurusan; }
}

