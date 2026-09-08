import java.util.ArrayList;

class Solution {
    public ArrayList<ArrayList<Integer>> searchWord(char[][] mat, String word) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if (mat == null || mat.length == 0 || mat[0].length == 0 || word == null || word.length() == 0) {
            return result;
        }

        int n = mat.length;
        int m = mat[0].length;

        // 8 directions: N, NE, E, SE, S, SW, W, NW
        int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};

        // Traverse the grid sequentially
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                // Check if the first character matches
                if (mat[r][c] == word.charAt(0)) {
                    if (checkDirections(mat, word, r, c, dr, dc)) {
                        ArrayList<Integer> coordinates = new ArrayList<>();
                        coordinates.add(r);
                        coordinates.add(c);
                        result.add(coordinates);
                    }
                }
            }
        }

        return result;
    }

    private boolean checkDirections(char[][] mat, String word, int r, int c, int[] dr, int[] dc) {
        int n = mat.length;
        int m = mat[0].length;
        int len = word.length();

        if (len == 1) return true;

        // Search in all 8 directions
        for (int i = 0; i < 8; i++) {
            int currRow = r + dr[i];
            int currCol = c + dc[i];
            int k;

            for (k = 1; k < len; k++) {
                // Verify boundaries
                if (currRow < 0 || currRow >= n || currCol < 0 || currCol >= m) {
                    break;
                }
                // Verify character match
                if (mat[currRow][currCol] != word.charAt(k)) {
                    break;
                }
                // Advance in the same direction
                currRow += dr[i];
                currCol += dc[i];
            }

            // Return true if the entire word matches
            if (k == len) {
                return true;
            }
        }

        return false;
    }
}
