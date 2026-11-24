/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minimarket.pembayaran;

/**
 *
 * @author ThinkPad T14 G2
 */
public interface Pembayaran {
    boolean bayar(double total);
    String getMetodePembayaran();
}
