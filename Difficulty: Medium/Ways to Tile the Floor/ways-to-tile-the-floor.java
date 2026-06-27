class Solution {
    public int countWays(int n, int m) {
        int MOD = 1000000007;
        
        // dp[i] stores the number of ways to tile an i x m floor
        int[] dp = new int[n + 1];
        
        // Base case
        dp[0] = 1;
        
        for (int i = 1; i <= n; i++) {
            // Option 1: Place 1 tile horizontally
            dp[i] = dp[i - 1];
            
            // Option 2: Place m tiles vertically (only possible if height >= m)
            if (i >= m) {
                dp[i] = (dp[i] + dp[i - m]) % MOD;
            }
        }
        
        return dp[n];
    }
}
