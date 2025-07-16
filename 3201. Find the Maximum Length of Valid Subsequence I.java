class Solution {
    public int maximumLength(int[] nums) {
        int evenCount = 0, oddCount = 0;

        for (int num : nums) {
            if (num % 2 == 0)
                evenCount++;
            else
                oddCount++;
        }

        int maxSameParity = Math.max(evenCount, oddCount);

        // For alternating parity (sum % 2 == 1)
        int maxAltParity = 1;
        int lastParity = nums[0] % 2;
        int length = 1;

        for (int i = 1; i < nums.length; i++) {
            int currParity = nums[i] % 2;
            if ((lastParity + currParity) % 2 == 1) {
                length++;
                lastParity = currParity;
            }
        }

        maxAltParity = Math.max(maxAltParity, length);

        return Math.max(maxSameParity, maxAltParity);
    }
}
