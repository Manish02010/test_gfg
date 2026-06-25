import java.util.ArrayList;

class Solution {
    public static ArrayList<Integer> increasingNumbers(int n) {
        ArrayList<Integer> result = new ArrayList<>();
        
        // Base Case: 1-digit numbers include 0
        if (n == 1) {
            for (int i = 0; i <= 9; i++) {
                result.add(i);
            }
            return result;
        }
        
        // Since digits must be strictly increasing, 
        // the max length possible is 9 (123456789).
        if (n > 9) {
            return result;
        }
        
        // Start the recursive backtracking
        // An n-digit number (where n > 1) cannot start with 0
        for (int startDigit = 1; startDigit <= 9; startDigit++) {
            generateNumbers(startDigit, startDigit, 1, n, result);
        }
        
        return result;
    }
    
    private static void generateNumbers(int currentNum, int lastDigit, int currentLength, int targetLength, ArrayList<Integer> result) {
        // Base case: If the number has reached the target number of digits
        if (currentLength == targetLength) {
            result.add(currentNum);
            return;
        }
        
        // Try appending the next strictly greater digit
        for (int nextDigit = lastDigit + 1; nextDigit <= 9; nextDigit++) {
            generateNumbers(currentNum * 10 + nextDigit, nextDigit, currentLength + 1, targetLength, result);
        }
    }
}
