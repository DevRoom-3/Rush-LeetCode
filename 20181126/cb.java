package com.ctrip.hotel.order.processservice.soa;

public class Solution {
    public static void main(String args[]){
        int[][] matrix = {{5, 1, 9, 11},
                        {2, 4, 8, 10},
                        {13, 3, 6, 7},
                        {15,14,12,16}};
        new Solution().rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }

        for (int i = 0; i < matrix.length / 2; i++) {
            for (int j = i; j < matrix.length - i - 1; j++) {
                roratePoints(matrix, i, j);
            }
        }
    }

    private void roratePoints(int[][] matrix, int i, int j) {
        int tmp1 = matrix[j][matrix.length - i - 1];
        matrix[j][matrix.length - i - 1] = matrix[i][j];
        int tmp2 = matrix[matrix.length - i - 1][matrix.length - j - 1];
        matrix[matrix.length - i - 1][matrix.length - j - 1] = tmp1;
        int tmp3 = matrix[matrix.length - j - 1][i];
        matrix[matrix.length - j - 1][i] = tmp2;
        matrix[i][j] = tmp3;
    }
}