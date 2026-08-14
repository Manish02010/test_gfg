import java.util.*;

class Solution {
    public boolean isPossible(int[] arr, int s, int x) {
        List<Integer> p = new ArrayList<>(List.of(s));
        long sum = s;
        for (int v : arr) {
            if (sum + v > x) break;
            p.add((int)(sum + v));
            sum += p.get(p.size() - 1);
        }
        for (int i = p.size() - 1; i >= 0; i--) {
            if (x >= p.get(i)) x -= p.get(i);
        }
        return x == 0;
    }
}
