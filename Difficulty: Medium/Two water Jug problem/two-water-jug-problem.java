class Solution {
    public int minSteps(int m, int n, int d) {
        // If d is greater than both jugs, it's impossible
        if (d > Math.max(m, n)) return -1;
        
        // If d is not a multiple of the GCD of m and n, it's impossible
        if (d % gcd(m, n) != 0) return -1;

        // We compare starting by filling jug m vs starting by filling jug n
        return Math.min(solve(m, n, d), solve(n, m, d));
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    private int solve(int fromCap, int toCap, int d) {
        // Initialize: fill the 'from' jug
        int from = fromCap;
        int to = 0;
        int steps = 1;

        while (from != d && to != d) {
            // Amount to pour: all available water or until 'to' jug is full
            int temp = Math.min(from, toCap - to);

            to += temp;
            from -= temp;
            steps++;

            if (from == d || to == d) break;

            // If the 'from' jug is empty, refill it
            if (from == 0) {
                from = fromCap;
                steps++;
            }

            // If the 'to' jug is full, empty it
            if (to == toCap) {
                to = 0;
                steps++;
            }
        }
        return steps;
    }
}

