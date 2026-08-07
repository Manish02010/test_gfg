class Solution {
    public int countFriendsPairings(int n) {
        // Base cases
        if (n <= 2) {
            return n;
        }
        
        int mod = 1000000007;
        
        // State variables representing the last two values
        long prev2 = 1; // Represents f(n-2), initially f(1) = 1
        long prev1 = 2; // Represents f(n-1), initially f(2) = 2
        long current = 0;
        
        // Iteratively compute values up to n
        for (int i = 3; i <= n; i++) {
            current = (prev1 + (i - 1) * prev2) % mod;
            prev2 = prev1;
            prev1 = current;
        }
        
        return (int) current;
    }
}
