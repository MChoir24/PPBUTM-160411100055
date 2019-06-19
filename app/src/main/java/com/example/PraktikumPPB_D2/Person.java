package com.example.PraktikumPPB_D2;

import android.os.Parcel;
import android.os.Parcelable;

public class Person implements Parcelable {
    private String nrp;
    private  String nama;
    private  String Alamat;

    public Person(String nrp, String nama, String alamat) {
        this.nrp = nrp;
        this.nama = nama;
        Alamat = alamat;
    }

    public String getNrp() {
        return nrp;
    }

    public void setNrp(String nrp) {
        this.nrp = nrp;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return Alamat;
    }

    public void setAlamat(String alamat) {
        Alamat = alamat;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nrp);
        dest.writeString(this.nama);
        dest.writeString(this.Alamat);
    }

    protected Person(Parcel in) {
        this.nrp = in.readString();
        this.nama = in.readString();
        this.Alamat = in.readString();
    }

    public static final Parcelable.Creator<Person> CREATOR = new Parcelable.Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel source) {
            return new Person(source);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };
}
