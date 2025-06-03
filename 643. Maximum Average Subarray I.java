
class Solution {
    //approach 1 - brute force
    public double findMaxAverage1(int[] nums, int k) {
        double max = Double.NEGATIVE_INFINITY;
        for(int i = 0; i<=nums.length-k; i++){
            int sum = 0;
            for(int j = i; j<i+k; j++){
                sum = sum + nums[j];
            }
            max = Math.max(max, (double)sum/k);
        }
        return max;
    }

    //Approach 2 -> Sliding window
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0.0;
        for(int i = 0; i<k; i++){
            sum = sum+nums[i];
        }
        double max = (double)sum/k;
        for(int i = k ; i<nums.length; i++){
            sum = sum - nums[i-k] + nums[i];
            max = Math.max(max, (double)sum/k);
        }
        return max;
    }
}