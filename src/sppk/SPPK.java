/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sppk;

import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class SPPK {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int penjualan[][], nilaiX = 0, dekremen = -1, hari = 0, ramal, X;
        boolean mulaiMeramal = false;
        double nilaiA = 0, nilaiB = 0, jumlahY = 0, jumlahXY = 0, jumlahXX = 0;

        /**
         * input data
         */
        System.out.println("Input Jumlah hari penjualan : ");
        hari = input.nextInt();
        penjualan = new int[hari][2];
        if (hari % 2 == 1) {
            nilaiX = ((hari - 1) / 2) * -1;
            dekremen = 1;
        } else if (hari % 2 == 0) {
            nilaiX = (hari - 1) * -1;
            dekremen = 2;
        }
        for (int i = nilaiX; i < (nilaiX * -1) + 1; i += dekremen) {
            System.out.println("Input penjualan hari ke - " + (hari + 1));
            penjualan[hari][0] = input.nextInt();
            penjualan[hari][1] = i;
            hari++;
        }

        /**
         * perhitungan jumlah
         */
        for (int i = 0; i < penjualan.length; i++) {
            jumlahY += penjualan[i][0];
            jumlahXY += penjualan[i][0] * penjualan[i][1];
            jumlahXX += penjualan[i][1] * penjualan[i][1];
        }
        nilaiA = jumlahY / penjualan.length;
        nilaiB = jumlahXY / jumlahXX;

        /**
         * cetak data
         */
        System.out.println("\n\n\n");
        System.out.println("| Hari\t\t| Penjualan(Y)\t| X\t| XY\t| X kuadrat\t|");
        for (int i = 0; i < penjualan.length; i++) {
            System.out.println("| Hari - " + (i + 1)
                    + "\t| " + penjualan[i][0] // Penjualan (Y)
                    + "\t\t| " + penjualan[i][1] // Nilai X
                    + "\t| " + penjualan[i][0] * penjualan[i][1] // Nilai XY
                    + "\t| " + penjualan[i][1] * penjualan[i][1] // Nilal X kuadrat
                    + "\t\t|");
        }
        System.out.println("| Jumlah\t| " + jumlahY + "\t|\t| " + jumlahXY + "\t| " + jumlahXX + "\t\t|");
        System.out.println("\nRumus Least Square dari data tersebut adalah:"
                + "\nY = a + bX"
                + "\nY = " + nilaiA + " + " + nilaiB + "X");

        /**
         * peramalan
         */
        System.out.println("\n\n\n");
        System.out.println("Ingin melihat peramalan hingga hari ke berapa? (diatas hari ke 7)");
        ramal = input.nextInt();
        if (ramal < 8) {
            System.out.println("harus diatas hari ke 7");
        } else {
            mulaiMeramal = true;
        }
        if (mulaiMeramal) {
            X = penjualan[6][1];
            for (int i = 0; i < (ramal - 7); i++) {
                X++;
                System.out.println("peramalan pada hari ke " + (hari + 1) + " : " + (nilaiA + (nilaiB * X)));
                hari++;
            }
        }
    }

}
