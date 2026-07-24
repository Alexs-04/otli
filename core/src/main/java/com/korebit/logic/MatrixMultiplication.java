package com.korebit.logic;

import java.util.Scanner;

public class MatrixMultiplication {

    public static void multiplication() {
        try (Scanner read = new Scanner(System.in)) {
            int n = read.nextInt();

            int[][] m1 = new int[n][n];
            int[][] m2 = new int[n][n];
            int[][] mr = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m1.length; j++) {
                    m1[i][j] = (int) (Math.random() * 5);
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m2.length; j++) {
                    m2[i][j] = (int) (Math.random() * 5);
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mr[i][j] = m1[i][j] + m2[i][j];
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(" { " + m1[i][j] + " } ");
                }
                if (i == n / 2) {
                    System.out.print("  +  ");
                } else {
                    System.out.print("     ");
                }
                for (int j = 0; j < n; j++) {
                    System.out.print(" { " + m2[i][j] + " } ");
                }
                if (i == n / 2) {
                    System.out.print("  =  ");
                } else {
                    System.out.print("     ");
                }
                for (int j = 0; j < n; j++) {
                    System.out.print(" { " + mr[i][j] + " } ");
                }
                System.out.println();
            }
        }
    }
}
