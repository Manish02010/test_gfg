import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

class Solution {
    public int minSteps(int[] arr, int start, int end) {
        // If start and end are already the same, 0 steps are needed
        if (start == end) {
            return 0;
        }

        // Array to store the minimum steps to reach each number from 0 to 999
        int[] steps = new int[1000];
        Arrays.fill(steps, -1);
        
        // Queue for BFS storing the numbers
        Queue<Integer> q = new LinkedList<>();
        
        // Initialize BFS with the start value
        q.add(start);
        steps[start] = 0;
        
        // Standard BFS loop
        while (!q.isEmpty()) {
            int current = q.poll();
            
            // Try multiplying current value with every element in the array
            for (int num : arr) {
                int next = (current * num) % 1000;
                
                // If the state has not been visited yet
                if (steps[next] == -1) {
                    steps[next] = steps[current] + 1;
                    
                    // If we reached the end, return the step count immediately
                    if (next == end) {
                        return steps[next];
                    }
                    
                    q.add(next);
                }
            }
        }
        
        // Return -1 if the end value is unreachable
        return -1;
    }
}
