class Solution {
    public boolean isPerfectSquare(int num) {
        // num == sqrt * sqrt
        int square = (int)Math.sqrt(num); 
        if(num==square*square){
            return true;
        }
        return false;
    }
}