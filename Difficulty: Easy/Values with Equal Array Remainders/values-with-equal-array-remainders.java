import java.util.Arrays;

class Solution {
    // Helper method to find the Greatest Common Divisor
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public int sameMod(int[] arr) {
        int n = arr.length;
        if (n <= 1) return -1; // Single element or empty array has infinite solutions

        // Find the minimum element
        int minEle = arr[0];
        boolean allEqual = true;
        for (int i = 1; i < n; i++) {
            if (arr[i] != minEle) {
                allEqual = false;
            }
            if (arr[i] < minEle) {
                minEle = arr[i];
            }
        }

        // If all elements are equal, there are infinitely many values of k
        if (allEqual) return -1;

        // Find the GCD of all differences (arr[i] - minEle)
        int g = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] != minEle) {
                g = gcd(g, arr[i] - minEle);
            }
        }

        // Count the number of factors of the final GCD
        int count = 0;
        for (int i = 1; i * i <= g; i++) {
            if (g % i == 0) {
                count++; // 'i' is a factor
                if (i * i != g) {
                    count++; // 'g / i' is also a distinct factor
                }
            }
        }

        return count;
    }
}
