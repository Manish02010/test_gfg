class Solution {
    public int maxPeopleDefeated(int p) {
        long low = 0;
        long high = 2000; // Cube root of (6 * 2^31) fits well within 2000
        int ans = 0;
        
        while (low <= high) {
            long mid = low + (high - low) / 2;
            long required = mid * (mid + 1) * (2 * mid + 1) / 6;
            
            if (required <= p) {
                ans = (int) mid;
                low = mid + 1; // Try to defeat more people
            } else {
                high = mid - 1; // Required strength is too high
            }
        }
        
        return ans;
    }
}
