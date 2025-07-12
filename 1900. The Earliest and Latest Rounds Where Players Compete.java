import java.util.*;

class Solution {
    public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        int a = Math.min(firstPlayer, secondPlayer);
        int b = Math.max(firstPlayer, secondPlayer);

        Map<String, int[]> memo = new HashMap<>();
        return dfs(n, a, b, 1, memo);
    }

    private int[] dfs(int n, int a, int b, int round, Map<String, int[]> memo) {
        String key = n + "," + a + "," + b;
        if (memo.containsKey(key)) return memo.get(key);

        // They face each other
        if (a + b == n + 1) {
            return new int[]{round, round};
        }

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        // Consider all possible outcomes
        for (List<Integer> nextRound : generateNextRounds(n, a, b)) {
            int newA = -1, newB = -1;

            // Find new indices for a and b in the new round
            for (int i = 0; i < nextRound.size(); i++) {
                if (nextRound.get(i) == a) newA = i + 1;
                if (nextRound.get(i) == b) newB = i + 1;
            }

            int[] res = dfs(nextRound.size(), newA, newB, round + 1, memo);
            min = Math.min(min, res[0]);
            max = Math.max(max, res[1]);
        }

        memo.put(key, new int[]{min, max});
        return memo.get(key);
    }

    private List<List<Integer>> generateNextRounds(int n, int a, int b) {
        List<Integer> current = new ArrayList<>();
        for (int i = 1; i <= n; i++) current.add(i);

        List<List<Integer>> result = new ArrayList<>();
        backtrack(current, 0, current.size() - 1, a, b, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(List<Integer> current, int l, int r, int a, int b,
                           List<Integer> path, List<List<Integer>> result) {
        if (l > r) {
            List<Integer> next = new ArrayList<>(path);
            next.sort(Comparator.naturalOrder()); // Sort for next round ordering
            result.add(next);
            return;
        }

        if (l == r) {
            // Middle player moves on directly
            path.add(current.get(l));
            backtrack(current, l + 1, r - 1, a, b, path, result);
            path.remove(path.size() - 1);
        } else {
            int left = current.get(l), right = current.get(r);

            if ((left == a && right == b) || (left == b && right == a)) return; // They are meeting

            // If one is best player, they must win
            if (left == a || left == b) {
                path.add(left);
                backtrack(current, l + 1, r - 1, a, b, path, result);
                path.remove(path.size() - 1);
            } else if (right == a || right == b) {
                path.add(right);
                backtrack(current, l + 1, r - 1, a, b, path, result);
                path.remove(path.size() - 1);
            } else {
                // Try both outcomes
                path.add(left);
                backtrack(current, l + 1, r - 1, a, b, path, result);
                path.remove(path.size() - 1);

                path.add(right);
                backtrack(current, l + 1, r - 1, a, b, path, result);
                path.remove(path.size() - 1);
            }
        }
    }
}
