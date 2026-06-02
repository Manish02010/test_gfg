import java.util.Arrays;

class Solution {
    public int sumDiffPairs(int[] arr, int k) {
        // Step 1: Sort the array in ascending order
        Arrays.sort(arr);
        
        int maxSum = 0;
        int i = arr.length - 1;
        
        // Step 2: Traverse from right to left (largest to smallest)
        while (i > 0) {
            // Check if the difference between adjacent elements is less than k
            if (arr[i] - arr[i - 1] < k) {
                // Add both elements to the sum
                maxSum += arr[i] + arr[i - 1];
                // Move past both paired elements
                i -= 2;
            } else {
                // If they cannot be paired, skip the largest element
                i--;
            }
        }
        
        return maxSum;
    }
}
