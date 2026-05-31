class Solution {
    public boolean isSumOfConsecutive(int n) {
        // If n is a power of 2, (n & (n - 1)) will be 0.
        // We want to return true if it is NOT a power of 2.
        return (n & (n - 1)) != 0;
    }
}
