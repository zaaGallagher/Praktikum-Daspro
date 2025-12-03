package PRAKT12;

import java.util.Scanner;

public class RekapPenjualanCafe17 {

     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan jumlah menu: ");
        int jumlahMenu = sc.nextInt();

        System.out.print("Masukkan jumlah hari: ");
        int jumlahHari = sc.nextInt();
        sc.nextLine();

        String[] menu = new String[jumlahMenu];
        int[][] data = new int[jumlahMenu][jumlahHari];

        inputPenjualan(menu, data);
        tampilkanData(menu, data);
        tampilkanTertinggi(menu, data);
        tampilkanRataRata(menu, data);
    }

    public static void inputPenjualan(String[] menu, int[][] data) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < menu.length; i++) {
            System.out.print("Masukkan nama menu ke-" + (i + 1) + ": ");
            menu[i] = sc.nextLine();

            for (int j = 0; j < data[i].length; j++) {
                System.out.print("Masukkan jumlah penjualan " + menu[i] + " pada hari ke-" + (j + 1) + ": ");
                data[i][j] = sc.nextInt();
            }
            sc.nextLine(); 
        }
    }

    public static void tampilkanData(String[] menu, int[][] data) {
        System.out.println("\n=== Rekap Penjualan ===");
        System.out.print("Menu/Hari\t");
        
        for (int h = 1; h <= data[0].length; h++) {
            System.out.print("Hari " + h + "\t");
        }
        System.out.println();

        for (int i = 0; i < menu.length; i++) {
            System.out.print(menu[i] + "\t\t");
            for (int j = 0; j < data[i].length; j++) {
                System.out.print(data[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void tampilkanTertinggi(String[] menu, int[][] data) {
        int max = -1;
        int indexMax = 0;

        for (int i = 0; i < data.length; i++) {
            int total = 0;
            for (int j = 0; j < data[i].length; j++) {
                total += data[i][j];
            }

            if (total > max) {
                max = total;
                indexMax = i;
            }
        }

        System.out.println("\nMenu dengan penjualan tertinggi:");
        System.out.println(menu[indexMax] + " dengan total: " + max);
    }

    public static void tampilkanRataRata(String[] menu, int[][] data) {
        System.out.println("\n=== Rata-rata Penjualan Tiap Menu ===");
        for (int i = 0; i < data.length; i++) {
            int total = 0;
            for (int j = 0; j < data[i].length; j++) {
                total += data[i][j];
            }
            double rata = (double) total / data[i].length;
            System.out.println(menu[i] + " : " + rata);
        }
    }

   
}

