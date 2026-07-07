import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int largestArea(int n, int m, int[][] arr) {
        ArrayList<Integer> rows = new ArrayList<>();
        ArrayList<Integer> cols = new ArrayList<>();
        
        // Add boundary conditions (0 and n+1 / m+1)
        rows.add(0);
        rows.add(n + 1);
        cols.add(0);
        cols.add(m + 1);
        
        // Collect all blocked row and column coordinates
        // Added safety check to prevent NullPointerException or Empty array crashes
        if (arr != null) {
            for (int[] cell : arr) {
                if (cell.length >= 2) {
                    rows.add(cell[0]);
                    cols.add(cell[1]);
                }
            }
        }
        
        // Sort both collections to easily find consecutive gaps
        Collections.sort(rows);
        Collections.sort(cols);
        
        // Find the maximum continuous gap between rows
        int maxRowGap = 0;
        for (int i = 1; i < rows.size(); i++) {
            maxRowGap = Math.max(maxRowGap, rows.get(i) - rows.get(i - 1) - 1);
        }
        
        // Find the maximum continuous gap between columns
        int maxColGap = 0;
        for (int i = 1; i < cols.size(); i++) {
            maxColGap = Math.max(maxColGap, cols.get(i) - cols.get(i - 1) - 1);
        }
        
        // Use long multiplication to prevent integer overflow during calculation
        long maxArea = (long) maxRowGap * maxColGap;
        
        // Return as int (or cast safely depending on problem requirements)
        return (int) maxArea;
    }
}

