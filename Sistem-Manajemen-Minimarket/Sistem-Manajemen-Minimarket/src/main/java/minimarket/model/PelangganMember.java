/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minimarket.model;

/**
 *
 * @author ThinkPad T14 G2
 */
public class PelangganMember {

    private String idPelanggan;
    private String nama;
    private String noTelepon;
    private boolean member;

    public PelangganMember(String id, String nama, String noTelepon, boolean member) {
        this.idPelanggan = id;
        this.nama = nama;
        this.noTelepon = noTelepon;
        this.member = member;
    }

    // Getter
    public String getIdPelanggan() {
        return idPelanggan;
    }

    public String getNama() {
        return nama;
    }

    public String getNoTelepon() {
        return noTelepon;
    }

    public boolean isMember() {
        return member;
    }

    // Setter
    public void setMember(boolean member) {
        this.member = member;
    }

    // Menghitung diskon berdasarkan status member dan subtotal
    public double hitungDiskon(double subtotal) {

        if (member) {
            if (subtotal >= 1000000) {
                return subtotal * 0.25;
            } else if (subtotal >= 800000) {
                return subtotal * 0.20;
            } else if (subtotal >= 600000) {
                return subtotal * 0.15;
            } else if (subtotal >= 400000) {
                return subtotal * 0.10;
            } else if (subtotal >= 200000) {
                return subtotal * 0.05;
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }

    // Menampilkan data pelanggan
    public void tampilkanData() {
        System.out.println(idPelanggan + " | " + nama + " | " + noTelepon + " | Member: " + (member ? "Ya" : "Tidak"));
    }
}
