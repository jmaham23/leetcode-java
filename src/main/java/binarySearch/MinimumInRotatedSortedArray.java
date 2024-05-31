class Solution {
    //The main idea is, the element is said to be minimum in the rotated sorted array if the previous element to it is greater than it or there is no previous element(i.e. no rotation). We can do this using Binary search
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int min = Integer.MAX_VALUE;
        while(l <= r){
            int half = l + (r - l)/2;
            //If the (mid+1)th element is less than mid element then return (mid+1)th element
            if(half < nums.length - 1 && nums[half] > nums[half + 1]){
                return nums[half+1];
            }
            //If the mid element is less than (mid-1)th element then return the mid element
            else if(half > 0 && nums[half - 1] > nums[half]){
                return nums[half];
            }
            //If the last element is greater than mid element then search in left half
            else if(nums[r] > nums[half]){
                r = half - 1;
            }
            //If the last element is less than mid element then search in right half
            else{
                l = half + 1;
            }
            min = min > nums[half] ? nums[half] : min;
        }
        return min;
    }
}