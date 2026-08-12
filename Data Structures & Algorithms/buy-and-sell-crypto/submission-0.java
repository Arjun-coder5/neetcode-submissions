class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buyingPrice = prices[0];
        int profit = 0;
        for(int i = 1;i<prices.length;i++){
            if(buyingPrice>prices[i]){
                buyingPrice = prices[i];
            }
             profit = prices[i]-buyingPrice;
             maxProfit = Math.max(maxProfit,profit);
        }
        return maxProfit;
    }
}
