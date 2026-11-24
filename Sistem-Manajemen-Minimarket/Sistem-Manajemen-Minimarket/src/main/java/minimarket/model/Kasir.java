/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minimarket.model;

/**
 *
 * @author ThinkPad T14 G2
 */
public class Kasir extends Pengguna {
    public Kasir(String id, String nama, String username, String password) {
        super(id, nama, username, password);
    }

    public void tampilkanHakAkses() {
        System.out.println("MENU KASIR");
        System.out.println("1. Kelola pelanggan/member");
        System.out.println("2. Lakukan transaksi");
        System.out.println("3. Cetak nota");
    }
}
