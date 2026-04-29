class Solution {
    public int minSwaps(int[] arr) {
        int n = arr.length;
        int totalOnes = 0;

        // Step 1: Count total number of 1s
        for (int i : arr) {
            if (i == 1) totalOnes++;
        }

        // Step 2: Handle edge case
        if (totalOnes == 0) return -1;

        // Step 3: Sliding window to find max 1s in a window of size 'totalOnes'
        int currentOnes = 0;
        int maxOnes = 0;

        for (int i = 0; i < n; i++) {
            // Add current element to window
            currentOnes += arr[i];

            // When window size exceeds totalOnes, slide the start
            if (i >= totalOnes) {
                currentOnes -= arr[i - totalOnes];
            }

            // Track the maximum 1s found in any window of size totalOnes
            maxOnes = Math.max(maxOnes, currentOnes);
        }

        // Min swaps = window size - maximum 1s found in a window
        return totalOnes - maxOnes;
    }
}
