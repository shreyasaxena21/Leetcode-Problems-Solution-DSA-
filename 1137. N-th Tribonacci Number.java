// class Solution {
//     // Memoization force TC -
//     public int helper(int n, Integer[] cache){
//             if(n==0){
//             return 0;
//         }

//         if(n==1 || n==2){
//             return 1;
//         }

//         if(cache[n]!=null){
//             return cache[n];
//         }

//         cache[n] =  helper(n-1, cache) + helper(n-2, cache) + helper(n-3, cache);

//         return cache[n];
//     }
//     public int tribonacci(int n) {
//         Integer [] cache = new Integer[n+1];
//         return helper(n, cache);
//     }


// }

class Solution{
    // Tabulation TC - O(n) SC - O(n)
    public int tribonacci1(int n) {
        if(n==0){
            return 0;
        }

        if(n==1||n==2){
            return 1;
        }

        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for(int i = 3; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        return dp[n];
    }

    // Tabulation TC - O(n) SC - O(1)
    public int tribonacci(int n) {
        if(n==0){
            return 0;
        }

        if(n==1||n==2){
            return 1;
        }

        int prev1 = 0;
        int prev2 = 1;
        int prev3 = 1;
        for(int i = 3; i<=n; i++){
           int current = prev1 + prev2 + prev3;
           prev1 = prev2;
           prev2 = prev3;


        }

        return prev1;
    }

}