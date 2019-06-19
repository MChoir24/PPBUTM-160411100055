package com.example.PraktikumPPB_D2;

import android.os.Parcel;
import android.os.Parcelable;

public class Coffee implements Parcelable {
    String nama;

    int harga;
    int gambar;
    int jumlah = 0;

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public int getGambar() {
        return gambar;
    }

    public void setGambar(int gambar) {
        this.gambar = gambar;
    }



    public Coffee(String nama, int harga, int gambar) {
        this.nama = nama;
        this.harga = harga;
        this.gambar = gambar;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nama);
        dest.writeInt(this.harga);
        dest.writeInt(this.gambar);
        dest.writeInt(this.jumlah);
    }

    protected Coffee(Parcel in) {
        this.nama = in.readString();
        this.harga = in.readInt();
        this.gambar = in.readInt();
        this.jumlah = in.readInt();
    }

    public static final Parcelable.Creator<Coffee> CREATOR = new Parcelable.Creator<Coffee>() {
        @Override
        public Coffee createFromParcel(Parcel source) {
            return new Coffee(source);
        }

        @Override
        public Coffee[] newArray(int size) {
            return new Coffee[size];
        }
    };
}
