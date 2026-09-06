import java.util.Arrays;

class Solution {
    private int[][][] memo;

    public int minCount(int[] arr) {
        int n = arr.length;
        // memo[idx][last_inc_idx + 1][last_dec_idx + 1]
        // We add 1 to the index to map -1 (no element chosen yet) to 0.
        memo = new int[n][n + 1][n + 1];

        for (int[][] mat : memo) {
            for (int[] row : mat) {
                Arrays.fill(row, -1);
            }
        }

        int maxIncluded = maxSubsequences(arr, 0, -1, -1);
        return n - maxIncluded;
    }

    private int maxSubsequences(int[] arr, int idx, int lastInc, int lastDec) {
        if (idx == arr.length) {
            return 0;
        }

        // Shift indices by +1 for the memoization table to handle the -1 base case
        if (memo[idx][lastInc + 1][lastDec + 1] != -1) {
            return memo[idx][lastInc + 1][lastDec + 1];
        }

        // Option 1: Skip the current element
        int res = maxSubsequences(arr, idx + 1, lastInc, lastDec);

        // Option 2: Try adding to the strictly increasing subsequence
        if (lastInc == -1 || arr[idx] > arr[lastInc]) {
            res = Math.max(res, 1 + maxSubsequences(arr, idx + 1, idx, lastDec));
        }

        // Option 3: Try adding to the strictly decreasing subsequence
        if (lastDec == -1 || arr[idx] < arr[lastDec]) {
            res = Math.max(res, 1 + maxSubsequences(arr, idx + 1, lastInc, idx));
        }

        return memo[idx][lastInc + 1][lastDec + 1] = res;
    }
}
