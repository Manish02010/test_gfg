class Solution {
    public int longestSubseq(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        // Find the maximum value in the array to size our DP array properly
        int maxVal = 0;
        for (int num : arr) {
            if (num > maxVal) {
                maxVal = num;
            }
        }

        // dp[x] stores the length of the longest valid subsequence ending with value x
        // Size is maxVal + 2 to safely handle val + 1 indexing
        int[] dp = new int[maxVal + 2];
        int maxLen = 0;

        for (int val : arr) {
            // The current element can extend a subsequence ending in either val - 1 or val + 1
            int currentLen = Math.max(dp[val - 1], dp[val + 1]) + 1;
            dp[val] = currentLen;

            // Keep track of the overall maximum length found
            if (currentLen > maxLen) {
                maxLen = currentLen;
            }
        }

        return maxLen;
    }
}
