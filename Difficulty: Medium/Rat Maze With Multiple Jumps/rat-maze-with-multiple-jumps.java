import java.util.ArrayList;

class Solution {
    public ArrayList<ArrayList<Integer>> shortestDist(int[][] mat) {
        int n = mat.length;
        int[][] sol = new int[n][n];
        
        // memo[i][j] = -1 means unvisited, 0 means invalid path, 1 means valid path found
        int[][] memo = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                memo[i][j] = -1;
            }
        }
        
        if (solve(0, 0, mat, sol, memo, n)) {
            ArrayList<ArrayList<Integer>> result = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                ArrayList<Integer> row = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    row.add(sol[i][j]);
                }
                result.add(row);
            }
            return result;
        } else {
            ArrayList<ArrayList<Integer>> noPath = new ArrayList<>();
            ArrayList<Integer> row = new ArrayList<>();
            row.add(-1);
            noPath.add(row);
            return noPath;
        }
    }

    private boolean solve(int i, int j, int[][] mat, int[][] sol, int[][] memo, int n) {
        // Base Case: Destination reached
        if (i == n - 1 && j == n - 1) {
            sol[i][j] = 1;
            return true;
        }
        
        // Out of bounds or cell is blocked
        if (i >= n || j >= n || mat[i][j] == 0) {
            return false;
        }
        
        // If this cell has been processed and confirmed as a dead end, skip it
        if (memo[i][j] == 0) {
            return false;
        }
        
        // Mark current cell on the path
        sol[i][j] = 1;
        int maxJumps = mat[i][j];
        
        // Prioritise shorter jumps first, and forward (right) over downward
        for (int step = 1; step <= maxJumps; step++) {
            // 1. Try moving forward (right)
            if (j + step < n && solve(i, j + step, mat, sol, memo, n)) {
                memo[i][j] = 1;
                return true;
            }
            // 2. Try moving downward
            if (i + step < n && solve(i + step, j, mat, sol, memo, n)) {
                memo[i][j] = 1;
                return true;
            }
        }
        
        // Backtrack and cache the failure to avoid re-evaluating this cell
        sol[i][j] = 0;
        memo[i][j] = 0;
        return false;
    }
}

