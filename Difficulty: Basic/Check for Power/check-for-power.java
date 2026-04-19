class Solution {
   
        // code herepublic class PowerChecker {
    public static boolean isPower(int x, int y) {
        // 1 raised to any power is always 1
        if (x == 1) {
            return y == 1;
        }

        long power = 1;
        while (power < y) {
            power *= x;
        }

        return power == y;
    }

    public static void main(String[] args) {
        System.out.println(isPower(2, 8));           // true
        System.out.println(isPower(1, 8));           // false
        System.out.println(isPower(46, 205962976));  // true
        System.out.println(isPower(50, 312500000)); // true
    }

        
    
}