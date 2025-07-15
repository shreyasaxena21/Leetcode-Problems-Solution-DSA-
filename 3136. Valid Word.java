class Solution {

    static boolean isVowel(char c){
        return "aeiouAEIOU".indexOf(c) != -1;
    }

    static boolean isConsonant(char c){
        return Character.isLetter(c) && !isVowel(c);
    }

    public boolean isValid(String word) {
        if (word.length() < 3) return false;

        boolean hasVowel = false;
        boolean hasConsonant = false;

        for (char c : word.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) return false;

            if (isVowel(c)) hasVowel = true;
            if (isConsonant(c)) hasConsonant = true;
        }

        return hasVowel && hasConsonant;
    }
}
