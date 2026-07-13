import java.util.HashMap;
import java.util.Map;

class Solution {
    // Helper function to calculate (base^exp) % MOD efficiently
    private long power(long base, long exp, long mod) {
        long res = 1;
        base %= mod;
        while (exp > 0) {
            if (exp % 2 == 1) {
                res = (res * base) % mod;
            }
            base = (base * base) % mod;
            exp /= 2;
        }
        return res;
    }

    int minOperations(int[] b) {
        int n = b.length;
        boolean[] visited = new boolean[n];
        Map<Integer, Integer> maxPrimePowers = new HashMap<>();
        long MOD = 1_000_000_007L;

        // Step 1: Find all disjoint cycle lengths
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int length = 0;
                int curr = i;

                while (!visited[curr]) {
                    visited[curr] = true;
                    curr = b[curr] - 1; // Convert 1-based indexing to 0-based
                    length++;
                }

                // Step 2 & 3: Prime factorization of 'length' and updating the global map
                int temp = length;
                for (int d = 2; d * d <= temp; d++) {
                    if (temp % d == 0) {
                        int count = 0;
                        while (temp % d == 0) {
                            count++;
                            temp /= d;
                        }
                        maxPrimePowers.put(d, Math.max(maxPrimePowers.getOrDefault(d, 0), count));
                    }
                }
                if (temp > 1) {
                    maxPrimePowers.put(temp, Math.max(maxPrimePowers.getOrDefault(temp, 0), 1));
                }
            }
        }

        // Step 4: Calculate final LCM modulo 10^9+7
        long ans = 1;
        for (Map.Entry<Integer, Integer> entry : maxPrimePowers.entrySet()) {
            int prime = entry.getKey();
            int maxExponent = entry.getValue();
            ans = (ans * power(prime, maxExponent, MOD)) % MOD;
        }

        return (int) ans;
    }
}
