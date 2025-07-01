import java.util.*;

class Solution {
    public String[] findWords(String[] words) {
        // Define sets for each row
        Set<Character> row1 = new HashSet<>(Arrays.asList(
            'q','w','e','r','t','y','u','i','o','p'
        ));
        Set<Character> row2 = new HashSet<>(Arrays.asList(
            'a','s','d','f','g','h','j','k','l'
        ));
        Set<Character> row3 = new HashSet<>(Arrays.asList(
            'z','x','c','v','b','n','m'
        ));

        List<String> result = new ArrayList<>();

        for (String word : words) {
            String lowerWord = word.toLowerCase();
            char firstChar = lowerWord.charAt(0);
            Set<Character> targetRow;

            // Determine which row the first character belongs to
            if (row1.contains(firstChar)) {
                targetRow = row1;
            } else if (row2.contains(firstChar)) {
                targetRow = row2;
            } else {
                targetRow = row3;
            }

            boolean valid = true;
            // Check if all characters belong to the same row
            for (char ch : lowerWord.toCharArray()) {
                if (!targetRow.contains(ch)) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                result.add(word); // original casing
            }
        }

        return result.toArray(new String[0]);
    }
}
