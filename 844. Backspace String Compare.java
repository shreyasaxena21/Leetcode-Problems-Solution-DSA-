class Solution {
    public boolean backspaceCompare(String s, String t) {
        // 2 pointers
        int i = s.length()-1;
        int j = t.length()-1;
        int skipS = 0;
        int skipT = 0;

        while(i>=0 || j>=0){
            while(i>=0){
                if(s.charAt(i)=='#'){
                    skipS++;
                    i--;
                }
                else if(skipS>0){
                    skipS--;
                    i--;
                }
                else{
                    break;
                }
            }

            while(j>=0){
                if(t.charAt(j)=='#'){
                    skipT++;
                    j--;
                }
                else if(skipT>0){
                    skipT--;
                    j--;
                }
                else{
                    break;
                }
            }

            // Compare characters
            if (i >= 0 && j >= 0) {
                if (s.charAt(i) != t.charAt(j)) return false;
            } else {
                // If one is valid and the other is not
                if (i >= 0 || j >= 0) return false;
            }

            i--;
            j--;

        }
        return true;

    }
}