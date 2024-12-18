//Nama : Rafi Zeta Fauzan
//NIM : 244107060120
//Absen : 18

import java.util.Scanner;

public class UASSIB18 {
    static Scanner sc18 = new Scanner(System.in);
    static String[] namaTim18;
    static int[][] skorTim18;
    static int[] totalSkor18;

    public static void main(String[] args) {
        int pilihan18;

        do {
            System.out.println("\n=== MENU UTAMA ===");
            System.out.println("1. Input Data Skor Tim");
            System.out.println("2. Tampilkan Tabel Skor");
            System.out.println("3. Tentukan Juara");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu (1-4): ");
            pilihan18 = sc18.nextInt();
            sc18.nextLine();

            if (pilihan18 == 1) {
                inputDataSkor18();
            } else if (pilihan18 == 2) {
                tampilkanTabelSkor18();
            } else if (pilihan18 == 3) {
                tentukanJuara18();
            } else if (pilihan18 == 4) {
                System.out.println("Terima kasih! Program selesai.");
            } else {
                System.out.println("Pilihan tidak valid. Coba lagi!");
            }
        } while (pilihan18 != 4);
    }

    static void inputDataSkor18() {
        int jumlahTim18 = (20 % 3) + 4;
        namaTim18 = new String[jumlahTim18];
        skorTim18 = new int[jumlahTim18][2];
        totalSkor18 = new int[jumlahTim18];

        System.out.println("\nInput Data Skor Tim:");
        for (int i18 = 0; i18 < jumlahTim18; i18++) {
            System.out.print("Masukkan nama tim ke-" + (i18 + 1) + ": ");
            namaTim18[i18] = sc18.nextLine();

            for (int j18 = 0; j18 < 2; j18++) {
                int skor18;
                do {
                    System.out.print("Masukkan skor " + namaTim18[i18] + " untuk Level " + (j18 + 1) + ": ");
                    skor18 = sc18.nextInt();
                    if (skor18 < 0) {
                        System.out.println("Skor tidak boleh negatif. Coba lagi!");
                    }
                } while (skor18 < 0);

                if (j18 == 0 && skor18 < 35) {
                    skorTim18[i18][j18] = 0;
                } else {
                    skorTim18[i18][j18] = skor18;
                }
            }
            sc18.nextLine();

            totalSkor18[i18] = skorTim18[i18][0] + skorTim18[i18][1];
            if (skorTim18[i18][0] > 50 && skorTim18[i18][1] > 50) {
                totalSkor18[i18] += 18;
            }
            if (totalSkor18[i18] % 2 == 0) {
                totalSkor18[i18] -= 15;
            }
        }
    }

    static void tampilkanTabelSkor18() {
        if (namaTim18 == null) {
            System.out.println("Tidak ada data yang bisa ditampilkan.");
            return;
        }

        System.out.println("\n=== Tabel Skor Tim ===");
        System.out.printf("%-15s%-10s%-10s%-10s\n", "Nama Tim", "Level 1", "Level 2", "Total Skor");

        for (int i18 = 0; i18 < namaTim18.length; i18++) {
            System.out.printf("%-15s%-10d%-10d%-10d\n", namaTim18[i18], skorTim18[i18][0], skorTim18[i18][1], totalSkor18[i18]);
        }
    }

    static void tentukanJuara18() {
        if (namaTim18 == null) {
            System.out.println("Tidak ada data untuk menentukan juara.");
            return;
        }

        int maxSkor18 = totalSkor18[0];
        int juara18 = 0;
        boolean seri18 = false;

        for (int i18 = 1; i18 < totalSkor18.length; i18++) {
            if (totalSkor18[i18] > maxSkor18) {
                maxSkor18 = totalSkor18[i18];
                juara18 = i18;
                seri18 = false;
            } else if (totalSkor18[i18] == maxSkor18) {
                if (skorTim18[i18][1] == skorTim18[juara18][1]) {
                    seri18 = true;
                }
            }
        }

        if (seri18) {
            System.out.println("Turnamen berakhir seri. Tim terbaik adalah Rafi.");
        } else {
            System.out.println("Selamat kepada Tim " + namaTim18[juara18] + " yang menjadi juara!");
        }
    }
}
