class Solution {
    public int[] sortArray(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        // Start the recursive merge sort process
        mergeSort(nums, left, right);
        return nums;
    }

    public static void mergeSort(int[] nums, int l, int r) {
        // 1. FIX: Added Base Case to prevent StackOverflowError
        if (l >= r) {
            return;
        }

        int mid = l + (r - l) / 2;

        // 2. FIX: Recursively call mergeSort instead of quicksort's sorter
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);

        // 3. FIX: Merge the two sorted halves back together
        merge(nums, l, mid, r);
    }

    private static void merge(int[] nums, int l, int mid, int r) {
        // 4. FIX: Create temporary arrays sized exactly to the subarrays
        int[] leftSort = new int[mid - l + 1];
        int[] rightSort = new int[r - mid];

        // Copy data over to the temporary arrays
        for (int i = 0; i < leftSort.length; i++) {
            leftSort[i] = nums[l + i];
        }
        for (int j = 0; j < rightSort.length; j++) {
            rightSort[j] = nums[mid + 1 + j];
        }

        // 5. FIX: Use 3 independent pointers instead of a single for-loop
        int i = 0; // Tracks position in leftSort
        int j = 0; // Tracks position in rightSort
        int k = l; // Tracks position in original nums array

        // Compare elements from both arrays and put them back in sorted order
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

        // Copy any remaining elements from leftSort if rightSort emptied first
        while (i < leftSort.length) {
            nums[k] = leftSort[i];
            i++;
            k++;
        }

        // Copy any remaining elements from rightSort if leftSort emptied first
        while (j < rightSort.length) {
            nums[k] = rightSort[j];
            j++;
            k++;
        }
    }
}
