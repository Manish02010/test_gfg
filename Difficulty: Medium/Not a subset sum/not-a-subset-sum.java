import java.util.Arrays;

class Solution {
    public int findSmallest(int[] arr) {
        // Step 1: Sort the array in ascending order
        Arrays.sort(arr);
        
        // Step 2: Initialize the smallest unrepresentable positive integer
        int res = 1;
        
        // Step 3: Iterate through the sorted array
        for (int i = 0; i < arr.length; i++) {
            // If the current element is greater than res, 
            // res cannot be formed using any combination
            if (arr[i] > res) {
                break;
            }
            // Otherwise, add the element to extend the reachable range
            res += arr[i];
        }
        
        return res;
    }
}
