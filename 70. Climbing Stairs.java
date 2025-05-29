class Solution {
    public int climbStairs(int n) {
         if(n<=1){
            return n;
        }
        int dp[] = new int[n+1];
        //fill the base case
        dp[0]=1;
        dp[1]=1;
        // Fill the rest of the values
        for(int i = 2; i<=n ; i++){
            dp[i] = dp[i-1]+dp[i-2]; //RR
        }
        return dp[n];

    }
}