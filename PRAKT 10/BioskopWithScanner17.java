import java.util.Scanner;

public class BioskopWithScanner17 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Array 4 baris x 2 kolom
        String[][] penonton = new String[4][2];

        int menu;

        do {
            System.out.println("\n=== MENU BIOSKOP ===");
            System.out.println("1. Input data penonton");
            System.out.println("2. Tampilkan daftar penonton");
            System.out.println("3. Exit");
            System.out.print("Pilih menu: ");
            menu = sc.nextInt();
            sc.nextLine(); 

            switch (menu) {

                case 1:
                    while (true) {
                        System.out.print("Masukkan nomor baris (0-3): ");
                        int baris = sc.nextInt();

                        System.out.print("Masukkan nomor kolom (0-1): ");
                        int kolom = sc.nextInt();
                        sc.nextLine();

                        // Validasi baris/kolom
                        if (baris < 0 || baris >= penonton.length ||
                            kolom < 0 || kolom >= penonton[0].length) {
                            System.out.println("Kursi tidak tersedia! Masukkan lagi.\n");
                            continue;  
                        }

                        // Warning jika kursi sudah terisi
                        if (penonton[baris][kolom] != null) {
                            System.out.println("Kursi sudah ditempati oleh: " + penonton[baris][kolom]);
                            System.out.println("Silakan pilih kursi lain.\n");
                            continue;
                        }

                        // Input nama penonton
                        System.out.print("Masukkan nama penonton: ");
                        String nama = sc.nextLine();
                        penonton[baris][kolom] = nama;

                        System.out.println("Data berhasil disimpan!");
                        break;
                    }
                    break;

                case 2:
                    System.out.println("\n=== DAFTAR PENONTON ===");
                    for (int i = 0; i < penonton.length; i++) {
                        System.out.print("Baris " + i + ": ");
                        for (int j = 0; j < penonton[i].length; j++) {
                            if (penonton[i][j] == null) {
                                System.out.print("***\t");
                            } else {
                                System.out.print(penonton[i][j] + "\t");
                            }
                        }
                        System.out.println();
                    }
                    break;

                case 3:
                    System.out.println("Keluar program...");
                    break;

                default:
                    System.out.println("Menu tidak valid.");
            }

        } while (menu != 3);

        sc.close();
    }
}
