class ContainsDuplicates {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> mySet = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            int temp = nums[i];
            if(mySet.contains(temp)){
                return true;
            }
            mySet.add(temp);
        }
        return mySet.size() != nums.length;
    }
}