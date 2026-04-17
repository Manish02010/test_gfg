import java.util.HashSet;

class Solution {
    boolean canFormPalindrome(String s) {
        HashSet<Character> oddChars = new HashSet<>();
        
        for (char c : s.toCharArray()) {
            if (oddChars.contains(c)) {
                oddChars.remove(c);
            } else {
                oddChars.add(c);
            }
        }
        
        // If 0 or 1 character has an odd frequency, it can be a palindrome
        return oddChars.size() <= 1;
    }
}
