import java.util.Scanner;

public class sewaMobil1 {
     public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);

        // Input dari pengguna
        System.out.print("Masukkan lama sewa (hari): ");
        int lamaSewa = input.nextInt();
        System.out.print("Masukkan jarak tempuh (km): ");
        int jarakTempuh = input.nextInt();
        input.nextLine(); // membersihkan buffer
        System.out.print("Masukkan jenis bahan bakar (pertalite/pertamax): ");
        String jenisBBM = input.nextLine().toLowerCase();

        // Deklarasi biaya tetap
        int biayaSewaPerHari = 300000;
        int biayaSupirPerHari = 200000;
        int biayaBBMPerKm = 0;

        // Menentukan biaya bahan bakar berdasarkan jenis
        if (jenisBBM.equals("pertalite")) {
            biayaBBMPerKm = 1000;
        } else if (jenisBBM.equals("pertamax")) {
            biayaBBMPerKm = 1300;
        } else {
            System.out.println("Jenis bahan bakar tidak valid!");
            input.close();
            return;
        }

        // Menghitung total biaya
        int totalBiaya = (biayaSewaPerHari + biayaSupirPerHari) * lamaSewa
                       + (biayaBBMPerKm * jarakTempuh);

        // Menampilkan hasil
        System.out.println("-------------------------------");
        System.out.println("Total biaya sewa: Rp " + totalBiaya);
        System.out.println("-------------------------------");

        input.close();
    }
}
    

