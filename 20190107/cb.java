package com.ctrip.hotel.order.processservice.soa;

public class Solution {
    public static void main(String args[]){
        int n = 1;
        int[][] matrix = new Solution().generateMatrix(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        if (n < 0) {
            return null;
        }

        int count = 1;
        int cycle = n % 2 == 0 ? n / 2 : n / 2 + 1;

        for (int i = 0; i < cycle; i++) {
            for (int j = i; j < n - i; j++) {
                matrix[i][j] = count++;
            }

            for (int j = i + 1; j < n - 1 - i; j++) {
                matrix[j][n - 1 - i] = count++;
            }

            for (int j = n - 1 - i; j >= i && n - 1 - i > i; j--) {
                matrix[n - 1 - i][j] = count++;
            }

            for (int j = n - 1 - i - 1; j > i && n - 1 - i > i; j--) {
                matrix[j][i] = count++;
            }
        }

        return matrix;
    }
}