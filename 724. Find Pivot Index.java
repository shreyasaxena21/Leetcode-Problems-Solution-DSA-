class Solution {
    public int pivotIndex1(int[] nums) {
        for(int i = 0; i<nums.length; i++){
            //for letf sum
            int leftSum = 0;
            for(int j =0; j<i ; j++){
                 leftSum = leftSum + nums[j]; 
            } 

            int rightSum = 0;
            for(int j = i+1; j<nums.length; j++){
                rightSum = rightSum + nums[j];
            }

            if(leftSum == rightSum){
                return i;
            }
        }
        return -1;

    }

    //Approach2 => optimized solution
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for(int i : nums){
            sum = sum + i;
        }
        int leftSum = 0;
        for(int i =0; i<nums.length; i++){
            int rightSum = sum - leftSum - nums[i];
            if(leftSum == rightSum ){
                return i;
            }
            leftSum = leftSum + nums[i];
        }
        return -1;
    }
}