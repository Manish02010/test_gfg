class Solution {
    public int minimumCost(int[] cost, int w) {
        int n = cost.length;
        int[] dp = new int[w + 1];
        
        // Initialize dp array with infinity for unreachable weights
        for (int i = 1; i <= w; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0; // 0 kg costs 0
        
        // Iterate through all target weights from 1 to w
        for (int j = 1; j <= w; j++) {
            // Check each packet option
            for (int i = 1; i <= n; i++) {
                // If packet size 'i' fits and is available
                if (i <= j && cost[i - 1] != -1) {
                    // Check if the remaining weight 'j - i' is reachable
                    if (dp[j - i] != Integer.MAX_VALUE) {
                        dp[j] = Math.min(dp[j], dp[j - i] + cost[i - 1]);
                    }
                }
            }
        }
        
        // If dp[w] is still infinity, it's impossible to make exactly w kg
        return dp[w] == Integer.MAX_VALUE ? -1 : dp[w];
    }
}
