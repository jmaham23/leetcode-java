class BinarySearch {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while(l <= r){
            int half = l + (r - l) / 2;
            if(nums[half] == target){
                return half;
            }
            else if(nums[half] < target){
                l = half + 1;
            }
            else{
                r = half - 1;
            }
        }
        return -1;
    }
}