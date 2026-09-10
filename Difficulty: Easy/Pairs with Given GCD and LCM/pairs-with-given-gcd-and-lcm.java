class Solution {
    public int pairCount(int x, int y) {
        // LCM must be perfectly divisible by GCD
        if (y % x != 0) {
            return 0;
        }

        int k = y / x;
        int distinctPrimeFactors = 0;

        // Find the number of distinct prime factors of k
        for (int i = 2; i * i <= k; i++) {
            if (k % i == 0) {
                distinctPrimeFactors++;
                while (k % i == 0) {
                    k /= i;
                }
            }
        }

        // If the remaining k is a prime number greater than 1
        if (k > 1) {
            distinctPrimeFactors++;
        }

        // The total number of valid pairs is 2^distinctPrimeFactors
        return 1 << distinctPrimeFactors;
    }
}
