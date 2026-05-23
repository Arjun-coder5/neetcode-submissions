class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
     char[] arr1 = s.toCharArray();
     char[] arr2 = t.toCharArray();
     int freq1[] = new int[26];
     int freq2[] = new int[26];
     for(int i = 0;i<arr1.length;i++){
       freq1[arr1[i]-'a']++;
        freq2[arr2[i]-'a']++;
     }
     for(int i = 0;i<26;i++){
        if(freq1[i]!=freq2[i]){
            return false;
        }
     }
     return true;

    }
}
