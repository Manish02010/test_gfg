import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int shortestPath(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        // 1. Mark all landmines and their adjacent cells as unsafe
        boolean[][] unsafe = new boolean[n][m];
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (mat[r][c] == 0) {
                    unsafe[r][c] = true;
                    for (int i = 0; i < 4; i++) {
                        int nr = r + dr[i];
                        int nc = c + dc[i];
                        if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                            unsafe[nr][nc] = true;
                        }
                    }
                }
            }
        }

        // 2. Initialize BFS queue and visited matrix
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];

        // Add all safe starting cells from the first column
        for (int r = 0; r < n; r++) {
            if (!unsafe[r][0]) {
                queue.add(new int[]{r, 0, 1}); // {row, col, path_length}
                visited[r][0] = true;
            }
        }

        // 3. Perform standard BFS traversal
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];
            int dist = current[2];

            // If we reached the rightmost column, return the length
            if (c == m - 1) {
                return dist;
            }

            // Move in 4 allowed directions
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m && !unsafe[nr][nc] && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    queue.add(new int[]{nr, nc, dist + 1});
                }
            }
        }

        return -1;
    }
}
