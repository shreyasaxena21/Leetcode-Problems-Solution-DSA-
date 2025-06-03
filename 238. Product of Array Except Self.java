class Solution {
    //approach 1 - Brute Force
    public int[] prodductExceptSelf1(int[] nums) {
        int [] result = new int[nums.length];
        for(int i = 0; i<nums.length; i++){
            int prod = 1;
            for(int j = 0 ; j<nums.length; j++){
                if(i!=j){
                    prod = prod*nums[j];
                }
            }
            result[i] = prod;

     }
     return result;   
    }

    public int[] productExceptSelf(int[] nums) {
        // Approach 2 -> Pre Computatio
        int [] left = new int[nums.length];
        int right [] = new int[nums.length];
        int result [] = new int[nums.length];
        //fill the left array
        left[0] = 1;
        for(int i = 1; i<left.length; i++){
            left[i]= left[i-1]*nums[i-1];

        }
        //fill tthe right array
        right[right.length-1] = 1;
        for(int i = right.length-2; i>=0; i--){
            right[i] = right[i+1]*nums[i+1];
        } 
        for(int i = 0; i<result.length;i++){
            result[i] = left[i] * right[i];
        }

        return result;

    }
}