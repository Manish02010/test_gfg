import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> exitPoint(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        
        // Direction vectors: Right, Down, Left, Up (Clockwise order)
        int[] dRow = {0, 1, 0, -1};
        int[] dCol = {1, 0, -1, 0};
        
        // Start at top-left moving Right (direction index 0)
        int r = 0, c = 0;
        int dir = 0;
        
        // Variables to keep track of the last valid cell inside the matrix
        int lastRow = 0;
        int lastCol = 0;
        
        while (r >= 0 && r < n && c >= 0 && c < m) {
            // Keep track of the current valid cell
            lastRow = r;
            lastCol = c;
            
            // Rule: If 1 is encountered, turn right clockwise and change cell to 0
            if (mat[r][c] == 1) {
                mat[r][c] = 0;
                dir = (dir + 1) % 4;
            }
            
            // Move to the next cell
            r += dRow[dir];
            c += dCol[dir];
        }
        
        // Return the last valid cell coordinates
        List<Integer> result = new ArrayList<>();
        result.add(lastRow);
        result.add(lastCol);
        return result;
    }
}
