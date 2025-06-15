class Solution {
    public int missingNumber(int[] nums) {
         int n = nums.length+1;
        
        //Approach 1
        int hash [] = new int[n+2];
        
        for(int val : nums){
            hash[val] = 1;
        }
        
        for(int i = 1; i<n; i++){
            if(hash[i]==0){
                return i;
            }
        }
        return 0;
    }
}