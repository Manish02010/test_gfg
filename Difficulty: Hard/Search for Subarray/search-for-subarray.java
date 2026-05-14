import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> search(int[] a, int[] b) {
        ArrayList<Integer> result = new ArrayList<>();
        
        // Handle edge cases where b is empty or larger than a
        if (b == null || b.length == 0 || a == null || a.length < b.length) {
            return result;
        }

        // Step 1: Compute the Longest Prefix Suffix (LPS) array for b[]
        int[] lps = computeLPSArray(b);

        int i = 0; // Index for a[]
        int j = 0; // Index for b[]

        // Step 2: Search for pattern b[] in array a[]
        while (i < a.length) {
            if (a[i] == b[j]) {
                i++;
                j++;
            }

            if (j == b.length) {
                // Match found: store the 0-based starting index
                result.add(i - j);
                j = lps[j - 1]; // Look for next potential match
            } else if (i < a.length && a[i] != b[j]) {
                // Mismatch after j matches
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return result;
    }

    private int[] computeLPSArray(int[] b) {
        int[] lps = new int[b.length];
        int len = 0; // Length of the previous longest prefix suffix
        int i = 1;
        lps[0] = 0; // lps[0] is always 0

        while (i < b.length) {
            if (b[i] == b[len]) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}
