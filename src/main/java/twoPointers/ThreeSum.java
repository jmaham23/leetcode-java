//Sort array and then use two pointers.
class ThreeSum {
    //O(nlogn) for sort & O(n^2) for nested loop so O(n^2) time
    public List<List<Integer>> threeSum(int[] nums) {
        //sort input array to use two pointer
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int start = i + 1;
            int end = nums.length - 1;
            while(start < end){
                int sum = nums[i] + nums[start] + nums[end];
                if(sum < 0){
                    start++;
                }
                else if(sum > 0){
                    end--;
                }
                else{
                    res.add(List.of(nums[i], nums[start], nums[end]));
                    start++;
                    while(nums[start] == nums[start - 1] && start < end){
                        start++;
                    }
                }
            }
        }
        return res;
    }
}