import java.util.*;

class Solution {
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
        int n = events.length;
        
        // Memoization: dp[i][k] => max value starting from i with k events remaining
        Integer[][] dp = new Integer[n][k + 1];
        
        // Precompute start times for binary search
        int[] startTimes = new int[n];
        for (int i = 0; i < n; i++) {
            startTimes[i] = events[i][0];
        }
        
        return dfs(0, k, events, dp, startTimes);
    }
    
    private int dfs(int i, int k, int[][] events, Integer[][] dp, int[] startTimes) {
        if (i == events.length || k == 0) return 0;
        if (dp[i][k] != null) return dp[i][k];
        
        // Option 1: skip this event
        int max = dfs(i + 1, k, events, dp, startTimes);
        
        // Option 2: attend this event
        int nextIndex = findNext(events[i][1], startTimes);
        int take = events[i][2] + dfs(nextIndex, k - 1, events, dp, startTimes);
        
        max = Math.max(max, take);
        dp[i][k] = max;
        return max;
    }

    // Binary search for the next event whose start time > endTime
    private int findNext(int endTime, int[] startTimes) {
        int low = 0, high = startTimes.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (startTimes[mid] <= endTime) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
