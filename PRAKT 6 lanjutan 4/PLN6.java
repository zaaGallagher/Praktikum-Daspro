import java.util.Scanner;
import java.text.DecimalFormat;

public class PLN6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#,###"); // untuk format angka dengan koma ribuan

        // Deklarasi variabel
        double biayaTetap = 50000;
        double tarifPerKwh;
        double ppn = 0.10;
        double totalSebelumPajak;
        double totalSetelahPajak;

        // Input daya listrik
        System.out.println("===========================================");
        System.out.println("     PROGRAM PERHITUNGAN BIAYA LISTRIK     ");
        System.out.println("===========================================");
        System.out.print("Masukkan daya listrik (VA): ");
        int daya = input.nextInt();

        // Input pemakaian listrik
        System.out.print("Masukkan pemakaian listrik (kWh): ");
        double kwh = input.nextDouble();
        System.out.println("-------------------------------------------");

        // Tentukan tarif per kWh berdasarkan daya menggunakan switch-case
        switch (daya) {
            case 900:
                tarifPerKwh = 1300;
                break;
            case 1300:
            case 2200:
                tarifPerKwh = 1500;
                break;
            case 3500:
            case 5500:
                tarifPerKwh = 1700;
                break;
            default:
                System.out.println("⚠️  Daya yang dimasukkan tidak valid!");
                return;
        }

        // Hitung total biaya sebelum dan sesudah pajak
        totalSebelumPajak = biayaTetap + (tarifPerKwh * kwh);
        totalSetelahPajak = totalSebelumPajak + (totalSebelumPajak * ppn);

        System.out.println("              RINCIAN BIAYA LISTRIK        ");
        System.out.println("===========================================");
        System.out.printf("%-25s : %s VA%n", "Daya listrik", df.format(daya));
        System.out.printf("%-25s : %.2f kWh%n", "Pemakaian listrik", kwh);
        System.out.printf("%-25s : Rp %s%n", "Tarif per kWh", df.format(tarifPerKwh));
        System.out.printf("%-25s : Rp %s%n", "Biaya tetap", df.format(biayaTetap));
        System.out.printf("%-25s : Rp %s%n", "Total sebelum pajak", df.format(totalSebelumPajak));
        System.out.printf("%-25s : Rp %s%n", "PPN (10%)", df.format(totalSebelumPajak * ppn));
        System.out.println("-------------------------------------------");
        System.out.printf("%-25s : Rp %s%n", "TOTAL BAYAR", df.format(totalSetelahPajak));
        System.out.println("===========================================");
        System.out.println("Terima kasih telah menggunakan layanan PLN!");
    }

}
    

