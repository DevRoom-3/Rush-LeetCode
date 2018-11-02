package com.ctrip.hotel.order.processservice.soa;

class Solution {
    public static void main(String[] args) {
        int[] nums = {0,1,2,3,4,5,6,7,8};
        int target = 8;
        System.out.println(new Solution().search(nums, target));
    }

    public int search(int[] nums, int target) {
        return (nums == null || nums.length == 0) ? -1 : searchTarget(nums, 0, nums.length - 1, target);
    }

    private int searchTarget(int[] nums, int low, int high, int target) {
        if (low > high) {
            return -1;
        }

        int mid = (low + high) / 2;
        if (nums[mid] == target) {
            return mid;
        } else {
            if (nums[mid] < nums[high]) {
                if (nums[mid] < target && nums[high] >= target) {
                    return searchTarget(nums, mid + 1, high, target);
                } else {
                    return searchTarget(nums, low, mid - 1, target);
                }
            } else {
                if (nums[mid] > target && nums[low] <= target) {
                    return searchTarget(nums, low, mid - 1, target);
                } else {
                    return searchTarget(nums, mid + 1, high, target);
                }
            }
        }
    }
}
