class Solution {
    public int zigzagSequence(int[][] mat) {
        int n = mat.length;
        if (n == 0) return 0;
        if (n == 1) {
            int maxVal = mat[0][0];
            for (int j = 1; j < mat[0].length; j++) {
                maxVal = Math.max(maxVal, mat[0][j]);
            }
            return maxVal;
        }

        // dp[j] will store the maximum zigzag sum ending at column j of the current row
        int[] dp = new int[n];
        
        // Initialize the first row
        for (int j = 0; j < n; j++) {
            dp[j] = mat[0][j];
        }

        // Process row by row
        for (int i = 1; i < n; i++) {
            // Find the two maximum values and their column indices from the previous row's DP state
            int firstMax = Integer.MIN_VALUE;
            int firstIdx = -1;
            int secondMax = Integer.MIN_VALUE;

            for (int j = 0; j < n; j++) {
                if (dp[j] > firstMax) {
                    secondMax = firstMax;
                    firstMax = dp[j];
                    firstIdx = j;
                } else if (dp[j] > secondMax) {
                    secondMax = dp[j];
                }
            }

            // Create an array for the current row's results
            int[] nextDp = new int[n];

            // Calculate the new max path for each column in the current row
            for (int j = 0; j < n; j++) {
                if (j != firstIdx) {
                    nextDp[j] = mat[i][j] + firstMax;
                } else {
                    nextDp[j] = mat[i][j] + secondMax;
                }
            }

            // Move to the next row
            dp = nextDp;
        }

        // The answer is the maximum value in the final dp array
        int maxResult = dp[0];
        for (int j = 1; j < n; j++) {
            maxResult = Math.max(maxResult, dp[j]);
        }

        return maxResult;
    }
}
