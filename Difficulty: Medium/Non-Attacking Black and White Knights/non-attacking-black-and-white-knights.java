class Solution {
    public long numOfWays(int n, int m) {
        // Total number of squares on the chessboard
        long totalSquares = (long) n * m;
        
        // Total ways to place two distinct pieces (one black, one white) without any restrictions
        long totalWays = totalSquares * (totalSquares - 1);
        
        // Count of 2x3 sub-grids where knights can mutually attack each other
        long attack2x3 = 0;
        if (n >= 2 && m >= 3) {
            attack2x3 = (long) (n - 1) * (m - 2);
        }
        
        // Count of 3x2 sub-grids where knights can mutually attack each other
        long attack3x2 = 0;
        if (n >= 3 && m >= 2) {
            attack3x2 = (long) (n - 2) * (m - 1);
        }
        
        // Each 2x3 or 3x2 block contains exactly 2 pairs of attacking knights.
        // Since the knights are distinct (Black and White), each pair can be placed in 2 ways.
        // Thus, we subtract 4 arrangements per valid sub-grid block.
        long attackingWays = 4 * attack2x3 + 4 * attack3x2;
        
        return totalWays - attackingWays;
    }
}
