class Solution {
    public int numDecodings(String s) {
        //Approach 1 - Recursive Brute force
        //Approach 2 - Top down approach ( Recursive + Caching)
        int [] cache = new int[s.length()];
        Arrays.fill(cache, -1);
        return helper(s, 0, cache);

    }

    int helper(String s , int index, int [] cache){
        //base case
        if(index==s.length()){
            return 1;
        }
        if(s.charAt(index) == '0'){
            return 0;
        }
        if(cache[index]!=-1){
            return cache[index];
        }
        int count = 0;
        // we have two choices 
        // 1. Pick 1 digit
        count = count + helper(s, index+1, cache);
        // 2. Pick 2 digit
        if(index+1 < s.length()){
            int twoDigit =  Integer.parseInt(s.substring(index, index+2));
            if(twoDigit>=10 && twoDigit<=26){
                count = count + helper(s, index+2,cache);
            }
        }

        cache[index] = count;
        return count;
    }
}