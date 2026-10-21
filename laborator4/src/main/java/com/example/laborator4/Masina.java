package com.example.laborator4;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Masina implements Parcelable {
    private String marca;
    private int anFabricatie;
    private String combustibil;
    private String caroserie;
    private boolean areGarantie;
    private boolean esteNoua;
    private float rating;

    public Masina(String marca, int anFabricatie, String combustibil, String caroserie,
                  boolean areGarantie, boolean esteNoua, float rating) {
        this.marca = marca;
        this.anFabricatie = anFabricatie;
        this.combustibil = combustibil;
        this.caroserie = caroserie;
        this.areGarantie = areGarantie;
        this.esteNoua = esteNoua;
        this.rating = rating;
    }

    protected Masina(Parcel in) {
        marca = in.readString();
        anFabricatie = in.readInt();
        combustibil = in.readString();
        caroserie = in.readString();
        areGarantie = in.readByte() != 0;
        esteNoua = in.readByte() != 0;
        rating = in.readFloat();
    }

    public static final Creator<Masina> CREATOR = new Creator<Masina>() {
        @Override
        public Masina createFromParcel(Parcel in) {
            return new Masina(in);
        }

        @Override
        public Masina[] newArray(int size) {
            return new Masina[size];
        }
    };

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        // aceeași ordine ca în constructorul cu Parcel
        dest.writeString(marca);
        dest.writeInt(anFabricatie);
        dest.writeString(combustibil);
        dest.writeString(caroserie);
        dest.writeByte((byte) (areGarantie ? 1 : 0));
        dest.writeByte((byte) (esteNoua ? 1 : 0));
        dest.writeFloat(rating);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public String getMarca() { return marca; }
    public int getAnFabricatie() { return anFabricatie; }
    public String getCombustibil() { return combustibil; }
    public String getCaroserie() { return caroserie; }
    public boolean isAreGarantie() { return areGarantie; }
    public boolean isEsteNoua() { return esteNoua; }
    public float getRating() { return rating; }

    @NonNull
    @Override
    public String toString() {
        return "Mașina: " + marca +
                "\nAn fabricație: " + anFabricatie +
                "\nCombustibil: " + combustibil +
                "\nCaroserie: " + caroserie +
                "\nGaranție: " + (areGarantie ? "da" : "nu") +
                "\nNouă: " + (esteNoua ? "da" : "nu") +
                "\nRating: " + rating + "/5";
    }
}