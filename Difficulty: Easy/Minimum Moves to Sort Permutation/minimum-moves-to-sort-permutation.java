class Solution {
    public int minMoves(int[] arr) {
        int n = arr.length;
        if (n <= 1) return 0;

        // map to store the position/index of each element
        int[] pos = new int[n + 1];
        for (int i = 0; i < n; i++) {
            pos[arr[i]] = i;
        }

        int maxLen = 1;
        int currentLen = 1;

        // Find the longest consecutive increasing subsequence
        for (int i = 2; i <= n; i++) {
            // If the current number appears after the previous number, 
            // they can form a consecutive increasing subsequence
            if (pos[i] > pos[i - 1]) {
                currentLen++;
            } else {
                currentLen = 1;
            }
            maxLen = Math.max(maxLen, currentLen);
        }

        return n - maxLen;
    }
}
