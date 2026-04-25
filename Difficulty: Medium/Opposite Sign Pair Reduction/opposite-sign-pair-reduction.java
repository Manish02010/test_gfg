import java.util.*;

class Solution {
    public ArrayList<Integer> reducePairs(int[] arr) {
        Stack<Integer> stack = new Stack<>();

        for (int current : arr) {
            boolean currentDestroyed = false;

            // Check for opposite signs: (stack top > 0 and current < 0) or (stack top < 0 and current > 0)
            while (!stack.isEmpty() && ((stack.peek() > 0 && current < 0) || (stack.peek() < 0 && current > 0))) {
                int top = stack.pop();
                int absTop = Math.abs(top);
                int absCurrent = Math.abs(current);

                if (absTop > absCurrent) {
                    // Top wins, put it back, current is gone
                    stack.push(top);
                    currentDestroyed = true;
                    break; 
                } else if (absCurrent > absTop) {
                    // Current wins, it stays to fight the next element in the stack
                    currentDestroyed = false; 
                } else {
                    // Both equal, both destroyed
                    currentDestroyed = true;
                    break;
                }
            }

            if (!currentDestroyed) {
                stack.push(current);
            }
        }

        return new ArrayList<>(stack);
    }
}
