class Solution {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        for(int m = 1;m<=nums.length+1;m++){
            boolean f = false;
            for(int num : nums){
               if(num==m){
                f=true;
                break;
               } 
            }
            if(!f)return m;
        }
        return 1;
    }
}