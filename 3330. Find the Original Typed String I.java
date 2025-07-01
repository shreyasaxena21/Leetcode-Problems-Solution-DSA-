class Solution {
    public int possibleStringCount(String word) {
        int n = word.length();
        int count = 1; // original string itself
        int i = 0;

        while (i < n) {
            char currentChar = word.charAt(i);
            int freq = 1; // start with 1 (current char)

            // Count consecutive same characters
            while (i + 1 < n && word.charAt(i + 1) == currentChar) {
                i++;
                freq++;
            }

            // If group length > 1, we can reduce it to length 1,2,...,(freq-1)
            if (freq > 1) {
                count += (freq - 1);
            }

            i++;
        }

        return count;
    }
}
