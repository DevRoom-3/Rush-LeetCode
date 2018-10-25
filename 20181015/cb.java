package com.ctrip.hotel.order.processservice.soa;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> res = new Solution().groupAnagrams(strs);
        System.out.println(res);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String tmp = new String(chars);
            if (!map.containsKey(tmp)) {
                map.put(tmp, new ArrayList<>());
            }
            map.get(tmp).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
