class Solution {
    public boolean isMaxHeap(int[] arr) {
        int n = arr.length;
        
        for (int i = 0; i <= (n - 2) / 2; i++) {
            // Check if left child exists and is greater than parent
            if (arr[2 * i + 1] > arr[i]) {
                return false;
            }
            
            // Check if right child exists and is greater than parent
            if (2 * i + 2 < n && arr[2 * i + 2] > arr[i]) {
                return false;
            }
        }
        return true;
    }
}
