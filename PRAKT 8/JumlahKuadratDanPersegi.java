import java.util.Scanner;

public class JumlahKuadratDanPersegi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan nilai n (minimal 1): ");
        int n = sc.nextInt();
        
        // Bagian 1: menghitung jumlah kuadrat 1 s.d n
        int jumlahKuadrat = 0;
        for (int i = 1; i <= n; i++) {
            jumlahKuadrat += i * i;
        }
        System.out.println("Jumlah kuadrat dari 1 s.d " + n + " = " + jumlahKuadrat);
        
        // Bagian 2: mencetak persegi angka ukuran n×n
        System.out.println("\nPersegi angka:");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                // Jika baris pertama/terakhir atau kolom pertama/terakhir → cetak angka
                if (i == 1 || i == n || j == 1 || j == n) {
                    System.out.print(n + " ");
                } else {
                    System.out.print("  "); // spasi dalam kotak
                }
            }
            System.out.println();
        }
    }
}

