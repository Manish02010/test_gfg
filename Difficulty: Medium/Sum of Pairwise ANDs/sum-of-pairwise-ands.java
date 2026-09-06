class Solution {
    public long pairAndSum(int[] arr) {
        long totalSum = 0;

        // Loop through all 32 possible bit positions
        for (int k = 0; k < 32; k++) {
            long count = 0;

            // Count how many elements have the k-th bit set
            for (int num : arr) {
                if ((num & (1 << k)) != 0) {
                    count++;
                }
            }

            // Calculate total pairs that have the k-th bit set
            long pairs = (count * (count - 1)) / 2;

            // Add the contribution of this bit position to the final sum
            totalSum += pairs * (1L << k);
        }

        return totalSum;
    }
}
