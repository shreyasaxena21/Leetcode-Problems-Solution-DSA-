class Solution {
    public int maxProduct1(int[] nums) {
        //brute force
        int max = nums[0];
        for(int i = 0; i<nums.length; i++){
            int product = 1;
            for(int j=i;j<nums.length;j++){
                product = product * nums[j];
                max = Math.max(product, max);
            }
        } 
        return max; 
    }

    //approch 2 -> Kadanes algo
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int currentMax = nums[0];
        int currentMin = nums[0];
        for(int i = 1; i<nums.length; i++){
            int currentElement = nums[i];
            int tempMax = currentMax;
            // current Maximum number
            currentMax = Math.max(currentElement, Math.max(currentMax * currentElement, currentMin*currentElement));
            // current minimum
            currentMin = Math.min(currentElement, Math.min(tempMax * currentElement, currentMin * currentElement));
            max = Math.max(max, currentMax); 

        }
        return max;
    }
}