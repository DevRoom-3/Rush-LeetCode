package com.ctrip.hotel.order.processservice.soa;

public class Solution {
    public static void main(String args[]) throws Exception {
        int[] nums = {2};
        new Solution().sortColors2(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + ",");
        }
    }

    public void sortColors2(int[] nums) {
        int index1 = -1, index2 = nums.length;

        for (int i = 0; i < index2;) {
            if (nums[i] == 1) {
                i++;
            } else if (nums[i] == 0) {
                index1++;
                swap(nums, i, index1);
                i++;
            } else if (nums[i] == 2) {
                index2--;
                swap(nums, i, index2);
            }
        }
    }

    public void sortColors(int[] nums) {
        int index1 = -1, index2 = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (index1 != -1 && index2 == -1) {
                    nums[index1] = 0;
                    index1++;
                    nums[i] = 1;
                } else if (index1 == -1 && index2 != -1) {
                    nums[index2] = 0;
                    index2++;
                    nums[i] = 2;
                } else if (index1 != -1 && index2 != -1) {
                    nums[index1] = 0;
                    index1++;
                    nums[index2] = 1;
                    index2++;
                    nums[i] = 2;
                }
            } else if (nums[i] == 1) {
                if (index1 == -1 && index2 == -1) {
                    index1 = i;
                } else if (index1 != -1 && index2 != -1) {
                    nums[index2] = 1;
                    index2++;
                    nums[i] = 2;
                } else if (index1 == -1 && index2 != -1) {
                    index1 = index2;
                    nums[index2] = 1;
                    index2++;
                    nums[i] = 2;
                }
            } else if (nums[i] == 2) {
                if (index2 == -1) {
                    index2 = i;
                }
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
