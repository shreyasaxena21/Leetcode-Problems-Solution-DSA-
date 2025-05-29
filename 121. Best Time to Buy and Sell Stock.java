class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int lowestPrice = prices[0];

        for(int i=0; i<prices.length; i++){
            if(prices[i]>lowestPrice){
                int profit = prices[i]-lowestPrice;
                maxProfit = Math.max(profit, maxProfit);
                
            }
            lowestPrice = Math.min(prices[i], lowestPrice);
        }
        return maxProfit;

    }
}