class Solution {

    public int reverse(int x, int result){
        if(x==0){
            return result;
        }

        return reverse(x/10, result*10 + x%10);
    }

    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }

        int reversed = reverse(x, 0);
        if(reversed==x){
            return true;
        }

        return false;

        
    }
}