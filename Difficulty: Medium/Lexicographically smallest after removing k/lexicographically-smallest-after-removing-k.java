class Solution {
    public String lexicographicallySmallest(String s, int k) {
        int n = s.length();
        
        // Step 1: Correct the value of k
        // A number is a power of 2 if it has only one bit set
        if ((n & (n - 1)) == 0) {
            k /= 2;
        } else {
            k *= 2;
        }
        
        // Step 2: Check validity constraints
        if (k >= n || k < 0) {
            return "-1";
        }
        
        int remDeletions = k;
        StringBuilder stack = new StringBuilder();
        
        // Step 3: Build the lexicographically smallest subsequence
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            while (stack.length() > 0 && stack.charAt(stack.length() - 1) > ch && remDeletions > 0) {
                stack.deleteCharAt(stack.length() - 1);
                remDeletions--;
            }
            stack.append(ch);
        }
        
        // Step 4: If any deletions remain, pop from the end
        while (remDeletions > 0 && stack.length() > 0) {
            stack.deleteCharAt(stack.length() - 1);
            remDeletions--;
        }
        
        return stack.toString();
    }
}
