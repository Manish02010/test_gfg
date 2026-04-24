class Solution {
    public int visibleBuildings(int arr[]) {
        if (arr == null || arr.length == 0) return 0;
        
        int count = 1; // The first building always sees the sun
        int maxHeight = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            // If the current building is at least as tall as the tallest so far
            if (arr[i] >= maxHeight) {
                count++;
                maxHeight = arr[i];
            }
        }
        
        return count;
    }
}
