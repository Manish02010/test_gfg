class Solution {
    int maxOnes(int[] arr) {
        int initialOnes = 0;
        int maxGain = 0;
        int currentGain = 0;

        for (int val : arr) {
            if (val == 1) {
                initialOnes++;
            }

            // Treat 0 as +1 (gain) and 1 as -1 (loss)
            int weight = (val == 0) ? 1 : -1;
            
            currentGain += weight;
            
            // Kadane's: if current subarray flip hurts more than helps, reset
            if (currentGain < 0) {
                currentGain = 0;
            }
            
            maxGain = Math.max(maxGain, currentGain);
        }

        return initialOnes + maxGain;
    }
}
