import java.util.*;

class Solution {
    public int maxProfit(int x, int y, int[] a, int[] b) {
        int n = a.length;
        int[][] diffs = new int[n][2];
        
        for (int i = 0; i < n; i++) {
            diffs[i][0] = a[i] - b[i]; // Profit difference
            diffs[i][1] = i;           // Original index
        }

        // Sort by gain descending: tasks where A is better than B come first
        Arrays.sort(diffs, (p1, p2) -> Integer.compare(p2[0], p1[0]));

        int totalProfit = 0;
        int countA = 0;
        int countB = 0;

        for (int i = 0; i < n; i++) {
            int idx = diffs[i][1];
            
            // Assign to A if:
            // 1. A has room AND (it's more profitable than B)
            // 2. OR we are forced to use A because B is full (n - i is tasks left)
            if ((countA < x && a[idx] >= b[idx]) || (n - i > y - countB)) {
                if (countA < x) {
                    totalProfit += a[idx];
                    countA++;
                } else {
                    totalProfit += b[idx];
                    countB++;
                }
            } else if (countB < y) {
                totalProfit += b[idx];
                countB++;
            } else {
                totalProfit += a[idx];
                countA++;
            }
        }

        return totalProfit;
    }
}

