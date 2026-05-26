class Solution {
    int minToggle(int[] arr) {
        int countOnes = 0;
        int toggles = 0;
        
        for (int num : arr) {
            if (num == 1) {
                // Keep track of 1s encountered so far
                countOnes++;
            } else {
                // If we see a 0, we have two choices:
                // 1. Flip this 0 to 1 (toggles + 1)
                // 2. Keep this 0, which means flipping all previous 1s to 0s (countOnes)
                toggles = Math.min(toggles + 1, countOnes);
            }
        }
        
        return toggles;
    }
}
