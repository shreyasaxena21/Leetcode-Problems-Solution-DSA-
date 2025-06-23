public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        for(int i = 0; i<32; i++){
            int lastBit = n & 1 ; //and with 1 to get last bit
            result = result << 1 | lastBit;
            n = n>>>1; //unsigned right shift
        }

        return result;
        
    }
}