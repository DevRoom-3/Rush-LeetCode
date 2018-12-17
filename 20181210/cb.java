package com.ctrip.hotel.order.processservice.soa;

public class Solution {
    public static void main(String args[]){
        String s = "pwwkew";
        System.out.println(new Solution().lengthOfLongestSubstring(s));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int left = 0, right = 1;
        String sub = s.substring(left, right);
        int len = sub.length();
        int maxLength = len;
        for (int i = 1; i < s.length(); i++) {
            int index = sub.indexOf(s.charAt(i));
            if (index != -1) {
                left = left + index + 1;
            }

            right ++;
            sub = s.substring(left, right);
            len = sub.length();
            if (len > maxLength) {
                maxLength = len;
            }
        }

        return maxLength;
    }
}