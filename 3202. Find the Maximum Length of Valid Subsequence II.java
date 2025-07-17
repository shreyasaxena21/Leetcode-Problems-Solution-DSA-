import java.util.*;

class Solution {
    public int maximumLength(int[] nums, int k) {
        int n = nums.length;
        int maxLen = 1;

        // dp[i]: map from mod value to max subsequence length ending at index i with that mod
        Map<Integer, Integer>[] dp = new HashMap[n];

        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();

            for (int j = 0; j < i; j++) {
                int mod = (nums[i] + nums[j]) % k;
                int prevLen = dp[j].getOrDefault(mod, 1);
                int currLen = dp[i].getOrDefault(mod, 0);

                dp[i].put(mod, Math.max(currLen, prevLen + 1));
                maxLen = Math.max(maxLen, dp[i].get(mod));
            }
        }

        return maxLen;
    }
}
