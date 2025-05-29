
// //Approach1 => brute force
// class Solution {
//     //nums = [10,9,2,5,3,7,101,18]
//     public int lengthOfLIS(int[] nums) {
//         return helper(nums,0,-1);

//     }
//     //index=> current index
//     //prevIndex => previous index
//     int helper(int [] nums, int index, int prevIndex){
//         //base case
//         if(index==nums.length){
//             return 0;
//         }
//         //two choices
//         //1st=> pickIt
//         int pickIt = 0;
//         if(prevIndex==-1 || nums[index]>nums[prevIndex]){
//             //count if the above condition is met
//             pickIt =  1+helper(nums, index+1, index);
//         }

//         //2nd notPickIt
//         int notPickIt= helper(nums, index+1, prevIndex);

//         return Math.max(pickIt, notPickIt);

//     }
// }


//Approach 2 => Top down approach (recursion+cache = memoization)
// class Solution {
//     //nums = [10,9,2,5,3,7,101,18]
//     public int lengthOfLIS(int[] nums) {
//         //int [][]  cache= new int[index][prevIndex] 
//         int [][]  cache= new int[nums.length][nums.length] ;
//         // cache all values are set to 0
//         return helper(nums,0,-1, cache);

//     }
//     //index=> current index
//     //prevIndex => previous index
//     int helper(int [] nums, int index, int prevIndex, int[][]cache){
//         //base case
//         if(index==nums.length){
//             return 0;
//         }
//         //check if it is already in the cache or nit
//         if(cache[index][prevIndex+1]!=0){
//             return cache[index][prevIndex+1];
//         }
//         //below is all the calculations
//         //two choices
//         //1st=> pickIt
//         int pickIt = 0;
//         if(prevIndex==-1 || nums[index]>nums[prevIndex]){
//             //count if the above condition is met
//             pickIt =  1+helper(nums, index+1, index,cache);
//         }

//         //2nd notPickIt
//         int notPickIt= helper(nums, index+1, prevIndex,cache);

//         cache[index][prevIndex+1] =  Math.max(pickIt, notPickIt);
//         return cache[index][prevIndex+1];

//     }
// }

//Approaxh 3 => Tabulation, Bottom Up
class Solution {
    //nums = [10,9,2,5,3,7,101,18]
    public int lengthOfLIS(int[] nums) {
        //Iterative
        int dp[] = new int[nums.length];
        //loop
        // int count=0;
        // for(int num:nums){
        //     for(int j = 0; j<=nums.length; j++){
        //         if(nums[j]<nums[j+1]){
        //             count++
        //             dp[j] = count + dp[j];
        //         }
        //     }

        int finalMax = 0;
        for(int i=0; i<dp.length; i++){//current
            int max=0;
            for(int j=0; j<i; j++){ //previous index
                if(nums[i]>nums[j]){
                   if(max<dp[j]){
                        max=dp[j];
                   }

                }
            }//prev loop end here
            //update max
            dp[i]=max+1;
            if(dp[i]>=finalMax){
                finalMax = dp[i];
            }
            
        }
        return finalMax;
        }
      

    }
