class Solution {
    public void replaceElements(int[] arr) {
        int n = arr.length;
        if (n < 2) return;

        // Store the original value of the first element
        int prev = arr[0];

        // Update the first element
        arr[0] = arr[0] ^ arr[1];

        // Update middle elements
        for (int i = 1; i < n - 1; i++) {
            int current_orig = arr[i];       // Save current original value
            arr[i] = prev ^ arr[i + 1];     // XOR of original adjacent elements
            prev = current_orig;             // Move original value to prev for next iteration
        }

        // Update the last element using the saved original value of arr[n-2]
        arr[n - 1] = prev ^ arr[n - 1];
    }
}
