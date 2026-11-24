/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minimarket.manajemen;

/**
 *
 * @author ThinkPad T14 G2
 */
import java.util.ArrayList;
import minimarket.model.Produk;

public class ManajemenProduk {
    private ArrayList<Produk> daftarProduk;

    public ManajemenProduk() {
        daftarProduk = new ArrayList<Produk>();
    }

    public void tambahProduk(Produk produk) {
        if (cariProduk(produk.getKodeProduk()) == null) {
            daftarProduk.add(produk);
            System.out.println("Produk " + produk.getNamaProduk() + " berhasil ditambahkan.");
        } else {
            System.out.println("Produk dengan kode " + produk.getKodeProduk() + " sudah digunakan.");
        }
    }

    public Produk cariProduk(String kode) {
        for (int i = 0; i < daftarProduk.size(); i++) {
            if (daftarProduk.get(i).getKodeProduk()
                    .equalsIgnoreCase(kode)) {
                return daftarProduk.get(i);
            }
        }
        return null;
    }

    public void ubahHarga(String kode, double hargaBaru) {
        Produk produk = cariProduk(kode);

        if (produk != null) {
            produk.setHarga(hargaBaru);
            System.out.println("Harga produk " + produk.getNamaProduk() + " berhasil diperbarui.");
        } else {
            System.out.println("Produk dengan kode " + kode + " tidak ditemukan.");
        }
    }

    public void hapusProduk(String kode) {
        Produk produk = cariProduk(kode);

        if (produk != null) {
            daftarProduk.remove(produk);
            System.out.println("Produk " + produk.getNamaProduk() + " berhasil dihapus.");
        } else {
            System.out.println("Produk dengan kode " + kode + " tidak ditemukan.");
        }
    }

    public void tampilkanSemuaProduk() {
        System.out.println("DAFTAR PRODUK");

        for (int i = 0; i < daftarProduk.size(); i++) {
            daftarProduk.get(i).tampilkanInfo();
        }
    }

    public ArrayList<Produk> getDaftarProduk() {
        return daftarProduk;
    }
}

