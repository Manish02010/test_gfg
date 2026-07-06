class Solution {
    public int maxPathSum(int[] a, int[] b) {
        int i = 0, j = 0;
        int m = a.length, n = b.length;
        int sumA = 0, sumB = 0;
        int totalSum = 0;

        while (i < m && j < n) {
            if (a[i] < b[j]) {
                sumA += a[i++];
            } else if (b[j] < a[i]) {
                sumB += b[j++];
            } else { // Common element found
                totalSum += Math.max(sumA, sumB) + a[i];
                sumA = 0;
                sumB = 0;
                i++;
                j++;
            }
        }

        // Add remaining elements of array a
        while (i < m) {
            sumA += a[i++];
        }

        // Add remaining elements of array b
        while (j < n) {
            sumB += b[j++];
        }

        totalSum += Math.max(sumA, sumB);

        return totalSum;
    }
}
