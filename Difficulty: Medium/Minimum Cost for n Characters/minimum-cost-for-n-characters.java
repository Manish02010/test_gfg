class Solution {
    public int minCost(int n, int i, int d, int c) {
        if (n <= 0) return 0;

        // dp[x] stores the minimum cost to get exactly x characters
        int[] dp = new int[n + 1];
        dp[0] = 0;
        if (n >= 1) {
            dp[1] = i; // Cost to insert the first character
        }

        for (int x = 2; x <= n; x++) {
            if (x % 2 == 0) {
                // Minimum of inserting from x-1 or doubling from x/2
                dp[x] = Math.min(dp[x - 1] + i, dp[x / 2] + c);
            } else {
                // Minimum of inserting from x-1 or doubling to x+1 and deleting 1
                dp[x] = (int) Math.min((long) dp[x - 1] + i, (long) dp[(x + 1) / 2] + c + d);
            }
        }

        return dp[n];
    }
}
