class Solution {
    public int majorityElement(int[] nums) {
         int m = 0;
        int me = 0;
       for(int i =  0;i<nums.length;i++){
        int count = 0;
        for(int j = 0;j<nums.length;j++){
            if(nums[i]==nums[j]){
                count++;
            }
        }
            if(count>m){
                m = count;
                me = nums[i];
        }
       }
       return me;
    }
}