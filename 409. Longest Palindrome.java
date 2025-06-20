class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] str = s.toCharArray();
        int length = 0;

        // Count frequency of each character
        for (char c : str) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        boolean hasOdd = false;

        // Go through character frequencies
        for (int count : map.values()) {
            if (count % 2 == 0) {
                length += count;
            } else {
                length += count - 1;
                hasOdd = true;
            }
        }

        // If any character had an odd frequency, we can place one in the center
        if (hasOdd) {
            length += 1;
        }

        return length;
    }
}
