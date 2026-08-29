class Solution {
    public int countSubsequences(String s, int n) {
        int MOD = 1000000007;
        int[] dp = new int[n];

        for (int i = 0; i < s.length(); i++) {
            int d = s.charAt(i) - '0';
            int[] nextDp = new int[n];

            // Copy current states to the next state (not choosing the current digit)
            for (int j = 0; j < n; j++) {
                nextDp[j] = dp[j];
            }

            // Transition from previous states (choosing the current digit)
            for (int j = 0; j < n; j++) {
                if (dp[j] > 0) {
                    int nextRem = (j * 10 + d) % n;
                    nextDp[nextRem] = (nextDp[nextRem] + dp[j]) % MOD;
                }
            }

            // Form a new single-digit subsequence with the current digit
            int singleRem = d % n;
            nextDp[singleRem] = (nextDp[singleRem] + 1) % MOD;

            dp = nextDp;
        }

        return dp[0];
    }
}
