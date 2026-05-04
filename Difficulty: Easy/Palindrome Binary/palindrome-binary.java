class Solution {
    public boolean isBinaryPalindrome(int n) {
        // Convert the integer to its binary string representation
        String binary = Integer.toBinaryString(n);
        
        int left = 0;
        int right = binary.length() - 1;
        
        // Check characters from both ends moving towards the center
        while (left < right) {
            if (binary.charAt(left) != binary.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
}
