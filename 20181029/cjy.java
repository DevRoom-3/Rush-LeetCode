class Solution {
     public int search(int[] nums, int target) {
            if (nums.length==1 && nums[0]==target) return 0;
            int left = 0;
            int right = nums.length-1;
            int mid = 0;
            while (left<right){
                mid = (left+right)/2;
                if (nums[left]==target) return left;
                if (nums[right]==target) return right;
                if (nums[mid]==target) return mid;
                if (target>nums[mid]) left++;
                if (target<nums[mid]) right--;
            }
            return -1;
     }
}
