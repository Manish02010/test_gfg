class Solution {
    public boolean palindromePair(String[] arr) {
        int n = arr.length;
        if (n < 2) return false;

        java.util.Map<String, Integer> map = new java.util.HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], i);
        }

        for (int i = 0; i < n; i++) {
            String s = arr[i];
            for (int j = 0; j <= s.length(); j++) {
                String s1 = s.substring(0, j);
                String s2 = s.substring(j);

                // Case 1: Prefix s1 is a palindrome
                if (isPalindrome(s1)) {
                    String revS2 = new StringBuilder(s2).reverse().toString();
                    if (map.containsKey(revS2) && map.get(revS2) != i) {
                        return true;
                    }
                }

                // Case 2: Suffix s2 is a palindrome
                // j < s.length() prevents duplicate checks when s2 is empty
                if (s2.length() > 0 && isPalindrome(s2)) {
                    String revS1 = new StringBuilder(s1).reverse().toString();
                    if (map.containsKey(revS1) && map.get(revS1) != i) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }
}
