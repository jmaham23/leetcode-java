class TrappingRainWater {
    //At each point, find the max left height and right height, then sum the difference of the minimum of the aformentioned heights minus the height of the respective point
    public int trap(int[] height) {
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];
        int res = 0;
        for(int i = 0; i < height.length; i++){
            if(i == 0){
                maxLeft[i] = 0;
                maxRight[height.length - i - 1] = 0;
            }
            else{
                maxLeft[i] = Math.max(maxLeft[i-1], height[i-1]);
                maxRight[height.length - i - 1] = Math.max(maxRight[height.length - i], height[height.length - i]);
            }
        }
        for(int i = 0; i < height.length; i++){
            if(height[i] < Math.min(maxLeft[i], maxRight[i])){
                res += Math.min(maxLeft[i], maxRight[i]) - height[i];
            }
        }
        return res;
    }
}