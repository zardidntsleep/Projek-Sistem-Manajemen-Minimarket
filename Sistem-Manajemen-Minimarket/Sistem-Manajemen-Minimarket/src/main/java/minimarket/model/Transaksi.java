/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minimarket.model;

/**
 *
 * @author ThinkPad T14 G2
 */
import minimarket.pembayaran.Pembayaran;
import java.util.ArrayList;

public class Transaksi {

    private String idTransaksi;
    private String tanggal;
    private Kasir kasir;
    private PelangganMember pelanggan;
    private ArrayList<DetailTransaksi> daftarDetail;
    private Pembayaran pembayaran;
    private String status;
    private double subtotal;
    private double diskon;
    private double pajak;
    private double total;

    public Transaksi(String id, String tanggal, Kasir kasir, PelangganMember pelanggan) {
        idTransaksi = id;
        this.tanggal = tanggal;
        this.kasir = kasir;
        this.pelanggan = pelanggan;
        daftarDetail = new ArrayList<DetailTransaksi>();
        status = StatusTransaksi.GAGAL;
    }

    // Getter
    public String getIdTransaksi() {
        return idTransaksi;
    }

    public String getTanggal() {
        return tanggal;
    }

    public Kasir getKasir() {
        return kasir;
    }

    public PelangganMember getPelanggan() {
        return pelanggan;
    }

    public String getStatus() {
        return status;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getDiskon() {
        return diskon;
    }

    public double getPajak() {
        return pajak;
    }

    public double getTotal() {
        return total;
    }

    public ArrayList<DetailTransaksi> getDaftarDetail() {
        return daftarDetail;
    }

    public Pembayaran getPembayaran() {
        return pembayaran;
    }

    // Menambahkan detail barang ke transaksi
    public void tambahDetail(DetailTransaksi detail) {
        if (detail != null &&
            detail.getProduk() != null &&
            detail.getJumlah() > 0) {

            daftarDetail.add(detail);

        } else {
            System.out.println("Detail transaksi tidak valid.");
        }
    }

    // Menghitung subtotal seluruh barang
    public double hitungSubtotal() {
        subtotal = 0;

        for (int i = 0; i < daftarDetail.size(); i++) {
            subtotal = subtotal + daftarDetail.get(i).hitungSubtotal();
        }

        return subtotal;
    }

    // Menghitung diskon melalui class Pelanggan
    public double hitungDiskon() {
        if (pelanggan != null) {
            diskon = pelanggan.hitungDiskon(subtotal);
        } else {
            diskon = 0;
        }

        return diskon;
    }

    // Menghitung pajak 10%
    public double hitungPajak() {
        pajak = (subtotal - diskon) * 0.10;
        return pajak;
    }

    // Menghitung total pembayaran
    public double hitungTotal() {
        total = subtotal - diskon + pajak;
        return total;
    }

    // Memproses pembayaran
    public boolean prosesPembayaran(Pembayaran pembayaran) {
        this.pembayaran = pembayaran;

        hitungSubtotal();
        hitungDiskon();
        hitungPajak();
        hitungTotal();

        if (daftarDetail.size() == 0) {
            System.out.println("Transaksi belum memiliki barang.");
            status = StatusTransaksi.GAGAL;
            return false;
        }

        if (pembayaran != null && pembayaran.bayar(total)) {
            status = StatusTransaksi.BERHASIL;
            return true;
        } else {
            status = StatusTransaksi.GAGAL;
            return false;
        }
    }

    // Menampilkan informasi transaksi
    public void tampilkanTransaksi() {
        System.out.println("ID Transaksi: " + idTransaksi);
        System.out.println("Tanggal: " + tanggal);
        System.out.println("Kasir: " + kasir.getNama());

        if (pelanggan != null) {
            System.out.println("Pelanggan: " + pelanggan.getNama());
        } else {
            System.out.println("Pelanggan: Umum");
        }

        System.out.println("--------------------------------");

        for (int i = 0; i < daftarDetail.size(); i++) {
            daftarDetail.get(i).tampilkanDetail();
        }

        System.out.println("--------------------------------");
        System.out.println("Subtotal: Rp" + subtotal);
        System.out.println("Diskon: Rp" + diskon);
        System.out.println("Pajak 10%: Rp" + pajak);
        System.out.println("Total: Rp" + total);

        if (pembayaran != null) {
            System.out.println(
                "Metode pembayaran: " +
                pembayaran.getMetodePembayaran()
            );
        }

        System.out.println("Status: " + status);
    }
}
