class Solution {
    public int minCost(int[][] mat) {
        if (mat == null || mat.length == 0) {
            return 0;
        }

        int n = mat.length;

        // Track the minimum cost for each choice in the previous row
        int dp0 = mat[0][0];
        int dp1 = mat[0][1];
        int dp2 = mat[0][2];

        for (int i = 1; i < n; i++) {
            // Calculate the current row's costs based on previous row's alternative choices
            int curr0 = mat[i][0] + Math.min(dp1, dp2);
            int curr1 = mat[i][1] + Math.min(dp0, dp2);
            int curr2 = mat[i][2] + Math.min(dp0, dp1);

            // Move to the next row
            dp0 = curr0;
            dp1 = curr1;
            dp2 = curr2;
        }

        // Return the minimum cost after processing all rows
        return Math.min(dp0, Math.min(dp1, dp2));
    }
}
