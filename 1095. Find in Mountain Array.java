class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();

        // Step 1: Find the peak
        int peak = findPeak(mountainArr, 0, n - 1);

        // Step 2: Binary search on increasing part
        int left = binarySearch(mountainArr, 0, peak, target, true);
        if (left != -1) return left;

        // Step 3: Binary search on decreasing part
        return binarySearch(mountainArr, peak + 1, n - 1, target, false);
    }

    private int findPeak(MountainArray arr, int low, int high) {
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr.get(mid) < arr.get(mid + 1)) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    private int binarySearch(MountainArray arr, int low, int high, int target, boolean asc) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midVal = arr.get(mid);
            if (midVal == target) return mid;

            if (asc) {
                if (midVal < target) low = mid + 1;
                else high = mid - 1;
            } else {
                if (midVal < target) high = mid - 1;
                else low = mid + 1;
            }
        }
        return -1;
    }
}
