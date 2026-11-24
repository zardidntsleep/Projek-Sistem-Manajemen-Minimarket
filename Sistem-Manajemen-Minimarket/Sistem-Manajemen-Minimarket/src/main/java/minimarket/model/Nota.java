/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minimarket.model;

/**
 *
 * @author ThinkPad T14 G2
 */
public class Nota {
    private Transaksi transaksi;

    public Nota(Transaksi transaksi) {
        this.transaksi = transaksi;
    }

    public void cetakNota() {
        if (transaksi.getStatus().equals(StatusTransaksi.BERHASIL)) {
            System.out.println("\n========== MINIMARKET CERIA ==========");
            System.out.println("              NOTA PEMBELIAN");
            transaksi.tampilkanTransaksi();
            System.out.println("       Terima kasih telah berbelanja");
            System.out.println("======================================");
        } else {
            System.out.println("Nota tidak dapat dicetak karena transaksi gagal.");
        }
    }
}
