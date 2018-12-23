package com.ctrip.hotel.order.processservice.soa;

import java.util.*;

public class Solution {
    public static void main(String args[]){
        String str = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        System.out.println(new Solution().findRepeatedDnaSequences(str));
    }

    public List<String> findRepeatedDnaSequences(String s) {
        int len = 10;
        Set<String> set = new HashSet<>();
        Set<String> repeated = new HashSet<>();

        for (int i = 0; i <= s.length() - len; i++) {
            String tmpString = s.substring(i, i + len);
            if (set.contains(tmpString)) {
                repeated.add(tmpString);
            } else {
                set.add(tmpString);
            }
        }

        return new ArrayList<>(repeated);
    }
}