class Solution {
    public int[] searchRange(int[] nums, int target) {

        int len = nums.length;
        int[] result = new int[]{-1, -1};
        int low = 0;
        int high = len - 1;

        if(len == 0)
            return result;
        if(target < nums[low] || target > nums[high])
            return result;

        while(low < high) {
            int median = (low + high) / 2;

            if(nums[median] > target)
                high = median - 1;
            else if(nums[median] < target)
                low = median + 1;
            else {
                low = median;
                high = median;
                while(low - 1 >= 0 && nums[low - 1] == target) low--;
                while(high + 1 < len && nums[high + 1] == target) high++;
                break;
            }
        }
        
        if(nums[low] == target) {
            result[0] = low;
            result[1] = high;    
        }
                    
        return result;
    }
}
