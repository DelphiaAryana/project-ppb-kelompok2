package com.example.project.modelData;

public class Artikel {
    String Judul;
    int Gambar;
    int konten;

    public Artikel(String judul, int gambar, int konten) {
        Judul = judul;
        Gambar = gambar;
        this.konten = konten;
    }

    public String getJudul() {
        return Judul;
    }

    public int getGambar() {
        return Gambar;
    }

    public int getKonten() {
        return konten;
    }
}
