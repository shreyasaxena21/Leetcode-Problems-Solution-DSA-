class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] str = s.split(" ");
        
        if(str.length != pattern.length()) {
            return false;
        }

        Map<Character, String> map1 = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();

        for(int i = 0; i < pattern.length(); i++) {
            char singleChar = pattern.charAt(i);
            String word = str[i];

            if(map1.containsKey(singleChar)) {
                if(!map1.get(singleChar).equals(word)) {
                    return false;
                }
            } else {
                map1.put(singleChar, word);
            }

            if(map2.containsKey(word)) {
                if(!map2.get(word).equals(singleChar)) {
                    return false;
                }
            } else {
                map2.put(word, singleChar);
            }
        }

        return true;
    }
}
