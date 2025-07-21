class Solution {
    // nums [] = 2,2,3,3,3,4
    // max = 4
    // int [] points = new[4+1]
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for(int i : nums){
            if(i>=max){
                max = i;

            }
        }
         int [] points = new int[max+1];
         Integer dp[] = new Integer[max+1];
         for(int num : nums){
            points[num] = points[num] + num;
         }
        return helper(points, max, dp);
    }

    int helper(int [] points, int i, Integer[] dp){
        if(i==0){
            return points[0];
        }

        if(i==1){
            return Math.max(points[0], points[1]);
        }

        if(dp[i]!=null){
            return dp[i];
        }


       dp[i] = Math.max(helper(points, i-1, dp), helper(points, i-2, dp) + points[i]);
       return dp[i];
    }
}