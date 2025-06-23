class Solution {
    public int findComplement(int num) {
        int numberOfBits = Integer.toBinaryString(num).length();
        int mask = (1 << numberOfBits) -1;
        return num ^ mask;
    }
}