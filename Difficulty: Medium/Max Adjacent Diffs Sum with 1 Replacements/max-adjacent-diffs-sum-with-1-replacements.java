class Solution {
    public int maxDiffSum(int[] arr) {
        int n = arr.length;
        if (n <= 1) return 0;

        // Variables tracking the max sum ending at the previous element
        int prevUnmodified = 0;
        int prevModified = 0;

        for (int i = 1; i < n; i++) {
            int currUnmodified = Math.max(
                prevUnmodified + Math.abs(arr[i] - arr[i - 1]), 
                prevModified + Math.abs(arr[i] - 1)
            );

            int currModified = Math.max(
                prevUnmodified + Math.abs(1 - arr[i - 1]), 
                prevModified
            ); // Math.abs(1 - 1) is 0

            prevUnmodified = currUnmodified;
            prevModified = currModified;
        }

        return Math.max(prevUnmodified, prevModified);
    }
}
