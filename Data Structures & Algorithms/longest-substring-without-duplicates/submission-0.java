class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

      
        int[] lastSeen = new int[256];
        for (int i = 0; i < 256; i++) {
            lastSeen[i] = -1;
        }

        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

          
            if (lastSeen[ch] >= left) {
                left = lastSeen[ch] + 1;
            }

          
            lastSeen[ch] = right;

          
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
