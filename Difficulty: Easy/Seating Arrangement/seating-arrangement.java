class Solution {
    public boolean canSeatAllPeople(int k, int[] seats) {
        int n = seats.length;
        
        // Step 1: Validate existing arrangement
        for (int i = 0; i < n - 1; i++) {
            if (seats[i] == 1 && seats[i + 1] == 1) {
                return k == 0 ? false : false; // If already invalid, cannot legally seat any k >= 0 safely, or if k=0 it's explicitly stated to output false due to existing violation
            }
        }
        
        int count = 0;
        
        // Step 2: Greedily place new people
        for (int i = 0; i < n; i++) {
            if (seats[i] == 0) {
                // Check if the left neighbor is empty or out of bounds
                boolean leftEmpty = (i == 0 || seats[i - 1] == 0);
                // Check if the right neighbor is empty or out of bounds
                boolean rightEmpty = (i == n - 1 || seats[i + 1] == 0);
                
                if (leftEmpty && rightEmpty) {
                    seats[i] = 1; // Sit a person here
                    count++;
                    
                    if (count >= k) {
                        return true;
                    }
                }
            }
        }
        
        return count >= k;
    }
}
