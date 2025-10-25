import java.util.Scanner;

public class sewaMobil4 {
    public static void main(String[] args) {

         Scanner sc = new Scanner(System.in);

         System.out.println("Masukkan Lama Sewa Hari");
         int lamaSewa = sc.nextInt();

           // Cek batas lama sewa
        if (lamaSewa > 30) {
            System.out.println("Lama sewa maksimal 30 hari.");
            sc.close();
            return; // hentikan program
        }
         System.out.print("Masukkan jarak tempuh (km): ");
        int jarakTempuh = sc.nextInt();
         System.out.print("Masukkan jenis bahan bakar (pertalite/pertamax): ");
        String jenisBBM = sc.next().toLowerCase();

        //Deklarasi
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
            sc.close();
            // return;
        }

        
        // Menghitung total biaya bbm
        int totalBiaya = (biayaSewaPerHari + biayaSupirPerHari) * lamaSewa
                       + (biayaBBMPerKm * jarakTempuh);

                         // Tampilkan hasil
        System.out.println("-------------------------------------");
        System.out.println("Jenis BBM        : " + jenisBBM);
        System.out.println("Lama sewa (hari) : " + lamaSewa);
        System.out.println("Jarak tempuh (km): " + jarakTempuh);
        System.out.println("Total biaya sewa : Rp " + totalBiaya);
        System.out.println("-------------------------------------");

        sc.close();

        


    }   
}
