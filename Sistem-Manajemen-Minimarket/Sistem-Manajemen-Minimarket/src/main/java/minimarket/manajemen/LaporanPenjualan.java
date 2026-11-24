/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minimarket.manajemen;

/**
 *
 * @author ThinkPad T14 G2
 */
import minimarket.model.Transaksi;
import minimarket.model.StatusTransaksi;
import minimarket.repository.PenyimpananTransaksi;
import java.util.ArrayList;
import java.text.NumberFormat;
import java.util.Locale;

public class LaporanPenjualan {

    private PenyimpananTransaksi penyimpanan;

    public LaporanPenjualan(PenyimpananTransaksi penyimpanan) {
        this.penyimpanan = penyimpanan;
    }

    // Mengubah angka bulan menjadi nama bulan
    public String getNamaBulan(int bulan) {
        switch (bulan) {
            case 1: return "JANUARI";
            case 2: return "FEBRUARI";
            case 3: return "MARET";
            case 4: return "APRIL";
            case 5: return "MEI";
            case 6: return "JUNI";
            case 7: return "JULI";
            case 8: return "AGUSTUS";
            case 9: return "SEPTEMBER";
            case 10: return "OKTOBER";
            case 11: return "NOVEMBER";
            case 12: return "DESEMBER";
            default: return "TIDAK DIKETAHUI";
        }
    }

    // Mengubah angka menjadi format Rupiah
    public String formatRupiah(double angka) {
        NumberFormat format =
                NumberFormat.getNumberInstance(new Locale("id", "ID"));

        format.setMaximumFractionDigits(0);
        format.setMinimumFractionDigits(0);

        return "Rp" + format.format(angka);
    }

    // Menampilkan laporan berdasarkan bulan dan tahun
    public void tampilkanLaporan(int bulan, int tahun) {

        if (bulan < 1 || bulan > 12) {
            System.out.println("Bulan tidak valid.");
            return;
        }

        ArrayList<Transaksi> data =
                penyimpanan.getDaftarTransaksi();

        ArrayList<Transaksi> transaksiTerpilih =
                new ArrayList<Transaksi>();

        double totalPendapatan = 0;
        double totalTunai = 0;
        double totalQRIS = 0;
        double totalPajak = 0;

        int jumlahTransaksi = 0;

        String periode = tahun + "-";

        if (bulan < 10) {
            periode = periode + "0" + bulan;
        } else {
            periode = periode + bulan;
        }

        // Memilih transaksi berhasil sesuai bulan dan tahun
        for (int i = 0; i < data.size(); i++) {

            Transaksi transaksi = data.get(i);

            String tanggal = transaksi.getTanggal();

            if (tanggal.startsWith(periode)
                    && transaksi.getStatus().equals(
                            StatusTransaksi.BERHASIL)) {

                transaksiTerpilih.add(transaksi);

                totalPendapatan += transaksi.getTotal();
                totalPajak += transaksi.getPajak();

                jumlahTransaksi++;

                String metode = transaksi.getPembayaran()
                        .getMetodePembayaran();

                if (metode.equalsIgnoreCase("Tunai")) {
                    totalTunai += transaksi.getTotal();
                } else if (metode.equalsIgnoreCase("QRIS")) {
                    totalQRIS += transaksi.getTotal();
                }
            }
        }

        double rataRata = 0;

        if (jumlahTransaksi > 0) {
            rataRata = totalPendapatan / jumlahTransaksi;
        }

        // Menampilkan laporan
        System.out.println("\n========== LAPORAN PENJUALAN ==========");
        System.out.println("             MINIMARKET ABC");
        System.out.println("=======================================");
        System.out.println("Periode : " + getNamaBulan(bulan)
                + " " + tahun);

        System.out.println("\nA. RINGKASAN PENJUALAN");
        System.out.println("---------------------------------------");
        System.out.println("Total Transaksi    : " + jumlahTransaksi);
        System.out.println("Total Pendapatan   : " + formatRupiah(totalPendapatan));
        System.out.println("Total Pajak        : " + formatRupiah(totalPajak));

        System.out.println("\nB. RINCIAN TRANSAKSI");
        System.out.println("---------------------------------------");
        System.out.printf("%-5s %-15s %15s%n",
                "No", "ID Transaksi", "Total");

        for (int i = 0; i < transaksiTerpilih.size(); i++) {

            Transaksi transaksi = transaksiTerpilih.get(i);

            System.out.printf("%-5d %-15s %15s%n",
                    (i + 1),
                    transaksi.getIdTransaksi(),
                    formatRupiah(transaksi.getTotal()));
        }

        System.out.println("\nC. METODE PEMBAYARAN");
        System.out.println("---------------------------------------");
        System.out.println("Tunai  : " + formatRupiah(totalTunai));
        System.out.println("QRIS   : " + formatRupiah(totalQRIS));

        System.out.println("\nD. STATISTIK");
        System.out.println("---------------------------------------");
        System.out.println("Jumlah Transaksi    : " + jumlahTransaksi);
        System.out.println("Rata-rata Transaksi : "
                + formatRupiah(rataRata));

        System.out.println("\n=======================================");
        System.out.println("          LAPORAN SELESAI");
        System.out.println("=======================================");
    }
}
