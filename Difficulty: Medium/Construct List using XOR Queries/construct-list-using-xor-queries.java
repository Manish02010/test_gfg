import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public ArrayList<Integer> constructList(int[][] queries) {
        ArrayList<Integer> result = new ArrayList<>();
        int currentXor = 0;
        
        // Process queries from right to left
        for (int i = queries.length - 1; i >= 0; i--) {
            int type = queries[i][0];
            int x = queries[i][1];
            
            if (type == 1) {
                // Accumulate the XOR value for all elements inserted before this query
                currentXor ^= x;
            } else {
                // Element x will face all subsequent XOR changes accumulated in currentXor
                result.add(x ^ currentXor);
            }
        }
        
        // Include the initial element 0, which faces all XOR operations
        result.add(0 ^ currentXor);
        
        // Sort the final list as requested
        Collections.sort(result);
        
        return result;
    }
}
