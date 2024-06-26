class TwoSumWithSortedArray {
    //O(n)
    public int[] twoSum(int[] numbers, int target) {
    //two pointer
        int start = 0;
        int end = numbers.length - 1;
        while(start < end){
            int sum = numbers[start] + numbers[end];
            if(sum == target){
                return new int[] {start + 1, end + 1};
            }
            else if(sum < target){
                start++;
            }
            else{
                end--;
            }
        }
        return new int[0];
    }
}
