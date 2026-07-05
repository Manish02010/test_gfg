class Solution {
    public int maxCharGap(String s) {
        // Array to store the first occurrence index of each character
        int[] firstIndex = new int[26];
        
        // Initialize all indices to -1 (indicating not yet seen)
        for (int i = 0; i < 26; i++) {
            firstIndex[i] = -1;
        }
        
        int maxGap = -1;
        
        // Traverse the string
        for (int j = 0; j < s.length(); j++) {
            int charIdx = s.charAt(j) - 'a';
            
            if (firstIndex[charIdx] == -1) {
                // Store the first occurrence
                firstIndex[charIdx] = j;
            } else {
                // Calculate gap if the character has been seen before
                int currentGap = j - firstIndex[charIdx] - 1;
                maxGap = Math.max(maxGap, currentGap);
            }
        }
        
        return maxGap;
    }
}
