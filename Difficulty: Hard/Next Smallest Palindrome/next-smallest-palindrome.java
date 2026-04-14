import java.util.Arrays;

 class Solution {
    public int[] nextPalindrome(int[] num) {
        int n = num.length;
        
        // Check if the number is all 9s
        boolean allNines = true;
        for (int d : num) {
            if (d != 9) {
                allNines = false;
                break;
            }
        }
        
        // Case: All 9s (e.g., 999 -> 1001)
        if (allNines) {
            int[] ans = new int[n + 1];
            ans[0] = 1;
            ans[n] = 1;
            // Middle elements are already 0 by default in Java
            return ans;
        }

        int[] res = num.clone();
        int mid = n / 2;
        int i = mid - 1;
        int j = (n % 2 == 0) ? mid : mid + 1;

        // Mirror left to right
        while (i >= 0) {
            res[j++] = res[i--];
        }

        // If mirrored is larger, we're done
        if (isLarger(res, num)) return res;

        // Otherwise, increment middle and propagate carry
        incrementMiddle(res);
        return res;
    }

    private boolean isLarger(int[] res, int[] original) {
        for (int i = 0; i < res.length; i++) {
            if (res[i] > original[i]) return true;
            if (res[i] < original[i]) return false;
        }
        return false;
    }

    private void incrementMiddle(int[] res) {
        int n = res.length;
        int mid = (n - 1) / 2;
        int i = mid;
        int j = (n % 2 == 0) ? mid + 1 : mid;

        while (i >= 0) {
            if (res[i] < 9) {
                res[i]++;
                res[j] = res[i];
                return;
            } else {
                res[i] = 0;
                res[j] = 0;
                i--;
                j++;
            }
        }
    }
}
