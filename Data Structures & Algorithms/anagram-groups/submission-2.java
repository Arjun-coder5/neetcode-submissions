class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
          if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        List<List<String>> d2 = new ArrayList<>();
       boolean[] visited = new boolean[strs.length];
        for(int i = 0;i<strs.length;i++){
               if (visited[i]) continue; 
             List<String> d1 = new ArrayList<>();
            for(int j = 0;j<strs.length;j++){
                if(!visited[j] && check(strs[i],strs[j])){
              d1.add(strs[j]);
              visited[j]=true;
                }
            }
            d2.add(d1);
        }
       return d2;
    }
    public static boolean check(String s1,String s2){
        int[] freq = new int[26];
        if(s1.length()!=s2.length()){
            return false;
        }
        for(int i = 0;i<s1.length();i++){
            freq[s1.charAt(i)-'a']++;
            freq[s2.charAt(i)-'a']--;
        }
        for(int i = 0;i<26;i++){
            if(freq[i]!=0){
                return false;
            }
        }
        return true;
    }
}
