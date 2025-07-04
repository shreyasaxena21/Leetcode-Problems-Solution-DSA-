class Solution {
    public char kthCharacter(long k, int[] operations) {
        int n = operations.length;
        long[] lengths = new long[n + 1];
        lengths[0] = 1; // Initially: word = "a"

        // Compute lengths after each operation
        for (int i = 0; i < n; i++) {
            if (operations[i] == 0 || operations[i] == 1) {
                lengths[i + 1] = lengths[i] * 2;
                if (lengths[i + 1] >= k) {
                    lengths[i + 1] = k; // Cap to avoid overflow
                }
            }
        }

        // Backtrack to find original character
        int shift = 0;
        for (int i = n - 1; i >= 0; i--) {
            long half = lengths[i];
            if (k > half) {
                k -= half;
                if (operations[i] == 1) {
                    shift++; // Came from 'next', apply one shift
                }
            } else {
                // Came from first half, no change
                // If op[i]==1 but came from first half, no shift
            }
        }

        // Original string is "a", shift it accordingly
        char res = (char) ('a' + (shift % 26));
        return res;
    }
}
