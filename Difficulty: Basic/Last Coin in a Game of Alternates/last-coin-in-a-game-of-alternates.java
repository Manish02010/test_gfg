class Solution {
    public int coin(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        
        // Continue simulation until only one coin remains
        while (start < end) {
            if (arr[start] > arr[end]) {
                start++;
            } else {
                end--;
            }
        }
        
        // Return the final remaining coin value
        return arr[start];
    }
}
