class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        //find the max value in array
        //since we know h >= len(piles), the solution is found from 1 to maxValue
        int maxValue = Integer.MIN_VALUE;
        for(int i = 0; i < piles.length; i++){
            maxValue = maxValue < piles[i] ? piles[i] : maxValue;
        }


        //binary search from 1 to maxValue
        int minValue = 1;
        int total = 0;
        int result = Integer.MAX_VALUE;
        while(minValue <= maxValue){
            int half = minValue + (maxValue - minValue)/2;
            total = 0;
            for(int i = 0; i < piles.length; i++){
                total += piles[i]/half + (piles[i]%half > 0 ? 1 : 0);
            }
            //left half if total quotients is less than hours or if negative(only negative with integer overflow)
            if(total <= h && total > 0){
                result = result < half ? result : half;
                maxValue = half - 1;
            }
            else{
                minValue = half + 1;
            }
        }
        return result;
    }
}