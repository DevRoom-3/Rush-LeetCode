package com.ctrip.hotel.order.processservice.soa;

public class Solution {
    public static void main(String args[]) throws Exception {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        int target = 13;
        System.out.println(new Solution().searchMatrix(matrix, target));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length ==0) {
            return false;
        }
        int n = matrix.length, m = matrix[0].length;
        int left = 0, right = n * m - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int tmpN = mid / m, tmpM = mid % m;
            if (matrix[tmpN][tmpM] == target) {
                return true;
            } else if (matrix[tmpN][tmpM] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;
    }
}
