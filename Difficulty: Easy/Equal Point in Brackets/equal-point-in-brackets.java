
class Solution {
    public int findIndex(String s) {
        int closingCount = 0;
        
        // Count the total number of closing brackets
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                closingCount++;
            }
        }
        
        return closingCount;
    }
}
