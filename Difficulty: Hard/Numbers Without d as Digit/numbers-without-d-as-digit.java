class Solution {
    public int countWithout(int n, int d) {
        // Convert the number to a string to process digit by digit
        String s = Integer.toString(n);
        int[][][] dp = new int[s.length()][2][2];

        // Initialize the DP array with -1 to represent unvisited states
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }

        // Subtract 1 because Digit DP counts '0' as a valid number, 
        // but the problem asks for numbers from 1 to n.
        return solve(0, 1, 1, s, d, dp) - 1;
    }

    private int solve(int idx, int tight, int leadingZeros, String s, int d, int[][][] dp) {
        // Base Case: If we have formed a complete number
        if (idx == s.length()) {
            return 1;
        }

        // Return cached result if already calculated
        if (dp[idx][tight][leadingZeros] != -1) {
            return dp[idx][tight][leadingZeros];
        }

        // Determine the maximum limit for the current digit position
        int limit = tight == 1 ? s.charAt(idx) - '0' : 9;
        int count = 0;

        for (int digit = 0; digit <= limit; digit++) {
            // Skip the digit if it matches 'd' and is not a harmless leading zero
            if (digit == d && !(leadingZeros == 1 && d == 0)) {
                continue;
            }

            // Calculate new state restrictions
            int newTight = (tight == 1 && digit == limit) ? 1 : 0;
            int newLeadingZeros = (leadingZeros == 1 && digit == 0) ? 1 : 0;

            count += solve(idx + 1, newTight, newLeadingZeros, s, d, dp);
        }

        return dp[idx][tight][leadingZeros] = count;
    }
}