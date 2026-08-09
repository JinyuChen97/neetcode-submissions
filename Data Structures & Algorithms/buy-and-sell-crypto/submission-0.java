class Solution {
    public int maxProfit(int[] prices) {
        int L = 0;
        int maxProfit = 0;
        int R = 0;
        while(R<prices.length){
            if(prices[R]>prices[L]){
                maxProfit = Math.max(maxProfit,prices[R]-prices[L]);
            }else{
                L = R;
            }
            R++;
        }
        return maxProfit;
    }
}
