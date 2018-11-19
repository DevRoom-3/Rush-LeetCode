package com.ctrip.hotel.order.processservice.soa;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String args[]){
        int n = 3;
        List<Integer> res = new Solution().grayCode(n);
        for (Integer i : res) {
            System.out.print(i + ",");
        }
    }

    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);

        for (int i = 1; i <= n; i++) {
            int len = res.size(), add = (int) Math.pow(2, i - 1);
            for (int j = len - 1; j >= 0; j--) {
                res.add(add + res.get(j));
            }
        }

        return res;
    }
}