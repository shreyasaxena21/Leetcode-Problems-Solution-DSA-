class Solution {
    public int getSum(int a, int b) {
        //step 1 XOR
        while(b!=0){
               int carry = (a & b) << 1 ; //first do and then do 1 bit left shift
        //step 2 and for carry

        a = a^b;

        b = carry;
        }

        return a;
     
    }
}