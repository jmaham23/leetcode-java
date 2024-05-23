/*iterate through using 2 pointers, track maxArea,
decrement end if height[end] < height[start],
increment start if height[start] < height[end],
O(n) time complexity
*/
class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int maxArea = Integer.MIN_VALUE;
        while(start < end){
            int area = (end - start) * (Math.min(height[start], height[end]));
            maxArea = maxArea < area ? area : maxArea;
            if(height[start] < height[end]){
                start++;
            }
            else{
                end--;
            }
        }
        return maxArea;
    }
}