class Solution {
    int maxSubstring(String s) {
        int maxSoFar = Integer.MIN_VALUE;
        int currentMax = 0;
        
        for (int i = 0; i < s.length(); i++) {
            // Convert '0' to 1 and '1' to -1
            int value = (s.charAt(i) == '0') ? 1 : -1;
            
            currentMax += value;
            
            // Track the maximum difference found so far
            if (currentMax > maxSoFar) {
                maxSoFar = currentMax;
            }
            
            // Reset current running sum if it drops below 0
            if (currentMax < 0) {
                currentMax = 0;
            }
        }
        
        return maxSoFar;
    }
}
