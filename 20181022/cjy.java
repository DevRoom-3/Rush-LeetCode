class Solution {
    public int maxProduct(int[] arr) {
        if(arr.length == 0) {
            return arr[0];
        }
        int max = arr[0];
        int min = arr[0];
        int res = arr[0];
        for(int i=1; i<arr.length; i++) {
            if(arr[i] >= 0) {
                max = Math.max(max * arr[i], arr[i]);
                min = Math.min(min * arr[i], arr[i]);
            } else {
                int temp = max;
                max = Math.max(min * arr[i], arr[i]);
                min = Math.min(temp * arr[i], arr[i]);
            }
            res = Math.max(max, res);
        }
        return res;
    }
}
