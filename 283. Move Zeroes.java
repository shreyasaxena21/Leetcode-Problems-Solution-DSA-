class Solution {
    public void moveZeroes(int[] nums) {
     //writer pointer
     int writer=0;
     for(int i=0;i<nums.length;i++){
        if(nums[i]!=0){
            nums[writer] = nums[i];
            writer++;
        }
    }

    for(int j = writer; j<nums.length; j++){
        nums[j]=0;
    }
  }
}