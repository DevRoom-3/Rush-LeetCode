package com.ctrip.hotel.order.processservice.soa;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String args[]){
        int[][] matrix = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}};
        System.out.println(new Solution().spiralOrder(matrix));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return res;
        }

        int m = matrix.length, n = matrix[0].length;
        int mCycle = m % 2 == 0 ? m / 2 : m / 2 + 1;
        int nCycle = n % 2 == 0 ? n / 2 : n / 2 + 1;
        int sumCycle = Math.min(mCycle, nCycle);

        for (int i = 0; i < sumCycle; i++) {
            for (int j = i; j < n - i; j++) {
                res.add(matrix[i][j]);
            }

            for (int j = i + 1; j < m - 1 - i; j++) {
                res.add(matrix[j][n - 1 - i]);
            }

            for (int j = n - 1 - i; j >= i && m - 1 - i > i; j--) {
                res.add(matrix[m - 1 - i][j]);
            }

            for (int j = m - 1 - i - 1; j > i && n - 1 - i > i; j--) {
                res.add(matrix[j][i]);
            }
        }

        return res;
    }
}