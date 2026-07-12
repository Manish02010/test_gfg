import java.util.Arrays;

class Solution {
    public int maxAmount(int[] arr, int k) {
        long low = 0;
        long high = 0;
        for (int x : arr) {
            if (x > high) {
                high = x;
            }
        }
        
        long ansPrice = 0;
        
        // 1. Binary search for the threshold price
        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (countTickets(arr, mid) >= k) {
                ansPrice = mid;
                low = mid + 1; // Try to find a higher minimum price
            } else {
                high = mid - 1;
            }
        }
        
        // 2. Calculate the revenue using the threshold price
        long totalRevenue = 0;
        long ticketsSold = 0;
        long MOD = 1000000007;
        
        for (int x : arr) {
            if (x >= ansPrice + 1) {
                long count = x - (ansPrice + 1) + 1;
                ticketsSold += count;
                
                // Sum of arithmetic progression from (ansPrice + 1) to x
                long sumX = ((long) x * (x + 1)) / 2;
                long sumAns = (ansPrice * (ansPrice + 1)) / 2;
                long currentRevenue = sumX - sumAns;
                
                totalRevenue = (totalRevenue + currentRevenue) % MOD;
            }
        }
        
        // 3. Sell the remaining tickets exactly at the threshold price `ansPrice`
        long remainingTickets = k - ticketsSold;
        if (remainingTickets > 0) {
            totalRevenue = (totalRevenue + (remainingTickets * ansPrice) % MOD) % MOD;
        }
        
        return (int) totalRevenue;
    }
    
    // Helper function to count how many tickets are available at a price >= mid
    private long countTickets(int[] arr, long mid) {
        if (mid == 0) return Long.MAX_VALUE; // Prevent infinite matching when mid is 0
        long count = 0;
        for (int x : arr) {
            if (x >= mid) {
                count += (x - mid + 1);
            }
        }
        return count;
    }
}
