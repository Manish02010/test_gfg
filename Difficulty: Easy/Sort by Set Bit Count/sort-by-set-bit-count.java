import java.util.*;

class Solution {
    public ArrayList<Integer> sortBySetBitCount(int[] arr) {
        // Create 32 buckets (max bits for a 32-bit integer)
        List<List<Integer>> buckets = new ArrayList<>(32);
        for (int i = 0; i <= 31; i++) {
            buckets.add(new ArrayList<>());
        }

        // Stability: Iterate original array and group by bit count
        for (int num : arr) {
            int count = Integer.bitCount(num);
            buckets.get(count).add(num);
        }

        // The driver code expects an ArrayList as the return value
        ArrayList<Integer> result = new ArrayList<>();
        
        // Build the result from 31 down to 0 (descending bit count)
        for (int i = 31; i >= 0; i--) {
            result.addAll(buckets.get(i));
        }

        return result;
    }
}
