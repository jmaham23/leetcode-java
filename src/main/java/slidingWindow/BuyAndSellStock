class BuyAndSellStock {
    //O(n) time, O(1) space
    public int maxProfit(int[] prices) {
        int left = 0;
        int right = 1;
        int max = 0;
        while(right < prices.length){
            //if profitable, compare to sum
            if(prices[left] < prices[right]){
                max = prices[right] - prices[left] > max ? prices[right] - prices[left] : max;
            }
            //else the lowest value found is equal to right
            else{
                left = right;
            }
            right++;
        }
        return max;
    }
}