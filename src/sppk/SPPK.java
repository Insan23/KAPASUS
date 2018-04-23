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
        int penjualan[][];
        int nilaiX = 0;
        int dekremen = -1;

        double nilaiA = 0, nilaiB = 0, jumlahY = 0, jumlahXY = 0, jumlahXX = 0;

        System.out.println("Input Jumlah hari penjualan : ");
        int hari = input.nextInt();
        penjualan = new int[hari][2];
        if (hari % 2 == 1) {
            nilaiX = ((hari - 1) / 2) * -1;
            dekremen = 1;
        } else if (hari % 2 == 0) {
            nilaiX = (hari - 1) * -1;
            dekremen = 2;
        }

        hari = 0;

        /**
         * input data
         */
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
        
        System.out.println("\nRumus Least Square dari data tersebut adalah:\nY = a + bX\nY = " + nilaiA + " + " + nilaiB);
        
        System.out.println("peramalan pada hari ke 8");
        
        System.out.println("peramalan pada hari ke 9");
        
        System.out.println("peramalan pada hari ke 10");
        
        System.out.println("peramalan pada hari ke 11");
        
        System.out.println("peramalan pada hari ke 12");
        
        System.out.println("peramalan pada hari ke 13");
        
        System.out.println("peramalan pada hari ke 14");
        
    }

}
