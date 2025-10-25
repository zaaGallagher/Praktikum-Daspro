import java.util.Scanner;

public class PLN5 {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);

        // Input data
        System.out.print("Masukkan daya listrik (VA): ");
        int daya = input.nextInt();

        System.out.print("Masukkan pemakaian listrik (kWh): ");
        double pemakaian = input.nextDouble();

        // Deklarasi variabel
        int tarifPerKwh = 0;
        final int biayaTetap = 50000;  // Rp 50.000

        // Menentukan tarif berdasarkan daya (IF-ELSE)
        if (daya == 900) {
            tarifPerKwh = 1300;
        } else if (daya == 1300 || daya == 2200) {
            tarifPerKwh = 1500;
        } else if (daya == 3500 || daya == 5500) {
            tarifPerKwh = 1700;
        } else {
            System.out.println("Daya tidak valid.");
            input.close();
            return; // hentikan program
        }

        // Hitung total sebelum pajak
        double totalSebelumPajak = biayaTetap + (tarifPerKwh * pemakaian);

        // Hitung PPN 10%
        double ppn = 0.10 * totalSebelumPajak;

        // Total akhir
        double totalBayar = totalSebelumPajak + ppn;

        // Output hasil
        System.out.println("--------------------------------");
        System.out.println("Daya listrik   : " + daya + " VA");
        System.out.println("Pemakaian      : " + pemakaian + " kWh");
        System.out.println("Tarif per kWh  : Rp " + tarifPerKwh);
        System.out.println("Biaya tetap    : Rp " + biayaTetap);
        System.out.println("PPN (10%)      : Rp " + ppn);
        System.out.println("Total tagihan  : Rp " + totalBayar);
        System.out.println("--------------------------------");

        input.close();
    }
}
