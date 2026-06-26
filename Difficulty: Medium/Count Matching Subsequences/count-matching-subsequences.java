class Solution {
    public static int countWays(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int MOD = 1000000007;
        
        // dp[j] stores the number of subsequences of s1 matching s2[0...j-1]
        int[] dp = new int[m + 1];
        
        // Base case: There is 1 way to form an empty s2
        dp[0] = 1;
        
        // Traverse s1
        for (int i = 1; i <= n; i++) {
            // Traverse s2 backwards to reuse the DP array efficiently
            for (int j = m; j >= 1; j--) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[j] = (dp[j] + dp[j - 1]) % MOD;
                }
            }
        }
        
        return dp[m];
    }
}
