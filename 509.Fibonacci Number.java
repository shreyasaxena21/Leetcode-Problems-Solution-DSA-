class Solution {

    //Bottom up Approach (Tabulation)
    public int fib(int n) {
        if(n<=1){
            return n;
        }
        int dp[] = new int[n+1];
        //fill the base case
        dp[0]=0;
        dp[1]=1;
        // Fill the rest of the values
        for(int i = 2; i<=n ; i++){
            dp[i] = dp[i-1]+dp[i-2]; //RR
        }
        return dp[n];
    }

    // //DP - Remember (Memoization - Approach 1)
    // HashMap<Integer, Integer> map = new HashMap<>();
    // public int fib(int n) {
    //     if(n==1 || n==0){
    //         return n;
    //     }
    //     //before calculaing
    //     if (map.containsKey(n)){
    //         return map.get(n); // return computed result
    //     }

    //     int result = fib(n-1)+fib(n-2);
    //     map.put(n, result);
    //     return result;
    // }
}