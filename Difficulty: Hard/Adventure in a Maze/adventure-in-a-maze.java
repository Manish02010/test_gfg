class Solution {
    public ArrayList<Integer> findWays(int[][] grid) {
        int n = grid.length;
        int MOD = 1000000007;
        
        // DP tables to store path count and max adventure
        int[][] paths = new int[n][n];
        int[][] maxAdv = new int[n][n];
        
        // Initialize maxAdv table with -1 to signify unreached cells
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maxAdv[i][j] = -1;
            }
        }
        
        // Base case: Starting at the entry cell (0, 0)
        paths[0][0] = 1;
        maxAdv[0][0] = grid[0][0];
        
        // Fill the DP table
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                // Skip the start cell as it's already initialized
                if (r == 0 && c == 0) continue;
                
                int fromLeftPaths = 0;
                int fromLeftAdv = -1;
                // Check if we can arrive from the left cell
                if (c > 0 && paths[r][c - 1] > 0 && (grid[r][c - 1] == 1 || grid[r][c - 1] == 3)) {
                    fromLeftPaths = paths[r][c - 1];
                    fromLeftAdv = maxAdv[r][c - 1];
                }
                
                int fromTopPaths = 0;
                int fromTopAdv = -1;
                // Check if we can arrive from the top cell
                if (r > 0 && paths[r - 1][c] > 0 && (grid[r - 1][c] == 2 || grid[r - 1][c] == 3)) {
                    fromTopPaths = paths[r - 1][c];
                    fromTopAdv = maxAdv[r - 1][c];
                }
                
                // Total paths to current cell
                paths[r][c] = (fromLeftPaths + fromTopPaths) % MOD;
                
                // If the current cell is reachable, calculate its maximum adventure value
                if (paths[r][c] > 0) {
                    maxAdv[r][c] = Math.max(fromLeftAdv, fromTopAdv) + grid[r][c];
                }
            }
        }
        
        // Prepare the final output result array
        ArrayList<Integer> result = new ArrayList<>();
        result.add(paths[n - 1][n - 1]);
        // If unreachable, maxAdv will be -1, so we return 0 instead
        result.add(Math.max(0, maxAdv[n - 1][n - 1]));
        
        return result;
    }
}