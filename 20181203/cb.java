package com.ctrip.hotel.order.processservice.soa;

public class Solution {
    public static void main(String args[]){
        String n1 = "123";
        String n2 = "456";
        System.out.println(new Solution().multiply(n1, n2));
    }

    public String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int[] n1 = new int[len1];
        int[] n2 = new int[len2];
        int[] n = new int[len1 + len2];

        for (int i = 0; i < len1; i++) {
            n1[len1 - 1 - i] = Integer.parseInt(num1.substring(i, i + 1));
        }

        for (int i = 0; i < len2; i++) {
            n2[len2 - 1 - i] = Integer.parseInt(num2.substring(i, i + 1));
        }

        for (int i = 0; i < len1; i++) {
            int carry = 0;
            for (int j = 0; j < len2; j++) {
                n[j + i] = n2[j] * n1[i] + n[j + i] + carry;
                carry = n[j + i] / 10;
                n[j + i] = n[j + i] % 10;
            }

            for(int k = i + len2; k < n.length; k++) {
                if (carry <= 0) {
                    break;
                } else {
                    n[k] = n[k] + carry;
                    carry = n[k] / 10;
                    n[k] = n[k] % 10;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int fromIndex = 0;
        for (int i = n.length - 1; i >= 0; i--) {
            if (n[i] > 0) {
                fromIndex = i;
                break;
            }
        }

        for (int i = fromIndex; i >= 0; i--) {
            sb.append(n[i]);
        }

        return sb.toString();
    }
}