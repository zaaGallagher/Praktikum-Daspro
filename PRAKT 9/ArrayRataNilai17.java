import java.util.Scanner;

public class ArrayRataNilai17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan jumlah mahasiswa : ");
        int jumlahMhs = sc.nextInt();

        int[] nilaiMhs = new int[jumlahMhs];
        double totalLulus = 0, totalTidakLulus = 0;
        int jumlahLulus = 0, jumlahTidakLulus = 0;

        for (int i = 0; i < jumlahMhs; i++) {
            System.out.print("Masukkan nilai mahasiswa ke-" + (i + 1) + " : ");
            nilaiMhs[i] = sc.nextInt();
        }
        
        for (int i = 0; i < jumlahMhs; i++) {
            if (nilaiMhs[i] > 70) {
                totalLulus += nilaiMhs[i];
                jumlahLulus++;
            } else {
                totalTidakLulus += nilaiMhs[i];
                jumlahTidakLulus++;
            }
        }

        double rataLulus = (jumlahLulus > 0) ? (totalLulus / jumlahLulus) : 0;
        double rataTidakLulus = (jumlahTidakLulus > 0) ? (totalTidakLulus / jumlahTidakLulus) : 0;

        System.out.println();
        if (jumlahLulus > 0)
            System.out.println("Rata-rata nilai lulus = " + rataLulus);
        else
            System.out.println("Tidak ada mahasiswa yang lulus.");

        if (jumlahTidakLulus > 0)
            System.out.println("Rata-rata nilai tidak lulus = " + rataTidakLulus);
        else
            System.out.println("Semua mahasiswa lulus.");
    }
}
