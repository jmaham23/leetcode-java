class Solution {
    int [] arr;
    public int[] sortArray(int[] nums) {
        this.arr = nums;
        quickSort(0, this.arr.length - 1);
        return this.arr;
    }

    void quickSort(int l, int r){
        if (l >= r) return;
        int pivot = partition(l, r);
        quickSort(l, pivot - 1);
        quickSort(pivot + 1, r);
    }

    int partition(int l, int r){
        //choose a pivot using median of 3, highest value will be at end of array
        int mid = l + (r-l)/2;
        if(arr[mid] < arr[l]){
            swapArrElements(mid, l);
        }
        if(arr[r] < arr[l]){
            swapArrElements(r, l);
        }
        if(arr[mid] < arr[r]){
            swapArrElements(mid, r);
        }
        int pivot = arr[r];
        int leftIndex = 0;
        int rightIndex = r - 1;
        //find first item from left larger than pivot
        //find first item from right smaller than pviot
        while(leftIndex <= rightIndex){
            if(arr[leftIndex] <= pivot){
                leftIndex++;
            }
            else if(arr[rightIndex] >= pivot){
                rightIndex--;
            }
            else{
                swapArrElements(leftIndex, rightIndex);
                leftIndex++;
                rightIndex--;
            }
        }
        //put pivot back in its correct position, which is the leftIndex
        swapArrElements(leftIndex, r);
        return leftIndex;
    }

    private void swapArrElements(int i, int j){
        int temp = this.arr[i];
        this.arr[i] = this.arr[j];
        this.arr[j] = temp;
    }
}