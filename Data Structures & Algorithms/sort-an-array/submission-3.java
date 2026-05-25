class Solution {
    public int[] sortArray(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        quickSort(nums,left,right);
        return nums;
    }
    public static void quickSort(int num[] ,int l,int r ){
        if(l>=r){
            return;
        }
        int mid = l+(r-l)/2;
        quickSort(num,l,mid);
        quickSort(num,mid+1,r);

        merge(num,l,mid,r);
    }
    public static void merge(int[] nums,int l,int mid,int r){
        if(l>=r){
            return ;
        }
        int[] leftSort = new int[mid-l+1];
        int[] rightSort = new int[r-mid];


     for (int i = 0; i < leftSort.length; i++) {
            leftSort[i] = nums[l + i];
        }
        for (int j = 0; j < rightSort.length; j++) {
            rightSort[j] = nums[mid + 1 + j];
        }

        int i = 0;
        int j = 0;
        int k = l;
        while (i < leftSort.length && j < rightSort.length) {
            if (leftSort[i] <= rightSort[j]) {
                nums[k] = leftSort[i];
                i++;
            } else {
                nums[k] = rightSort[j];
                j++;
            }
            k++;
        }
         while (i < leftSort.length) {
            nums[k] = leftSort[i];
            i++;
            k++;
        }
     while(j<rightSort.length){
        nums[k] = rightSort[j];
        j++;
        k++;
     }
    }
}