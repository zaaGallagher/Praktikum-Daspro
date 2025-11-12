import java.util.Scanner;

public class PemesananKafe17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Daftar menu dan harga (array paralel)
        String[] daftarMenu = {"Nasi Goreng", "Mie Goreng", "Roti Bakar", "Kentang Goreng", "Teh Tarik", "Cappucino", "Chocolate Ice"};
        double[] daftarHarga = {20000, 22000, 15000, 17000, 13000, 18000, 20000};

        // Array untuk menyimpan jumlah pesanan tiap menu
        int[] daftarPesanan = new int[daftarMenu.length];

        while (true) {
            System.out.print("Masukkan jumlah pesanan (ketik 0 untuk keluar): ");
            int jumlahPesanan = sc.nextInt();
            sc.nextLine(); // buang newline

            if (jumlahPesanan == 0) {
                System.out.println("\nTerima kasih telah memesan di Kafe kami!");
                break;
            }

            // Proses input pesanan sebanyak jumlah yang dimasukkan
            for (int i = 0; i < jumlahPesanan; i++) {
                System.out.print("Masukkan menu " + (i + 1) + ": ");
                String namaMenu = sc.nextLine();

                System.out.print("Masukkan jumlah: ");
                int jumlahItem = sc.nextInt();
                sc.nextLine(); // buang newline

                // Cari nama menu dengan linear search
                int indexMenu = -1;
                for (int j = 0; j < daftarMenu.length; j++) {
                    if (daftarMenu[j].equalsIgnoreCase(namaMenu)) {
                        indexMenu = j;
                        break;
                    }
                }

                // Jika ditemukan, simpan ke daftarPesanan
                if (indexMenu != -1) {
                    daftarPesanan[indexMenu] += jumlahItem;
                } else {
                    System.out.println("Menu \"" + namaMenu + "\" tidak tersedia.\n");
                }
            }

            // Hitung total harga
            double total = 0;
            for (int i = 0; i < daftarMenu.length; i++) {
                total += daftarPesanan[i] * daftarHarga[i];
            }

            // Tampilkan hasil
            System.out.println("\n===== Daftar Pesanan Anda =====");
            for (int i = 0; i < daftarMenu.length; i++) {
                if (daftarPesanan[i] > 0) {
                    System.out.println(daftarMenu[i] + " x" + daftarPesanan[i] + " = Rp " + (daftarPesanan[i] * daftarHarga[i]));
                }
            }
            System.out.println("-------------------------------");
            System.out.println("Total yang harus dibayar: Rp " + total);
            System.out.println();
        }
    }
}
