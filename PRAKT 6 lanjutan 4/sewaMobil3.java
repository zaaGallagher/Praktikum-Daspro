import java.util.Scanner;

public class sewaMobil3 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Input data
        System.out.print("Masukkan lama sewa (hari): ");
        int lamaSewa = input.nextInt();

        // Cek batas lama sewa
        if (lamaSewa > 30) {
            System.out.println("Lama sewa maksimal 30 hari.");
            input.close();
            return; // hentikan program
        }

        System.out.print("Masukkan jarak tempuh (km): ");
        int jarakTempuh = input.nextInt();

        // Biaya tetap
        int biayaSewaPerHari = 300000;
        int biayaSupirPerHari = 200000;
        int biayaBBMPerKm = 1000;

        // Hitung total biaya
        int totalBiaya = (biayaSewaPerHari + biayaSupirPerHari) * lamaSewa
                        + (biayaBBMPerKm * jarakTempuh);

        // Output
        System.out.println("-------------------------------");
        System.out.println("Total biaya sewa: Rp " + totalBiaya);
        System.out.println("-------------------------------");

        input.close();
    }
}
