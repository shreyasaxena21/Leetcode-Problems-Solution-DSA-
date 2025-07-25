import java.util.HashSet;
import java.util.Set;

class Solution {
    public int maxSum(int[] nums) {

        // Edge case: only one element
        if (nums.length == 1) {
            return nums[0];
        }

        // Check if all elements are negative
        boolean allNegative = true;
        for (int num : nums) {
            if (num >= 0) {
                allNegative = false;
                break;
            }
        }

        // If all are negative, return the maximum (least negative) number
        if (allNegative) {
            int maxNeg = nums[0];
            for (int num : nums) {
                maxNeg = Math.max(maxNeg, num);
            }
            return maxNeg;
        }

        Set<Integer> set = new HashSet<>();
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                set.add(nums[i]);
            }
        }

        for (int num : set) {
            sum = sum + num;
        }

        return sum;
    }
}
