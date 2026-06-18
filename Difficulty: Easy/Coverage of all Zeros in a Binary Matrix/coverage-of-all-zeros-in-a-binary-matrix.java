class Solution {
    public int findCoverage(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int totalCoverage = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    
                    // 1. Check Upward direction
                    for (int r = i - 1; r >= 0; r--) {
                        if (mat[r][j] == 1) {
                            totalCoverage++;
                            break;
                        }
                    }
                    
                    // 2. Check Downward direction
                    for (int r = i + 1; r < n; r++) {
                        if (mat[r][j] == 1) {
                            totalCoverage++;
                            break;
                        }
                    }
                    
                    // 3. Check Leftward direction
                    for (int c = j - 1; c >= 0; c--) {
                        if (mat[i][c] == 1) {
                            totalCoverage++;
                            break;
                        }
                    }
                    
                    // 4. Check Rightward direction
                    for (int c = j + 1; c < m; c++) {
                        if (mat[i][c] == 1) {
                            totalCoverage++;
                            break;
                        }
                    }
                    
                }
            }
        }
        
        return totalCoverage;
    }
}
