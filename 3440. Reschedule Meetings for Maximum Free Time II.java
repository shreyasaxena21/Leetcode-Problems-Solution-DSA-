class Solution {
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int last = 0;
        int n = startTime.length;
        int left = 0;
        int res = 0;

        int[] right = new int[n + 1];
        int[] gaps = new int[n + 1];

        for (int i = 0; i < n; i++) {
            gaps[i] = startTime[i] - last;
            last = endTime[i];
        }
        gaps[n] = eventTime - last;
        for (int i = n - 1; i >= 0; i--)
            right[i] = Math.max(right[i + 1], gaps[i + 1]);

        for (int i = 1; i <= n; i++) {
            int dur = endTime[i - 1] - startTime[i - 1];

            if (left >= dur || right[i] >= dur)
                res = Math.max(res, gaps[i - 1] + dur + gaps[i]);
                left = Math.max(left, gaps[i - 1]);
                res = Math.max(res, gaps[i - 1] + gaps[i]);
        }
        return res;
    }
}