import java.util.Scanner;

public class tugasBioskop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int HARGA_TIKET = 50000;
        int totalTiket = 0;
        double totalPenjualan = 0;
        int jumlahTiket;

        System.out.println("=== Program Penjualan Tiket Bioskop ===");
        System.out.println("Ketik angka negatif untuk berhenti.\n");

        while (true) {
            System.out.print("Masukkan jumlah tiket yang dibeli: ");
            jumlahTiket = sc.nextInt();

            // Jika input negatif → berhenti
            if (jumlahTiket < 0) {
                System.out.println("Input negatif. Program dihentikan.\n");
                break;
            }

            // Jika 0 → lewati transaksi
            if (jumlahTiket == 0) {
                System.out.println("Tidak ada tiket yang dibeli. Ulangi.\n");
                continue;
            }

            double totalHarga = jumlahTiket * HARGA_TIKET;
            double diskon = 0;

            // Hitung diskon
            if (jumlahTiket > 10) {
                diskon = 0.15;
            } else if (jumlahTiket > 4) {
                diskon = 0.10;
            }

            double hargaSetelahDiskon = totalHarga - (totalHarga * diskon);

            // Tambahkan ke total harian
            totalTiket += jumlahTiket;
            totalPenjualan += hargaSetelahDiskon;

            System.out.printf("Diskon: %.0f%%\n", diskon * 100);
            System.out.printf("Total harga setelah diskon: Rp %.0f\n\n", hargaSetelahDiskon);
        }

        System.out.println("=== Rekapitulasi Penjualan Hari Ini ===");
        System.out.println("Total tiket terjual: " + totalTiket);
        System.out.printf("Total pendapatan: Rp %.0f\n", totalPenjualan);
    }
}