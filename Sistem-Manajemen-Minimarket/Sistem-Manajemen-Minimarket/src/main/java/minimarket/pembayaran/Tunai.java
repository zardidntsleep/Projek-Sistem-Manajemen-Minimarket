/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minimarket.pembayaran;

import minimarket.pembayaran.Pembayaran;

/**
 *
 * @author ThinkPad T14 G2
 */
public class Tunai implements Pembayaran {
    private double uangDibayar;
    private double kembalian;

    public Tunai(double uangDibayar) {
        this.uangDibayar = uangDibayar;
        kembalian = 0;
    }

    public boolean bayar(double total) {
        if (uangDibayar >= total) {
            kembalian = uangDibayar - total;
            System.out.println("Pembayaran tunai berhasil.");
            System.out.println("Kembalian: Rp" + kembalian);
            return true;
        } else {
            System.out.println("Uang pembayaran kurang.");
            return false;
        }
    }

    public String getMetodePembayaran() {
        return "Tunai";
    }

    public double getKembalian() { 
        return kembalian; 
    }
}
