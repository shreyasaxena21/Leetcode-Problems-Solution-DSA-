class Solution {
    public int removeDuplicates(int[] nums) {
        //maintain two pointers
        // 1. write pointer
        int writer = 0;
        // 2. reader pointer
        for(int reader = 1; reader<nums.length; reader++){
            if(nums[writer]!=nums[reader]){
                writer++;
                nums[writer]=nums[reader];

            }
        }
        return writer+1;
    }
}