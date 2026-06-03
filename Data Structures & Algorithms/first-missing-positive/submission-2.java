// import java.util.Arrays;

public class Solution {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int missing = 1;
        for (int num : nums) {
            // If we find our target, look for the next number
            if (num == missing) {
                missing++;
            }
            // Skip negatives or duplicates; stop if we passed our target
            else if (num > missing) {
                break;
            }
        }
        return missing;
    }
}
