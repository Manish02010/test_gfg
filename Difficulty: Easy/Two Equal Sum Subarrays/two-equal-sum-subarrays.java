class Solution {
    public boolean canSplit(int arr[]) {
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }

        // If the total sum is odd, it's impossible to split into two equal integer sums
        if (totalSum % 2 != 0) {
            return false;
        }

        int target = totalSum / 2;
        int currentSum = 0;

        for (int num : arr) {
            currentSum += num;
            if (currentSum == target) {
                return true;
            }
        }

        return false;
    }
}
