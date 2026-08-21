class Solution {
    int transform(String s1, String s2) {
        // If lengths are different, transformation is impossible
        if (s1.length() != s2.length()) {
            return -1;
        }

        // Count frequencies of characters in both strings
        int[] count = new int[256]; 
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i)]++;
            count[s2.charAt(i)]--;
        }

        // If frequency mismatch exists, transformation is impossible
        for (int i = 0; i < 256; i++) {
            if (count[i] != 0) {
                return -1;
            }
        }

        // Traverse from end to beginning to find minimum operations
        int res = 0;
        int i = s1.length() - 1;
        int j = s2.length() - 1;

        while (i >= 0) {
            // If characters match, move both pointers
            if (s1.charAt(i) == s2.charAt(j)) {
                i--;
                j--;
            } else {
                // If they don't match, s1[i] must be moved to the front
                i--;
                res++;
            }
        }

        return res;
    }
}
