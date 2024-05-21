class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> addends = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            if(addends.containsKey(nums[i])){
                return new int[]{addends.get(nums[i]), i};
            }
            else{
                addends.put(target - nums[i], i);
            }
        }
        return new int[1];
    }
}