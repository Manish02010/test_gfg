class Solution {
    int cntOnes(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        // Step 1: Traverse the boundary and free connected 1s
        // First and last columns
        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 1) {
                dfs(grid, i, 0, n, m);
            }
            if (grid[i][m - 1] == 1) {
                dfs(grid, i, m - 1, n, m);
            }
        }
        
        // First and last rows
        for (int j = 0; j < m; j++) {
            if (grid[0][j] == 1) {
                dfs(grid, 0, j, n, m);
            }
            if (grid[n - 1][j] == 1) {
                dfs(grid, n - 1, j, n, m);
            }
        }
        
        // Step 2: Count the remaining 1s (which are trapped)
        int trappedOnes = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    trappedOnes++;
                }
            }
        }
        
        return trappedOnes;
    }
    
    private void dfs(int[][] grid, int r, int c, int n, int m) {
        // Boundary check and base case
        if (r < 0 || r >= n || c < 0 || c >= m || grid[r][c] != 1) {
            return;
        }
        
        // Mark as visited by changing 1 to 0
        grid[r][c] = 0;
        
        // Explore 4-directional neighbors
        dfs(grid, r + 1, c, n, m); // Down
        dfs(grid, r - 1, c, n, m); // Up
        dfs(grid, r, c + 1, n, m); // Right
        dfs(grid, r, c - 1, n, m); // Left
    }
}
