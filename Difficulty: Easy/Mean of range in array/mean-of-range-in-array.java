import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> findMean(int[] arr, int[][] queries) {
        int n = arr.length;
        long[] prefixSum = new long[n + 1];
        ArrayList<Integer> result = new ArrayList<>();

        // Build prefix sum array (using long to prevent overflow)
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + arr[i];
        }

        // Process each query
        for (int[] query : queries) {
            int l = query[0];
            int r = query[1];
            
            // Sum of subarray arr[l...r]
            long sum = prefixSum[r + 1] - prefixSum[l];
            
            // Number of elements in the range
            int count = r - l + 1;
            
            // Calculate floor of the mean
            result.add((int) (sum / count));
        }

        return result;
    }
}
