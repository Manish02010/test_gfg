class Solution {
    public boolean wifiRange(String s, int x) {
        int n = s.length();
        // Tracks the next room that needs to be covered
        int needed = 0; 
        
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                // If the router's left reach cannot cover the needed room, a gap exists
                if (i - x > needed) {
                    return false;
                }
                // Update the next needed room to be just outside this router's right reach
                needed = i + x + 1;
            }
        }
        
        // Check if the final coverage reaches past the last room
        return needed >= n;
    }
}
