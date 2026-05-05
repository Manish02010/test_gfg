class Solution {
    public long sumXOR(int[] arr) {
        long totalSum = 0;
        int n = arr.length;

        // Iterate through each bit position (0 to 30, as arr[i] <= 10^5)
        for (int i = 0; i < 31; i++) {
            long countOnes = 0;
            
            // Count how many numbers have the i-th bit set
            for (int num : arr) {
                if ((num & (1 << i)) != 0) {
                    countOnes++;
                }
            }
            
            // Numbers with i-th bit as 0
            long countZeros = n - countOnes;
            
            // The number of pairs with different i-th bits is (countOnes * countZeros)
            // Each such pair contributes 2^i to the total XOR sum
            totalSum += (countOnes * countZeros) * (1L << i);
        }

        return totalSum;
    }
}
