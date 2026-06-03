import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;

class Solution {
    public ArrayList<Integer> freqInRange(int[] arr, int[][] queries) {
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        
        // Store all indices for each element
        for (int i = 0; i < arr.length; i++) {
            map.putIfAbsent(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }
        
        // Process each query
        for (int[] query : queries) {
            int l = query[0];
            int r = query[1];
            int x = query[2];
            
            if (!map.containsKey(x)) {
                result.add(0);
                continue;
            }
            
            ArrayList<Integer> indices = map.get(x);
            
            // Find the count of indices between l and r using binary search
            int count = countRange(indices, l, r);
            result.add(count);
        }
        
        return result;
    }
    
    private int countRange(ArrayList<Integer> list, int l, int r) {
        int leftBound = upperRightBound(list, r);
        int rightBound = lowerLeftBound(list, l);
        return leftBound - rightBound;
    }
    
    // Finds the first position strictly greater than r
    private int upperRightBound(ArrayList<Integer> list, int target) {
        int low = 0, high = list.size();
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (list.get(mid) <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
    
    // Finds the first position greater than or equal to l
    private int lowerLeftBound(ArrayList<Integer> list, int target) {
        int low = 0, high = list.size();
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (list.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
