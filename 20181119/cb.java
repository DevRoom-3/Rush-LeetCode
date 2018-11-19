package com.ctrip.hotel.order.processservice.soa;

public class Solution {
    public static void main(String args[]){
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(new Solution().maxArea(height));
    }

    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0, right = height.length - 1;

        while (left < right) {
            int tmpValue;
            if (height[left] < height[right]) {
                tmpValue = height[left] * (right - left);
                left++;
            } else {
                tmpValue = height[right] * (right - left);
                right--;
            }

            if (tmpValue > maxArea) {
                maxArea = tmpValue;
            }
        }

        return maxArea;
    }
}