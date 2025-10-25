import java.util.Scanner;
import java.text.DecimalFormat;
import java.lang.Math;

public class JBC9 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#,###");

        // Deklarasi konstanta
        double biayaCetakPerHal = 200;
        double biayaHardCover = 20000;
        double beratKertasPerLembar = 3;   // gram
        double beratHardCover = 250;       // gram
        double beratKemasan = 300;         // gram
        double biayaKirimPerKg = 15000;
        double biayaKurirLokal = 20000;    // untuk Malang/Batu

        // Input jumlah halaman
        System.out.println("===============================================");
        System.out.println("     PROGRAM PERHITUNGAN BIAYA CETAK BUKU JBC  ");
        System.out.println("===============================================");
        System.out.print("Masukkan jumlah halaman buku : ");
        int jumlahHalaman = input.nextInt();
        input.nextLine(); // membersihkan buffer

        // Hitung jumlah lembar (bolak-balik)
        int jumlahLembar = (int) Math.ceil(jumlahHalaman / 2.0);

        // Input kota tujuan
        System.out.print("Masukkan kota tujuan pengiriman : ");
        String kota = input.nextLine().trim().toLowerCase();

        // Hitung berat total (gram → kg dibulatkan ke atas)
        double beratTotalGram = (jumlahLembar * beratKertasPerLembar) + beratHardCover + beratKemasan;
        double beratTotalKg = Math.ceil(beratTotalGram / 1000);

        // Hitung biaya pengiriman
        double biayaKirim;
        if (kota.equals("malang") || kota.equals("batu")) {
            biayaKirim = biayaKurirLokal;
        } else {
            biayaKirim = beratTotalKg * biayaKirimPerKg;
        }

        // Hitung biaya cetak dan total
        double biayaCetak = jumlahHalaman * biayaCetakPerHal;
        double totalBiaya = biayaCetak + biayaHardCover + biayaKirim;

        System.out.println("\n============== RINCIAN BIAYA CETAK ==============");
        System.out.printf("%-30s : %s halaman%n", "Jumlah halaman", jumlahHalaman);
        System.out.printf("%-30s : %s lembar%n", "Jumlah lembar (bolak-balik)", jumlahLembar);
        System.out.printf("%-30s : Rp %s%n", "Biaya cetak per halaman", df.format(biayaCetakPerHal));
        System.out.printf("%-30s : Rp %s%n", "Total biaya cetak", df.format(biayaCetak));
        System.out.printf("%-30s : Rp %s%n", "Biaya hard cover", df.format(biayaHardCover));
        System.out.printf("%-30s : %.0f kg%n", "Berat paket (dibulatkan)", beratTotalKg);
        System.out.printf("%-30s : Rp %s%n", "Biaya pengiriman", df.format(biayaKirim));
        System.out.println("-----------------------------------------------");
        System.out.printf("%-30s : Rp %s%n", "TOTAL BIAYA", df.format(totalBiaya));
        System.out.println("===============================================");
        System.out.println("Terima kasih telah menggunakan layanan JBC!");
    }
}

