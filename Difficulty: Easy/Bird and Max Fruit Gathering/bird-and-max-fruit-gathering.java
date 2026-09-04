import java.util.ArrayList;

class Solution {
    public int maxFruits(ArrayList<Integer> arr, int m) {
        int n = arr.size();

        // Edge case: if no trees or no moves allowed
        if (n == 0 || m <= 0) {
            return 0;
        }

        // If m >= n, the bird can visit all unique trees
        if (m >= n) {
            int totalSum = 0;
            for (int fruit : arr) {
                totalSum += fruit;
            }
            return totalSum;
        }

        // Find the sum of the first window of size m
        int currentSum = 0;
        for (int i = 0; i < m; i++) {
            currentSum += arr.get(i);
        }

        int maxSum = currentSum;

        // Slide the window across the circular array
        for (int i = 1; i < n; i++) {
            // Subtract the element that is leaving the window
            // Add the new element entering the window circularly
            currentSum = currentSum - arr.get(i - 1) + arr.get((i + m - 1) % n);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}
