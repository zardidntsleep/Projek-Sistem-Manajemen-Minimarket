/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minimarket.pembayaran;

/**
 *
 * @author ThinkPad T14 G2
 */
public class QRIS implements Pembayaran {
    private String nomorReferensi;

    public QRIS(String nomorReferensi) {
        this.nomorReferensi = nomorReferensi;
    }

    public boolean bayar(double total) {
        if (nomorReferensi != null && !nomorReferensi.equals("")) {
            System.out.println("Pembayaran QRIS berhasil disimulasikan.");
            System.out.println("Nomor referensi: " + nomorReferensi);
            return true;
        } else {
            System.out.println("Nomor referensi QRIS belum diisi.");
            return false;
        }
    }

    public String getMetodePembayaran() {
        return "QRIS";
    }
}
