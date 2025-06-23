class Solution {
    public int hammingWeight1(int n) {
        //approach 1
        return Integer.bitCount(n);   
    }

     public int hammingWeight(int n) {
        //approach 2
        int count = 0;
        while(n>0){
            n = n & (n-1);
            count++;
        }

        return count;

     }
}