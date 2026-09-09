class Solution {
    public int findMax(int n) {
        String s = Integer.toString(n);
        int ans = n;
        int maxSum = digitSum(n);

        char[] digits = s.toCharArray();

        // Try modifying each digit to see if it yields a larger digit sum
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] == '0') {
                continue;
            }

            // Create a candidate by decrementing the current digit
            char[] candDigits = s.toCharArray();
            candDigits[i]--;

            // Fill all subsequent digits with '9' to maximize the sum
            for (int j = i + 1; j < candDigits.length; j++) {
                candDigits[j] = '9';
            }

            int cand = Integer.parseInt(new String(candDigits));

            if (cand >= 1) {
                int cSum = digitSum(cand);

                // Track the candidate with the maximum digit sum
                if (cSum > maxSum) {
                    maxSum = cSum;
                    ans = cand;
                } else if (cSum == maxSum) {
                    ans = Math.max(ans, cand); // Tie-breaker: pick the larger number
                }
            }
        }
        return ans;
    }

    // Helper method to calculate the sum of digits of a number
    private int digitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
