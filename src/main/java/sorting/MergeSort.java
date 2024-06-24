class Solution {
    public int[] sortArray(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    void sort(int[] nums, int l, int r){
        if(l < r){
            int mid = l + (r - l)/2;
            //sort left half
            sort(nums, l, mid);
            //sort right half
            sort(nums, mid + 1, r);
            //merge halves
            merge(nums, l, mid, r);
        }
    }

    void merge(int[] nums, int l, int mid, int r){
        int leftSize = mid - l + 1;
        int rightSize = r - mid;

        int lArr[] = new int[leftSize];
        int rArr[] = new int[rightSize];

        //copy left side to new array
        for(int i = 0; i < leftSize; i++){
            lArr[i] = nums[l+i];
        }
        //copy right side to new array
        for(int j = 0; j < rightSize; j++){
            rArr[j] = nums[mid + 1 + j];
        }

        int leftIndex = 0;
        int rightIndex = 0;
        int index = l;

        //add smallest value to array
        while(leftIndex < leftSize && rightIndex < rightSize){
            if(lArr[leftIndex] <= rArr[rightIndex]){
                nums[index] = lArr[leftIndex];
                leftIndex++;
            }
            else{
                nums[index] = rArr[rightIndex];
                rightIndex++;
            }
            index++;
        }


        //append remaining values
        while(leftIndex < leftSize){
            nums[index] = lArr[leftIndex];
            leftIndex++;
            index++;
        }

        while(rightIndex < rightSize){
            nums[index] = rArr[rightIndex];
            rightIndex++;
            index++;
        }
    }
}