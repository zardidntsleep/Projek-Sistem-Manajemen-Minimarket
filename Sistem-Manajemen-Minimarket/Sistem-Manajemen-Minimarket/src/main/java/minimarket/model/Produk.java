/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minimarket.model;

/**
 *
 * @author ThinkPad T14 G2
 */
public class Produk {
    private String kodeProduk;
    private String namaProduk;
    private String kategori;
    private double harga;

    public Produk(String kode, String nama, String kategori, double harga) {
        this.kodeProduk = kode;
        this.namaProduk = nama;
        this.kategori = kategori;
        this.harga = harga;
    }

    public String getKodeProduk() {
        return kodeProduk;
    }

    public String getNamaProduk() {
        return namaProduk;
    }

    public String getKategori() {
        return kategori;
    }

    public double getHarga() {
        return harga;
    }

    public void setNamaProduk(String nama) {
        namaProduk = nama;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public void setHarga(double harga) {
        if (harga >= 0) {
            this.harga = harga;
        } else {
            System.out.println("Harga tidak boleh negatif.");
        }
    }

    public void tampilkanInfo() {
        System.out.println(kodeProduk + " | " + namaProduk + " | " + kategori + " | Rp" + harga);
    }
}

