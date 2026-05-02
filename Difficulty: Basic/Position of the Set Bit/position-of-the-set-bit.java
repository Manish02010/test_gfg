class Solution {
    public int findPosition(int n) {
        // A number with exactly one set bit must be greater than 0
        // and satisfy the condition (n & (n - 1)) == 0.
        if (n <= 0 || (n & (n - 1)) != 0) {
            return -1;
        }

        int position = 1;
        // Shift bits to the right until the set bit reaches the LSB
        while (n > 1) {
            n >>= 1;
            position++;
        }

        return position;
    }
}
