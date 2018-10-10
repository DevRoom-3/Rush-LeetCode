package com.ctrip.hotel.order.processservice.soa;

class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int target = 2;
        int[] res = new Solution().searchRange(nums, target);
        for (int r : res) {
            System.out.println(r);
        }
    }

    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};

        if (nums == null || nums.length == 0) {
            return res;
        }

        res[0] = getFlexibleIndex(nums, target, false, 0, nums.length - 1);
        res[1] = res[0] == -1 ? -1 : getFlexibleIndex(nums, target, true, res[0], nums.length - 1);

        return res;
    }

    private int getFlexibleIndex(int[] nums, int target, boolean isMaxIndex, int low, int high) {
        int mid = (low + high) / 2;

        if (high < low) {
            return -1;
        }

        if (mid < low) {
            return nums[low] == target ? low : -1;
        }

        if (nums[mid] > target) {
            return getFlexibleIndex(nums, target, isMaxIndex, low, mid - 1);
        } else if (nums[mid] < target) {
            return getFlexibleIndex(nums, target, isMaxIndex, mid + 1, high);
        } else {
            if (isMaxIndex) {
                return (mid + 1) > high ? high : Math.max(getFlexibleIndex(nums, target, true, mid + 1, high), mid);
            } else {
                if ((mid - 1) < low) {
                    return low;
                } else {
                    int tmp = getFlexibleIndex(nums, target, false, low, mid - 1);
                    return tmp == -1 ? mid : Math.min(tmp, mid);
                }
            }
        }
    }
}
