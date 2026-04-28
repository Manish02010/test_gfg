class Solution {
    public int longestSubstr(String s, int k) {
        int n = s.length();
        int[] counts = new int[26]; // To store frequency of each character
        int maxFreq = 0;            // Frequency of the most common character in the current window
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < n; right++) {
            // Update frequency of the current character
            counts[s.charAt(right) - 'A']++;
            // Update maxFreq to be the highest frequency found in the current window
            maxFreq = Math.max(maxFreq, counts[s.charAt(right) - 'A']);

            // Current window size is (right - left + 1)
            // Number of characters to replace = window size - maxFreq
            if ((right - left + 1) - maxFreq > k) {
                // Window is invalid, slide the left pointer
                counts[s.charAt(left) - 'A']--;
                left++;
            }

            // The window size only grows or stays the same, so right - left + 1 is our answer
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
