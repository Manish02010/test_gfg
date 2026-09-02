import java.util.HashSet;

class Solution {
    public int solve(int n, String s) {
        // Tracks customers currently using a computer
        HashSet<Character> allocated = new HashSet<>();
        // Tracks customers who arrived but couldn't get a computer
        HashSet<Character> turnedAway = new HashSet<>();

        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char customer = s.charAt(i);

            // If the customer is already using a computer, they are now leaving
            if (allocated.contains(customer)) {
                allocated.remove(customer);
            } 
            // If the customer was already turned away, they are now leaving the cafe
            else if (turnedAway.contains(customer)) {
                turnedAway.remove(customer);
            } 
            // First time seeing this customer (Arrival)
            else {
                // If a computer is available, assign it
                if (allocated.size() < n) {
                    allocated.add(customer);
                } 
                // No computer available, they are turned away
                else {
                    turnedAway.add(customer);
                    count++;
                }
            }
        }

        return count;
    }
}
