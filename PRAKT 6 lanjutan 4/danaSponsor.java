import java.util.Scanner;
import java.text.DecimalFormat;

public class danaSponsor {
    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#,###");

        // Deklarasi biaya tetap
        double publikasi = 300000;
        double dekorasi = 500000;
        double konsumsiPanitia = 500000;
        double hadiah = 4000000;
        double operasional = 500000;
        double konsumsiPesertaPerOrang = 25000;
        double honorJuriPerJudul = 75000;
        double biayaPendaftaranTim = 50000;

        // Input jumlah tim
        System.out.println("===============================================");
        System.out.println("  PROGRAM PERHITUNGAN DANA SPONSORSHIP INTERCOMP");
        System.out.println("===============================================");
        System.out.print("Masukkan jumlah tim yang mengikuti kompetisi : ");
        int jumlahTim = input.nextInt();

        // Hitung total peserta, konsumsi, honor juri, dan total anggaran
        int jumlahPeserta = jumlahTim * 3;
        double totalKonsumsiPeserta = jumlahPeserta * konsumsiPesertaPerOrang;
        double totalHonorJuri = jumlahTim * honorJuriPerJudul;
        double totalAnggaran = publikasi + dekorasi + konsumsiPanitia + hadiah + operasional
                + totalKonsumsiPeserta + totalHonorJuri;

        // Tampilkan total anggaran
        System.out.println("-----------------------------------------------");
        System.out.println("Total anggaran keseluruhan : Rp " + df.format(totalAnggaran));
        System.out.println();

        // Pilihan bantuan dari Polinema
        System.out.print("Apakah ingin mengubah persentase dana bantuan Polinema? (Y/N): ");
        char jawab = input.next().charAt(0);

        double persenPolinema;
        if (jawab == 'Y' || jawab == 'y') {
            System.out.print("Masukkan persentase bantuan Polinema (misal 60 / 80 / 100): ");
            persenPolinema = input.nextDouble();
        } else {
            persenPolinema = 60; // default 60%
        }

        // Hitung dana Polinema, dana pendaftaran, dan sponsorship
        double danaPolinema = totalAnggaran * (persenPolinema / 100);
        double totalDanaPendaftaran = jumlahTim * biayaPendaftaranTim;
        double danaSponsorship = totalAnggaran - (danaPolinema + totalDanaPendaftaran);

        // Pastikan sponsorship tidak negatif (jika Polinema menanggung 100%)
        if (danaSponsorship < 0) {
            danaSponsorship = 0;
    
        System.out.println("\n============== RINCIAN PEMBIAYAAN ==============");
        System.out.printf("%-30s : Rp %s%n", "Total anggaran", df.format(totalAnggaran));
        System.out.printf("%-30s : Rp %s (%.0f%%)%n", "Dana Polinema", df.format(danaPolinema), persenPolinema);
        System.out.printf("%-30s : Rp %s%n", "Dana dari pendaftaran tim", df.format(totalDanaPendaftaran));
        System.out.printf("%-30s : Rp %s%n", "Dana sponsorship yang dibutuhkan", df.format(danaSponsorship));
        System.out.println("===============================================");
        System.out.println("Terima kasih telah menggunakan program ini!");
    }
 }
}
