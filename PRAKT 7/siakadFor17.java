import java.util.Scanner;

public class siakadFor17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double nilai, tertinggi = 0, terendah = 100;
        
        for (int i=1; i<=10; i++){
                System.out.println("Masukkan nilai mahasiswa ke-" + i + ": ");
                nilai = sc.nextInt();
            if (nilai > tertinggi) {
                tertinggi = nilai;
        }
        if(nilai < terendah){
            terendah = nilai;
        }
    System.out.println("Nilai tertinggi: " + tertinggi);
    System.out.println("Nilai terendah: " + terendah);
    }
}
}
