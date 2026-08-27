import java.util.*;

class Solution {
    public int maxArea(int[][] mat) {
        int n = mat.length;
        if (n == 0) return 0;
        int m = mat[0].length;

        // An array to store the count of consecutive 1s in each column
        int[] hist = new int[m];
        int maxArea = 0;

        // Process each row one by one
        for (int i = 0; i < n; i++) {
            // Update the consecutive 1s for the current row
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    hist[j] += 1;
                } else {
                    hist[j] = 0;
                }
            }

            // To sort the heights efficiently, we use a counting/frequency array.
            // The maximum height possible is the current row index + 1 (i.e., i + 1).
            int[] freq = new int[i + 2];
            for (int height : hist) {
                freq[height]++;
            }

            // Traverse from the maximum possible height down to 1
            int colCount = 0;
            for (int h = i + 1; h > 0; h--) {
                colCount += freq[h];
                int currentArea = colCount * h;
                maxArea = Math.max(maxArea, currentArea);
            }
        }

        return maxArea;
    }
}
