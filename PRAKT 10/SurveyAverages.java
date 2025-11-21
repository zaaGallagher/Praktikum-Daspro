public class SurveyAverages {

    public static void main(String[] args) {

        int[][] survey = {
            {4, 5, 3, 4, 5, 4},
            {3, 4, 4, 3, 4, 3},
            {5, 5, 4, 5, 5, 5},
            {4, 4, 3, 4, 4, 4},
            {3, 3, 4, 3, 3, 4},
            {4, 5, 5, 4, 5, 5},
            {5, 4, 4, 5, 4, 4},
            {3, 4, 3, 3, 4, 3},
            {4, 5, 4, 4, 5, 4},
            {5, 5, 5, 5, 5, 5}
        };

        int total;
        double rata;

        //   RATA-RATA PER RESPONDEN
        System.out.println("=== Rata-rata Per Responden ===");
        for (int responden = 0; responden < survey.length; responden++) {
            total = 0;
            for (int pertanyaan = 0; pertanyaan < survey[0].length; pertanyaan++) {
                total += survey[responden][pertanyaan];
            }
            rata = total / (double) survey[0].length;
            System.out.println("Responden " + (responden + 1) + ": " + rata);
        }

        System.out.println();

        //   RATA-RATA PER PERTANYAAN
        System.out.println("=== Rata-rata Per Pertanyaan ===");
        for (int pertanyaan = 0; pertanyaan < survey[0].length; pertanyaan++) {
            total = 0;
            for (int responden = 0; responden < survey.length; responden++) {
                total += survey[responden][pertanyaan];
            }
            rata = total / (double) survey.length;
            System.out.println("Pertanyaan " + (pertanyaan + 1) + ": " + rata);
        }

        System.out.println();

        //   RATA-RATA KESELURUHAN
        System.out.println("=== Rata-rata Keseluruhan ===");
        total = 0;

        for (int responden = 0; responden < survey.length; responden++) {
            for (int pertanyaan = 0; pertanyaan < survey[0].length; pertanyaan++) {
                total += survey[responden][pertanyaan];
            }
        }

        int jumlahResponden = survey.length;
        int jumlahPertanyaan = survey[0].length;

        rata = total / (double) (jumlahResponden * jumlahPertanyaan);

        System.out.println("Rata-rata keseluruhan = " + rata);
    }
}
