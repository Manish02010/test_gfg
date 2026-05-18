import java.util.HashMap;

class Solution {
    // HashMap to store already calculated results
    private HashMap<Integer, Integer> memo = new HashMap<>();

    public int maxSum(int n) {
        // Base cases
        if (n == 0) return 0;
        if (n == 1) return 1;
        
        // Return precalculated value if available
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        
        // Recursively break down the number
        int brokenSum = maxSum(n / 2) + maxSum(n / 3) + maxSum(n / 4);
        
        // Take the maximum of keeping n or breaking it down
        int result = Math.max(n, brokenSum);
        
        // Store the result in the map
        memo.put(n, result);
        
        return result;
    }
}
