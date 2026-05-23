class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
     char[] arr1 = s.toCharArray();
     char[] arr2 = t.toCharArray();
     int f[] = new int[26];
     
     for(int i = 0;i<arr1.length;i++){
       f[arr1[i]-'a']++;
        f[arr2[i]-'a']--;
     }
     for(int i = 0;i<26;i++){
      if(f[i]!=0){
        return false;
      }
     }
     return true;

    }
}
