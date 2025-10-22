import java.util.Scanner;
public class sewaMobil2 {
    
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Input
        System.out.print("Masukkan lama sewa (hari): ");
        int lamaSewa = input.nextInt();

        System.out.print("Masukkan jarak tempuh (km): ");
        int jarakTempuh = input.nextInt();

        // Biaya tetap
        int biayaSewaPerHari = 300000;
        int biayaSupirPerHari = 200000;
        int biayaBBMPerKm = 1000;

        // Hitung total biaya awal
        double totalBiaya = (biayaSewaPerHari + biayaSupirPerHari) * lamaSewa
                            + (biayaBBMPerKm * jarakTempuh);

        // Cek diskon
        if (totalBiaya > 2000000) {
            double diskon = 0.05 * totalBiaya;
            totalBiaya = totalBiaya - diskon;
            System.out.println("Anda mendapatkan diskon 5% sebesar Rp " + diskon);
        }

        // Output
        System.out.println("-------------------------------");
        System.out.println("Total biaya sewa: Rp " + totalBiaya);
        System.out.println("-------------------------------");

        input.close();
    }
}

