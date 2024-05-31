class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length - 1;

        while(left <= right){
            int mid = left + (right - left)/2;
            if(matrix[mid][0] <= target && matrix[mid][matrix[mid].length - 1] >= target){
                return searchRow(matrix[mid], target);
            }
            else if(matrix[mid][0] < target){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return false;
    }

    public boolean searchRow(int[] arr, int target){
        int left = 0;
        int right = arr.length - 1;

        while(left <= right){
            int mid = left + (right - left)/2;
            if(arr[mid] == target){
                return true;
            }
            else if(arr[mid] < target){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return false;
    }
}