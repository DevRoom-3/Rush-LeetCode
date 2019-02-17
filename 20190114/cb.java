package com.ctrip.hotel.order.processservice.soa;

public class Solution {
    public static void main(String args[]){
        char[] letters = {'c', 'f', 'f', 'j'};
        char target = 'a';
        System.out.println(new Solution().nextGreatestLetter(letters, target));
    }

    public char nextGreatestLetter(char[] letters, char target) {
        int low = 0, high = letters.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (letters[mid] > target) {
                high = mid - 1;
            } else if (letters[mid] < target) {
                low = mid + 1;
            } else {
                low = mid;
                break;
            }
        }

        for (int i = low; i < letters.length; i++) {
            if (letters[i] > target) {
                return letters[i];
            }
        }

        return letters[0];
    }
}