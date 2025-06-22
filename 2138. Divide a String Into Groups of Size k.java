class Solution {
    public String[] divideString(String s, int k, char fill) {
        List<String> result = new ArrayList<>();
        int i = 0;
        
        while (i < s.length()) {
            int end = Math.min(i + k, s.length());
            StringBuilder group = new StringBuilder(s.substring(i, end));
            
            // If the group is shorter than k, fill with the fill character
            while (group.length() < k) {
                group.append(fill);
            }
            
            result.add(group.toString());
            i += k;
        }
        
        return result.toArray(new String[0]);
    }
}
