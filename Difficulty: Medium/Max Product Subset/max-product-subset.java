class Solution {
    public int findMaxProduct(int[] arr) {
        int n = arr.length;
        long MOD = 1000000007;

        // Base case: if there's only one element, return it directly 
        // without forcing it to be a positive modulo.
        if (n == 1) {
            return arr[0];
        }

        long maxNeg = Long.MIN_VALUE;
        int countNeg = 0;
        int countZero = 0;
        int countPos = 0;
        long prod = 1;

        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                countZero++;
                continue;
            }
            if (arr[i] < 0) {
                countNeg++;
                maxNeg = Math.max(maxNeg, arr[i]);
            } else {
                countPos++;
            }
            // Keep reducing the running product via modulo
            prod = (prod * Math.abs(arr[i])) % MOD;
        }

        // Case 1: Every single element is zero
        if (countZero == n) {
            return 0;
        }

        // Case 2: Exactly one negative, no positives, and the rest are zeros
        // The max product here is 0 (by choosing a subset with 0 or empty)
        if (countNeg == 1 && countPos == 0 && countZero > 0) {
            return 0;
        }

        // Case 3: Odd number of negative elements
        // Re-calculate the product by skipping exactly one occurrence of the maximum negative value
        if (countNeg % 2 != 0) {
            prod = 1;
            boolean skipped = false;
            for (int i = 0; i < n; i++) {
                if (arr[i] == 0) {
                    continue;
                }
                if (arr[i] == maxNeg && !skipped) {
                    skipped = true;
                    continue;
                }
                prod = (prod * Math.abs(arr[i])) % MOD;
            }
        }

        return (int) prod;
    }
}

