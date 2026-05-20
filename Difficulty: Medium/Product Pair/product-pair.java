import java.util.HashSet;

class Solution {
    public boolean isProduct(int[] arr, long target) {
        HashSet<Long> seen = new HashSet<>();
        
        for (int num : arr) {
            // Handle target = 0 separately to avoid division by zero
            if (target == 0) {
                if (num == 0 && !seen.isEmpty()) {
                    return true;
                }
                if (seen.contains(0L)) {
                    return true;
                }
            } else {
                // Number cannot be zero if target is non-zero
                if (num != 0 && target % num == 0) {
                    long required = target / num;
                    if (seen.contains(required)) {
                        return true;
                    }
                }
            }
            seen.add((long) num);
        }
        
        return false;
    }
}
