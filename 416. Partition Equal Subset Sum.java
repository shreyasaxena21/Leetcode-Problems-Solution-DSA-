//Approach 1 =  brute force

// class Solution {
//     public boolean canPartition(int[] nums) {
//         int sum=0;
//         // sum of all array elements
//         //enhanced fir loop
//         for(int num: nums){
//             sum=sum+num;

//         }

//         //sum not be odd
//         if(sum%2!=0){
//             return false;
//         }
        
//         //it means summ is even, get the target

//         int target = sum/2;
//         return helper(nums, 0, target);

//     }

//     boolean helper(int []nums, int index, int target){

//         //base case
//         if(target==0){
//             return true;
//         }

//         if(target<0 || nums.length==index){
//             return false;
//         }




// //         // we have 2 
// //         //choices pick it => target-nums(index)
// //         boolean pickIt = helper(nums, index+1, target-nums[index]);

// //          //or not pickit target
// //          boolean notPickIt= helper(nums, index+1, target);

// //          return pickIt || notPickIt;
        
// //     }
// // }

// // Approach 2= Memoization
// class Solution {
//     public boolean canPartition(int[] nums) {
//         // sum of all array elements
//         //enhanced fir loop
//         int sum=0;
//         for(int num: nums){
//             sum=sum+num;

//         }

//         //sum not be odd
//         if(sum%2!=0){
//             return false;
//         }
        
//         //it means summ is even, get the target

//         int target = sum/2;
//         // Boolean will by default take null vales and boolean will take false as default value
//         Boolean [][] cache= new Boolean[nums.length][target+1]; //two variables are there
//         return helper(nums, 0, target, cache);

//     }

//     boolean helper(int []nums, int index, int target, Boolean [][] cache){

//         //base case
//         if(target==0){
//             return true;
//         }

//         if(target<0 || nums.length==index){
//             return false;
//         }

//         //checking the value if the value already exists
//         if(cache[index][target] !=null){
//             return cache[index][target] ;
//         } 


//         // we have 2 
//         //choices pick it => target-nums(index)
//         boolean pickIt = helper(nums, index+1, target-nums[index], cache);

//          //or not pickit target
//          boolean notPickIt= helper(nums, index+1, target, cache);

//          //store the result in cache then return
//          cache[index][target] = pickIt || notPickIt;
//          return cache[index][target] ;
        
//     }
// }

//Approach 3 = Tabulation => Bottom up approach
class Solution {
    public boolean canPartition(int[] nums) {
        // sum of all array elements
        //enhanced fir loop
        int sum=0;
        for(int num: nums){
            sum=sum+num;

        }

        //sum not be odd
        if(sum%2!=0){
            return false;
        }
        
        //it means summ is even, get the target

        int target = sum/2;

        boolean dp[] = new boolean[target+1]; // fill the target values
        dp[0] = true;

        for(int num: nums){
            for(int i = target; i>num; i--){
                dp[i] = dp[i-num] || dp[i];
            }
        }
        return dp[target];
    }

}
