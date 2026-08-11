import java.util.ArrayList;

class Solution {
    ArrayList<Integer> largestSquare(int[][] mat, int[][] queries, int k) {
        int n = mat.length;
        int m = mat[0].length;
        
        // 1. Build the 2D Prefix Sum array
        // pref[i][j] stores the sum of mat[0..i-1][0..j-1]
        int[][] pref = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                pref[i + 1][j + 1] = mat[i][j] 
                                   + pref[i][j + 1] 
                                   + pref[i + 1][j] 
                                   - pref[i][j];
            }
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        
        // 2. Process each query
        for (int[] q : queries) {
            int rCenter = q[0];
            int cCenter = q[1];
            
            // If the center cell itself has more than k ones (when k = 0 and mat[rCenter][cCenter] = 1)
            if (mat[rCenter][cCenter] > k) {
                result.add(-1);
                continue;
            }
            
            // Maximum radius possible without going out of bounds
            int maxRadius = Math.min(
                Math.min(rCenter, n - 1 - rCenter),
                Math.min(cCenter, m - 1 - cCenter)
            );
            
            int low = 0;
            int high = maxRadius;
            int bestSide = -1;
            
            // Binary search for the largest valid radius
            while (low <= high) {
                int midRadius = low + (high - low) / 2;
                
                // Define the square boundaries
                int r1 = rCenter - midRadius;
                int c1 = cCenter - midRadius;
                int r2 = rCenter + midRadius;
                int c2 = cCenter + midRadius;
                
                // Get count of ones using 2D prefix sum formula
                int onesCount = pref[r2 + 1][c2 + 1] 
                              - pref[r1][c2 + 1] 
                              - pref[r2 + 1][c1] 
                              + pref[r1][c1];
                
                if (onesCount <= k) {
                    bestSide = 2 * midRadius + 1; // Valid side length found
                    low = midRadius + 1;         // Try to look for a larger square
                } else {
                    high = midRadius - 1;        // Too many ones, shrink the square
                }
            }
            
            result.add(bestSide);
        }
        
        return result;
    }
}
