package com.ctrip.hotel.order.processservice.soa;

class Solution {
    public static void main(String[] args) {
        int[] nums = {-3, 0, 1, -2};
        System.out.println(new Solution().maxProduct(nums));
    }

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int res = nums[0];
        int len = nums.length;
        int lastEndIndex = 0;
        int negNums = 0;

        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                res = Math.max(res, 0);
                res = Math.max(res, getMaxMutiArray(nums, lastEndIndex, i - 1, negNums));
                lastEndIndex = i + 1;
                negNums = 0;
            } else if (nums[i] < 0) {
                negNums++;
            }
        }

        res = Math.max(res, getMaxMutiArray(nums, lastEndIndex, len - 1, negNums));

        return res;
    }

    //求指定范围内的乘积
    private int mutiArray(int[] nums, int fromIndex, int endIndex) {
        if (fromIndex > endIndex) {
            return Integer.MIN_VALUE;
        }

        int res = 1;

        for (int i = fromIndex; i <= endIndex; i++) {
            res *= nums[i];
        }

        return res;
    }

    //负数的数量为偶数时，直接求所有数的乘积；
    //若为奇数时，找到头尾两端的负数，
    //分别计算头部负数左端（包括该负数）乘积的绝对值和尾部负数（包括该负数）的右端乘积的绝对值，取较小值，舍去这些数并求剩余数的乘积；
    private int getMaxMutiArray(int[] nums, int fromIndex, int endIndex, int negNums) {
        if (negNums % 2 == 0) {
            return mutiArray(nums, fromIndex, endIndex);
        } else {
            int leftIndex = 0, rightIndex = 0;
            for (int i = fromIndex; i <= endIndex; i++) {
                if (nums[i] < 0) {
                    leftIndex = i;
                    break;
                }
            }

            for (int i = endIndex; i >= fromIndex; i--) {
                if (nums[i] < 0) {
                    rightIndex = i;
                    break;
                }
            }

            if (leftIndex == rightIndex) {
                return Math.max(mutiArray(nums, fromIndex, rightIndex - 1), mutiArray(nums, leftIndex + 1, endIndex));
            } else {
                return Math.abs(mutiArray(nums, fromIndex, leftIndex)) > Math.abs(mutiArray(nums, rightIndex, endIndex)) ?
                        mutiArray(nums, fromIndex, rightIndex - 1) : mutiArray(nums, leftIndex + 1, endIndex);
            }
        }
    }
}
