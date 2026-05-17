import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    List<Integer> makeBeautiful(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        
        for (int num : arr) {
            if (!stack.isEmpty() && isDifferentSign(stack.peek(), num)) {
                stack.pop();
            } else {
                stack.push(num);
            }
        }
        
        // Convert the stack back to the required List format
        return new ArrayList<>(stack);
    }
    
    // Helper method to check if two numbers have different signs
    private boolean isDifferentSign(int a, int b) {
        return (a < 0 && b >= 0) || (a >= 0 && b < 0);
    }
}
