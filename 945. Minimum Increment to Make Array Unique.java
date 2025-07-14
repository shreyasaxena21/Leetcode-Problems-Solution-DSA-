class Solution {
    public int minIncrementForUnique(int[] nums) {
        //sort the array
        Arrays.sort(nums);
        int minInc = 0;

        for(int i = 1; i<nums.length; i++){
            //compare prev with current
            // prev greater or equal 
            if(nums[i] <= nums[i-1]){
                int inc = nums[i-1] + 1 - nums[i];
                minInc = minInc + inc;
                nums[i] = nums[i-1] + 1;
            }
        }

        return minInc;
    }
}