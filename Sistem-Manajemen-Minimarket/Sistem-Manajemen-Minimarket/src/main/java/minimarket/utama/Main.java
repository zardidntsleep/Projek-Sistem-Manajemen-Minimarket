/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minimarket.utama;

import minimarket.repository.PenyimpananTransaksi;
import minimarket.pembayaran.Tunai;
import minimarket.manajemen.ManajemenProduk;
import minimarket.manajemen.LaporanPenjualan;
import minimarket.model.Admin;
import minimarket.model.DetailTransaksi;
import minimarket.model.Kasir;
import minimarket.model.Nota;
import minimarket.model.PelangganMember;
import minimarket.model.Produk;
import minimarket.model.Transaksi;

/**
 *
 * @author ThinkPad T14 G2
 */
public class Main {

    public static void main(String[] args) {
        Admin admin = new Admin("A001", "Admin Utama", "admin", "123");
        Kasir kasir = new Kasir("K001", "Sinta", "kasir", "123");
        PenyimpananTransaksi penyimpanan = new PenyimpananTransaksi();

        System.out.println("=== SISTEM MANAJEMEN MINIMARKET ===");
        System.out.println("1. Admin");
        System.out.println("2. Kasir");

        int pilihan = 1;
        switch (pilihan) {
            case 1:
                admin.tampilkanHakAkses();
                break;
            case 2:
                kasir.tampilkanHakAkses();
                break;
            default:
                System.out.println("Pilihan tidak tersedia.");
        }

        ManajemenProduk mp = new ManajemenProduk();
        Produk p1 = new Produk("P001", "Indomie Goreng", "Makanan", 3500);
        Produk p2 = new Produk("P002", "Aqua 600 ml", "Minuman", 4000);
        mp.tambahProduk(p1);
        mp.tambahProduk(p2);

        PelangganMember pelanggan = new PelangganMember("C001", "Ayuna", "08123456789", true);
        Transaksi transaksi = new Transaksi("TRX-PROGRAM", "2026-11-15", kasir, pelanggan);
        transaksi.tambahDetail(new DetailTransaksi(p1, 2));
        transaksi.tambahDetail(new DetailTransaksi(p2, 2));

        boolean berhasil = transaksi.prosesPembayaran(new Tunai(50000));
        if (berhasil) {
            penyimpanan.simpanTransaksi(transaksi);
            Nota nota = new Nota(transaksi);
            nota.cetakNota();
        }

        System.out.println("\n\n");
        LaporanPenjualan laporan = new LaporanPenjualan(penyimpanan);
        laporan.tampilkanLaporan(11, 2026);
    }
}
