class Solution {
    public int countMinOperations(int arr[]) {
        int totalIncrements = 0;
        int maxDoubles = 0;
        
        for (int num : arr) {
            int currentDoubles = 0;
            
            while (num > 0) {
                // If the number is odd, it needs an increment
                if ((num & 1) == 1) {
                    totalIncrements++;
                }
                
                // If the number is greater than 1, it will need a division (doubling in reverse)
                if (num > 1) {
                    currentDoubles++;
                }
                
                num >>= 1; // Shift right to divide by 2
            }
            
            // The global doubling operations needed is determined by the maximum depth
            maxDoubles = Math.max(maxDoubles, currentDoubles);
        }
        
        return totalIncrements + maxDoubles;
    }
}
