import java.util.Arrays;

class Solution {
    public int maxProduct(int[] arr, int k) {
        int n = arr.length;
        Arrays.sort(arr);

        // Case 1: If k equals the array size, multiply all elements
        if (k == n) {
            long prod = 1;
            for (int x : arr) {
                prod *= x;
            }
            return (int) prod;
        }

        // Case 2: If all elements are negative and k is odd
        if (arr[n - 1] < 0 && k % 2 == 1) {
            long prod = 1;
            for (int i = n - 1; i >= n - k; i--) {
                prod *= arr[i];
            }
            return (int) prod;
        }

        // Case 3: General greedy approach with two pointers
        int i = 0;
        int j = n - 1;
        long prod = 1;

        // If k is odd, pick the largest element first to make k even
        if (k % 2 == 1) {
            prod *= arr[j];
            j--;
            k--;
        }

        // Greedily pick the maximum product of pairs from either end
        while (k > 0) {
            long leftProd = (long) arr[i] * arr[i + 1];
            long rightProd = (long) arr[j] * arr[j - 1];

            if (leftProd > rightProd) {
                prod *= leftProd;
                i += 2;
            } else {
                prod *= rightProd;
                j -= 2;
            }
            k -= 2;
        }

        return (int) prod;
    }
}
