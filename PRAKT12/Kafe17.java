package PRAKT12;

import java.util.Scanner;

public class Kafe17 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Menu("Andi", true);

        int totalKeseluruhan = 0;
        char lanjut;

        do {
            System.out.print("\nMasukkan nomor menu yang ingin dipesan: ");
            int pilihanMenu = sc.nextInt();

            System.out.print("Masukkan jumlah item: ");
            int banyakItem = sc.nextInt();

            totalKeseluruhan += hitungTotalHarga(pilihanMenu, banyakItem);

            System.out.print("Apakah ingin pesan menu lain? (y/n): ");
            lanjut = sc.next().charAt(0);

        } while (lanjut == 'y' || lanjut == 'Y');

        System.out.print("\nMasukkan kode promo (jika ada): ");
        String kodePromo = sc.next();

        int totalAkhir = hitungTotalHargaNoAbsen(totalKeseluruhan, kodePromo);

        System.out.println("\n==============================");
        System.out.println("Total sebelum diskon: Rp " + totalKeseluruhan);
        System.out.println("Total yang harus dibayar: Rp " + totalAkhir);
        System.out.println("==============================");

        sc.close();
    }


    public static void Menu(String namaPelanggan, boolean isMember) {
        System.out.println("===== MENU RESTO KAFE =====");
        System.out.println("1. Kopi Hitam   - Rp 15,000");
        System.out.println("2. Cappuccino   - Rp 20,000");
        System.out.println("3. Latte        - Rp 22,000");
        System.out.println("4. Teh Tarik    - Rp 12,000");
        System.out.println("5. Roti Bakar   - Rp 10,000");
        System.out.println("6. Mie Goreng   - Rp 18,000");
        System.out.println("===========================");
        System.out.println("Selamat datang, " + namaPelanggan + (isMember ? " (Member)" : ""));
    }


    public static int hitungTotalHarga(int pilihanMenu, int banyakItem) {
        int[] hargaItems = { 15000, 20000, 22000, 12000, 10000, 18000 };
        return hargaItems[pilihanMenu - 1] * banyakItem;
    }


    public static int hitungTotalHargaNoAbsen(int totalHarga, String kodePromo) {
        if (kodePromo.equalsIgnoreCase("DISKON50")) {
            int diskon = totalHarga / 2;
            System.out.println("\nKode promo valid! Diskon 50%: Rp " + diskon);
            return totalHarga - diskon;

        } else if (kodePromo.equalsIgnoreCase("DISKON30")) {
            int diskon = (int)(totalHarga * 0.3);
            System.out.println("\nKode promo valid! Diskon 30%: Rp " + diskon);
            return totalHarga - diskon;

        } else {
            System.out.println("\nKode promo tidak valid. Tidak ada diskon.");
            return totalHarga;
        }
    }

}
