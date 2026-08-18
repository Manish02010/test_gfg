import java.util.*;

class Solution {
    public String compress(String s) {
        int n = s.length();
        if (n == 0) return "";

        // Step 1: Precompute KMP LPS array to find repeating prefixes
        int[] lps = new int[n];
        for (int i = 1; i < n; i++) {
            int j = lps[i - 1];
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = lps[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            lps[i] = j;
        }

        // Step 2: Traverse backwards and greedily compress using '*'
        StringBuilder sb = new StringBuilder();
        int i = n - 1;
        while (i >= 0) {
            int len = i + 1;
            // Check if substring has even length and the LPS is at least half the length
            if (len % 2 == 0 && lps[i] >= len / 2) {
                int halfLen = len / 2;
                int smallestPeriod = len - lps[i];

                // Periodicity Check: halfLen must be a multiple of the smallest period
                if (halfLen % smallestPeriod == 0) {
                    sb.append('*');
                    i = halfLen - 1; // Jump past the duplicated second half
                    continue;
                }
            }
            sb.append(s.charAt(i));
            i--;
        }

        // Reverse back to original left-to-right order
        return sb.reverse().toString();
    }
}
