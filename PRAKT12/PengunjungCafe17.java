package PRAKT12;

public class PengunjungCafe17 {
    public static void main(String[] args) {
        daftarPengunjung("Ali", "Budi", "Citra");
        daftarPengunjung("Andi");
        daftarPengunjung("Doni", "Eti", "Fahmi", "Galih");
    }

    static void daftarPengunjung(String... namaPengunjung){
        System.out.println("Dasftar nama pengunjung: ");
        for (String namaPengunjung1 : namaPengunjung) {
            System.out.println("- " + namaPengunjung1);
        }
    }
}
