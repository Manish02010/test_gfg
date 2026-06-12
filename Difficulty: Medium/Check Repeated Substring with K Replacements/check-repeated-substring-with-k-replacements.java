import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean kSubstr(String s, int k) {
        // If the string length is not perfectly divisible by k, it cannot be a repetition
        if (s.length() % k != 0) {
            return false;
        }
        
        // Map to store the frequencies of each unique substring of length k
        Map<String, Integer> chunkCounts = new HashMap<>();
        int n = s.length();
        
        // Divide the string into substrings of length k starting at indices i % k == 0
        for (int i = 0; i < n; i += k) {
            String chunk = s.substring(i, i + k);
            chunkCounts.put(chunk, chunkCounts.getOrDefault(chunk, 0) + 1);
        }
        
        // Case 1: All substrings are already identical
        if (chunkCounts.size() == 1) {
            return true;
        }
        
        // Case 2: There are exactly two different substrings
        if (chunkCounts.size() == 2) {
            // We can only fix it if at least one of the unique substrings occurs exactly once.
            // This single mismatch can then be replaced to match the dominant substring.
            for (int count : chunkCounts.values()) {
                if (count == 1) {
                    return true;
                }
            }
        }
        
        // Case 3: More than 2 unique substrings means we would need more than 1 operation
        return false;
    }
}
