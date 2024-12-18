//Nama : Rafi Zeta Fauzan
//NIM : 244107060120
//Absen : 18


import java.util.Scanner;

public class UASSIB18 {
    static Scanner sc = new Scanner(System.in);
    static String[] namaTim;
    static int[][] skorTim; 
    static int[] totalSkor; 
    public static void main(String[] args) {
        int pilihan;

        do {
            System.out.println("\n=== MENU UTAMA ===");
            System.out.println("1. Input Data Skor Tim");
            System.out.println("2. Tampilkan Tabel Skor");
            System.out.println("3. Tentukan Juara");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu (1-4): ");
            pilihan = sc.nextInt();
            sc.nextLine(); 

            switch (pilihan) {
                case 1:
                    inputDataSkor();
                    break;
                case 2:
                    tampilkanTabelSkor();
                    break;
                case 3:
                    tentukanJuara();
                    break;
                case 4:
                    System.out.println("Terima kasih! Program selesai.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Coba lagi!");
            }
        } while (pilihan != 4);
    }

    static void inputDataSkor() {
        int jumlahTim = (20 % 3) + 4; 
        namaTim = new String[jumlahTim];
        skorTim = new int[jumlahTim][2]; 
        totalSkor = new int[jumlahTim]; 
        System.out.println("\nInput Data Skor Tim:");
        for (int i = 0; i < jumlahTim; i++) {
            System.out.print("Masukkan nama tim ke-" + (i + 1) + ": ");
            namaTim[i] = sc.nextLine();

            for (int j = 0; j < 2; j++) {
                int skor;
                do {
                    System.out.print("Masukkan skor " + namaTim[i] + " untuk Level " + (j + 1) + ": ");
                    skor = sc.nextInt();
                    if (skor < 0) {
                        System.out.println("Skor tidak boleh negatif. Coba lagi!");
                    }
                } while (skor < 0);

                skorTim[i][j] = skor < 35 ? 0 : skor; 
            }
            sc.nextLine(); 

            totalSkor[i] = skorTim[i][0] + skorTim[i][1];

            if (skorTim[i][0] > 50 && skorTim[i][1] > 50) {
                totalSkor[i] += 18; 
            }

            if (totalSkor[i] % 2 == 0) {
                totalSkor[i] -= 15;
            }
        }
    }

    static void tampilkanTabelSkor() {
        if (namaTim == null) {
            System.out.println("Tidak ada data yang bisa ditampilkan.");
            return;
        }

        System.out.println("\n=== Tabel Skor Tim ===");
        System.out.printf("%-15s%-10s%-10s%-10s\n", "Nama Tim", "Level 1", "Level 2", "Total Skor");

        for (int i = 0; i < namaTim.length; i++) {
            System.out.printf("%-15s%-10d%-10d%-10d\n", namaTim[i], skorTim[i][0], skorTim[i][1], totalSkor[i]);
        }
    }

    static void tentukanJuara() {
        if (namaTim == null) {
            System.out.println("Tidak ada data untuk menentukan juara.");
            return;
        }

        int maxSkor = totalSkor[0];
        int juara = 0;
        boolean seri = false;

        for (int i = 1; i < totalSkor.length; i++) {
            if (totalSkor[i] > maxSkor) {
                maxSkor = totalSkor[i];
                juara = i;
                seri = false;
            } else if (totalSkor[i] == maxSkor) {
                if (skorTim[i][1] == skorTim[juara][1]) { 
                    seri = true;
                }
            }
        }

        if (seri) {
            System.out.println("Turnamen berakhir seri. Tim terbaik adalah Rafi.");
        } else {
            System.out.println("Selamat kepada Tim " + namaTim[juara] + " yang menjadi juara!");
        }
    }
}
