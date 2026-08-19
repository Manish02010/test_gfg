import java.util.Arrays;

class Solution {
    public int countTriplets(int[] arr, int l, int r) {
        // Sort the array to use the two-pointer technique
        Arrays.sort(arr);

        // Triplets in range [l, r] = (Triplets <= r) - (Triplets <= l - 1)
        return countTripletsLessThanOrEqual(arr, r) - countTripletsLessThanOrEqual(arr, l - 1);
    }

    private int countTripletsLessThanOrEqual(int[] arr, int target) {
        int n = arr.length;
        int count = 0;

        // Fix the first element and find the other two using two pointers
        for (int i = 0; i < n - 2; i++) {
            int j = i + 1;
            int k = n - 1;

            while (j < k) {
                int currentSum = arr[i] + arr[j] + arr[k];

                // If sum is valid, all elements between j and k form valid triplets with i and j
                if (currentSum <= target) {
                    count += (k - j);
                    j++; // Try a larger second element
                } else {
                    k--; // Decrease the sum by choosing a smaller third element
                }
            }
        }

        return count;
    }
}
