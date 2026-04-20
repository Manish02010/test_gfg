class Solution {
    public int derangeCount(int n) {
        // Base cases
        if (n == 1) return 0;
        if (n == 2) return 1;

        // Using long to prevent overflow during intermediate calculations 
        // before returning as int (per your 32-bit requirement)
        long prev2 = 0; // D(1)
        long prev1 = 1; // D(2)
        long current = 0;

        for (int i = 3; i <= n; i++) {
            current = (i - 1) * (prev1 + prev2);
            prev2 = prev1;
            prev1 = current;
        }

        return (int) current;
    }
}
