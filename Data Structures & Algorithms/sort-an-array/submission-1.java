class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums,0,nums.length-1);
        return nums;
    }
    public static void quickSort(int[] nums,int left,int right){
        if(left>=right){
            return;
        }
        int pivot = nums[right];
        int i = left-1;
        for(int j = left;j<right;j++){
            if(nums[j]<pivot){
                i++;
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
        }
        int temp = nums[i+1];
        nums[i+1] = nums[right];
        nums[right] = temp;
        int idx = i+1;
        quickSort(nums,left,idx-1);
        quickSort(nums,idx+1,right);
    }
}