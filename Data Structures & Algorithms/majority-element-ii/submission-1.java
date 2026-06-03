
class Solution {
    public List<Integer> majorityElement(int[] nums) {
         ArrayList<Integer> al = new ArrayList<>();
         int[] freq = new int[50001];
        
         for(int i = 0; i < nums.length; i++){
               freq[nums[i]]++;
         }
         for(int i = 0; i < nums.length; i++){
            if(freq[nums[i]] > nums.length / 3){
                al.add(nums[i]);
                freq[nums[i]] = 0;
            }
         }
         return al;
    }
}
