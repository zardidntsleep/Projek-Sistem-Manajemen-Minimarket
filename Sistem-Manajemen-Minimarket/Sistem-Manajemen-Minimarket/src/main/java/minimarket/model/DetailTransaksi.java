/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minimarket.model;

/**
 *
 * @author ThinkPad T14 G2
 */
public class DetailTransaksi {
    private Produk produk;
    private int jumlah;

    public DetailTransaksi(Produk produk, int jumlah) {
        this.produk = produk;
        this.jumlah = jumlah;
    }

    public Produk getProduk() { 
        return produk; 
    }
    public int getJumlah() { 
        return jumlah; 
    }

    public double hitungSubtotal() {
        return produk.getHarga() * jumlah;
    }

    public void tampilkanDetail() {
        System.out.println(produk.getNamaProduk() + " | " + jumlah + " x Rp" + produk.getHarga() + " = Rp" + hitungSubtotal());
    }
}
