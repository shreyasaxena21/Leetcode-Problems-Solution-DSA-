class Solution {
    public int maxSubArray1(int[] nums) {
        //approach -> Brute FOrce
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<nums.length; i++){
            int currentSum = 0; // here i store the subarray sum
            for(int j = i; j<nums.length; j++){
                currentSum = currentSum + nums[j];
                max = Math.max(max, currentSum);
            }
        }
        return max;
    }

    //approach 2 -> Kadanes Algo
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int max = sum;
        for(int i = 1; i<nums.length; i++){
            sum = sum + nums[i]; //might be we have negative numbers
            sum = Math.max(sum, nums[i]); 
            max = Math.max(max, sum);
        }

        return max;

    }
}