import java.util.Scanner;
import java.text.DecimalFormat;
import java.lang.Math;

public class JBC8 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#,###");

        // Deklarasi konstanta
        double biayaCetakPerHal = 200;
        double beratKertasPerLembar = 3;      // gram
        double biayaHardCover = 20000;
        double biayaSoftCover = 10000;
        double beratHardCover = 250;          // gram
        double beratSoftCover = 100;          // gram
        double beratKemasan = 300;            // gram
        double biayaKirimPerKg = 15000;       // per kg

        // Input jumlah halaman
        System.out.println("===============================================");
        System.out.println("    PROGRAM PERHITUNGAN BIAYA CETAK BUKU JBC   ");
        System.out.println("===============================================");
        System.out.print("Masukkan jumlah halaman buku : ");
        int jumlahHalaman = input.nextInt();

        // Hitung jumlah lembar (karena cetak bolak-balik)
        int jumlahLembar = (int) Math.ceil(jumlahHalaman / 2.0);

        // Input jenis cover
        System.out.print("Masukkan jenis cover (hard/soft): ");
        String jenisCover = input.next().toLowerCase();

        double biayaCover, beratCover;

        if (jenisCover.equals("hard")) {
            biayaCover = biayaHardCover;
            beratCover = beratHardCover;
        } else if (jenisCover.equals("soft")) {
            biayaCover = biayaSoftCover;
            beratCover = beratSoftCover;
        } else {
            System.out.println("⚠️ Jenis cover tidak valid! Gunakan 'hard' atau 'soft'.");
            return;
        }

        // Hitung berat total
        double beratTotalGram = (jumlahLembar * beratKertasPerLembar) + beratCover + beratKemasan;
        double beratTotalKg = Math.ceil(beratTotalGram / 1000); // dibulatkan ke atas

        // Hitung biaya
        double biayaCetak = jumlahHalaman * biayaCetakPerHal;
        double biayaKirim = beratTotalKg * biayaKirimPerKg;
        double totalBiaya = biayaCetak + biayaCover + biayaKirim;

        System.out.println("\n============== RINCIAN BIAYA CETAK ==============");
        System.out.printf("%-30s : %s halaman%n", "Jumlah halaman", jumlahHalaman);
        System.out.printf("%-30s : %s lembar%n", "Jumlah lembar", jumlahLembar);
        System.out.printf("%-30s : %s cover%n", "Jenis cover", jenisCover);
        System.out.printf("%-30s : Rp %s%n", "Biaya cetak", df.format(biayaCetak));
        System.out.printf("%-30s : Rp %s%n", "Biaya cover", df.format(biayaCover));
        System.out.printf("%-30s : %.0f kg%n", "Berat paket", beratTotalKg);
        System.out.printf("%-30s : Rp %s%n", "Biaya pengiriman", df.format(biayaKirim));
        System.out.println("-----------------------------------------------");
        System.out.printf("%-30s : Rp %s%n", "TOTAL BIAYA", df.format(totalBiaya));
        System.out.println("===============================================");
        System.out.println("Terima kasih telah menggunakan layanan JBC!");
    }
}

