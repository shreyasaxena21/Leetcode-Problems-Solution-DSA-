class Solution {
    public int[] transformArray(int[] nums) {
        // int[] final = new int[nums.length-1];

        for(int i = 0; i<nums.length; i++){
            if(nums[i]%2==0){
                // add 0 in final list
                nums[i]=0;
            }

            else{
                nums[i] = 1;
            }
        }   

        Arrays.sort(nums);
        return nums;
    }
}