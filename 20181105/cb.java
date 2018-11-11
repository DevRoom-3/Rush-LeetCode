package com.ctrip.hotel.order.processservice.soa;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public static void main(String[] args) {
        char[][] grid = {{},{}};
        System.out.println(new Solution().numIslands(grid));
    }

    public int numIslands(char[][] grid) {
        int res = 0;
        if (grid == null || grid.length == 0) {
            return res;
        }

        int len = grid.length, mlen = grid[0].length;
        boolean[][] flags = new boolean[len][mlen];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < mlen; j++) {
                if (isNotVisitedLand(i, j, grid, flags)) {
                    visitLands(i, j, grid, flags);
                    res++;
                }
            }
        }

        return res;
    }

    private void visitLands(int i, int j, char[][] grid, boolean[][] flags) {
        Queue<Integer> toVisitI = new LinkedList<>();
        Queue<Integer> toVisitJ = new LinkedList<>();
        toVisitI.add(i);
        toVisitJ.add(j);
        flags[i][j] = true;

        while (!toVisitI.isEmpty()) {
            int tmpLeft = toVisitI.poll();
            int tmpRight = toVisitJ.poll();
            if ((tmpLeft - 1) >= 0 && isNotVisitedLand(tmpLeft - 1, tmpRight, grid, flags)) {
                toVisitI.add(tmpLeft - 1);
                toVisitJ.add(tmpRight);
                flags[tmpLeft - 1][tmpRight] = true;
            }
            if ((tmpRight - 1) >= 0 && isNotVisitedLand(tmpLeft, tmpRight - 1, grid, flags)) {
                toVisitI.add(tmpLeft);
                toVisitJ.add(tmpRight - 1);
                flags[tmpLeft][tmpRight - 1] = true;
            }
            if ((tmpLeft + 1) < grid.length && isNotVisitedLand(tmpLeft + 1, tmpRight, grid, flags)) {
                toVisitI.add(tmpLeft + 1);
                toVisitJ.add(tmpRight);
                flags[tmpLeft + 1][tmpRight] = true;
            }
            if ((tmpRight + 1) < grid[tmpLeft].length && isNotVisitedLand(tmpLeft, tmpRight + 1, grid, flags)) {
                toVisitI.add(tmpLeft);
                toVisitJ.add(tmpRight + 1);
                flags[tmpLeft][tmpRight + 1] = true;
            }
        }
    }

    private boolean isNotVisitedLand(int i, int j, char[][] grid, boolean[][] flags) {
        return grid[i][j] == '1' && !flags[i][j];
    }
}
