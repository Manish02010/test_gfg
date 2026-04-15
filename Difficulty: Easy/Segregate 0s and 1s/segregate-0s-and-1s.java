class Solution {
  void segregate0and1(int[] arr) {
    int left = 0;
    int right = arr.length - 1;

    while (left < right) {
        // If left is already 0, just move forward
        if (arr[left] == 0) {
            left++;
        } 
        // If right is already 1, just move backward
        else if (arr[right] == 1) {
            right--;
        } 
        // If left is 1 and right is 0, swap them
        else {
            arr[left] = 0;
            arr[right] = 1;
            left++;
            right--;
        }
    }
}

}
