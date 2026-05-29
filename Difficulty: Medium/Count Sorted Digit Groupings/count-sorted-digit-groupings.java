import java.util.Arrays;

class Solution {
    private int[][] memo;

    public int validGroups(String s) {
        int n = s.length();
        // Max possible sum of digits is 9 * n
        int maxSum = 9 * n; 
        
        // Initialize memoization table with -1
        memo = new int[n][maxSum + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        
        return solve(0, 0, s);
    }

    private int solve(int idx, int prevSum, String s) {
        // Base case: successfully reached the end of the string
        if (idx == s.length()) {
            return 1;
        }

        // Return cached result if already calculated
        if (memo[idx][prevSum] != -1) {
            return memo[idx][prevSum];
        }

        int ans = 0;
        int currSum = 0;

        // Try creating substrings starting from 'idx' to 'i'
        for (int i = idx; i < s.length(); i++) {
            currSum += s.charAt(i) - '0';

            // The grouping is valid if current sub-group sum >= previous sub-group sum
            if (currSum >= prevSum) {
                ans += solve(i + 1, currSum, s);
            }
        }

        // Store and return the result for the current state
        return memo[idx][prevSum] = ans;
    }
}
