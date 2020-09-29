<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:context=".MainActivity">

<LinearLayout
        android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:orientation="vertical">

<EditText
            android:id="@+id/edtNama"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:hint="Nama Mahasiswa"/>

<EditText
            android:id="@+id/edtNim"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:hint="Nomor Induk Mahasiswa"/>

<EditText
            android:id="@+id/edtTanggalLahir"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:inputType="date"
                    android:hint="Tanggal Lahir"/>

<RadioGroup
            android:id="@+id/rg_jeniskelamin"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content">


<RadioButton
                android:id="@+id/rb_laki"
                        android:layout_width="match_parent"
                        android:layout_height="wrap_content"
                        android:checked="true"
                        android:text="Laki Laki" />

<RadioButton
                android:id="@+id/rb_perempuan"
                        android:layout_width="match_parent"
                        android:layout_height="wrap_content"
                        android:text="Perempuan" />
</RadioGroup>

<Spinner
            android:id="@+id/spinnerJurusan"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"/>

<Button
            android:id="@+id/Simpan"
                    android:text="SIMPAN DATA"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"/>
</LinearLayout>
</RelativeLayout>