import java.math.BigInteger;

class Solution {
    public int getLastDigit(String a, String b) {
        // Base case: any number to the power of 0 is 1
        if (b.equals("0")) {
            return 1;
        }
        
        // If base is 0, any positive power is 0
        if (a.equals("0")) {
            return 0;
        }

        // Get the last digit of base 'a'
        int lastA = a.charAt(a.length() - 1) - '0';

        // Calculate b % 4 using its last two digits
        int lenB = b.length();
        int exp;
        if (lenB == 1) {
            exp = b.charAt(0) - '0';
        } else {
            exp = (b.charAt(lenB - 2) - '0') * 10 + (b.charAt(lenB - 1) - '0');
        }

        // Map % 4 value to cycle range 1 to 4
        exp = exp % 4;
        if (exp == 0) {
            exp = 4;
        }

        // Compute (lastA ^ exp) % 10
        int result = (int) Math.pow(lastA, exp);
        return result % 10;
    }
}
