import java.util.Scanner;

public class BeasiswaApp {

    static final int MAX = 100;
    static String[] nama = new String[MAX];
    static String[] nim = new String[MAX];
    static double[] ipk = new double[MAX];
    static String[] jenis = new String[MAX];
    static int[] penghasilan = new int[MAX];

    static int jumlahData = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\n=== SISTEM PENDAFTARAN BEASISWA ===");
            System.out.println("1. Tambah Data Pendaftar");
            System.out.println("2. Tampilkan Semua Pendaftar");
            System.out.println("3. Cari Pendaftar Berdasarkan Jenis Beasiswa");
            System.out.println("4. Rata-rata IPK per Jenis Beasiswa");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = sc.nextInt();
            sc.nextLine();

            switch (pilihan) {
                case 1 -> tambahData(sc);
                case 2 -> tampilkanData();
                case 3 -> cariJenis(sc);
                case 4 -> hitungRataIPK();
                case 5 -> System.out.println("Program selesai.");
                default -> System.out.println("Pilihan tidak valid!");
            }

        } while (pilihan != 5);
    }

    static void tambahData(Scanner sc) {
        if (jumlahData >= MAX) {
            System.out.println("Belum ada pendaftar");
            return;
        }

        System.out.print("Nama: ");
        nama[jumlahData] = sc.nextLine();

        System.out.print("NIM: ");
        nim[jumlahData] = sc.nextLine();

        System.out.print("IPK terakhir: ");
        ipk[jumlahData] = sc.nextDouble();
        sc.nextLine();

        String j;
        while (true) {
            System.out.print("Jenis beasiswa (Reguler/Unggulan/Riset): ");
            j = sc.nextLine();

            if (j.equalsIgnoreCase("Reguler") ||
                j.equalsIgnoreCase("Unggulan") ||
                j.equalsIgnoreCase("Riset")) {
                jenis[jumlahData] = kapital(j);
                break;
            } else {
                System.out.println("Jenis beasiswa tidak valid!");
            }
        }

        int p;
        while (true) {
            System.out.print("Penghasilan orang tua (maks 2000000): ");
            p = sc.nextInt();
            sc.nextLine();

            if (p <= 2000000) {
                penghasilan[jumlahData] = p;
                break;
            } else {
                System.out.println("Penghasilan melebihi batas!");
            }
        }

        jumlahData++;
        System.out.println("Data berhasil ditambahkan!");
    }

    static void tampilkanData() {
        if (jumlahData == 0) {
            System.out.println("Belum ada data.");
            return;
        }

        System.out.println("\n=== DATA PENDAFTAR BEASISWA ===");
        System.out.printf("%-20s %-12s %-6s %-12s %-12s\n",
                "Nama", "NIM", "IPK", "Beasiswa", "Penghasilan");

        for (int i = 0; i < jumlahData; i++) {
            System.out.printf("%-20s %-12s %-6.2f %-12s %-12d\n",
                    nama[i], nim[i], ipk[i], jenis[i], penghasilan[i]);
        }
    }

    static void cariJenis(Scanner sc) {
        if (jumlahData == 0) {
            System.out.println("Belum ada data.");
            return;
        }

        System.out.print("Masukkan jenis beasiswa yang dicari: ");
        String cari = kapital(sc.nextLine());
        boolean ditemukan = false;

        System.out.println("\nHasil pencarian untuk: " + cari);
        for (int i = 0; i < jumlahData; i++) {
            if (jenis[i].equalsIgnoreCase(cari)) {
                System.out.printf("%-20s %-12s %-6.2f %-12s %-12d\n",
                        nama[i], nim[i], ipk[i], jenis[i], penghasilan[i]);
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            System.out.println("Tidak ada pendaftar dengan jenis tersebut.");
        }
    }

    static void hitungRataIPK() {
        String[] tipe = {"Reguler", "Unggulan", "Riset"};

        for (String t : tipe) {
            double total = 0;
            int hitung = 0;

            for (int i = 0; i < jumlahData; i++) {
                if (jenis[i].equalsIgnoreCase(t)) {
                    total += ipk[i];
                    hitung++;
                }
            }

            if (hitung > 0)
                System.out.println("Rata-rata IPK " + t + " = " + (total / hitung));
            else
                System.out.println("Tidak ada data untuk " + t);
        }
    }

    static String kapital(String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
    }
}
