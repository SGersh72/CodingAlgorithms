package Integers;

public class PowXN {
    /**
     * Pow(x,n) LeetCode 50
     * Implement pow(x,n), calculate x raised to the power of n
     * Example:
     * x=2, n=2 Math.pow(2, 2) = 4    x= 2.1, n = 3 => 9.261   x = 2.0, n = -1 => o.25
     * 2^14 = 16384
     * Intuition:
     * 2.0^2 = 4^1
     * answer = 1
     * while n > 0:
     * if n is divisible by 2: x = x * x and n = n / 2
     * else: answer = answer * x and n = n - 1  => the answer is 4.0
     * (2^2)^7 = 4^7           16384
     * 4^7 = 4*4^6             16384
     * 4^6 = (4^2)^3 = 16^3     4096
     * 16^3 = 16*16^2           4096
     * 16^2 = (16^2)^1 = 256     256
     * 256^1 = 256*256^0         256
     *
     * 2^(-2) = (2^2)^1 = 4^1 = 4, when there is a (-n) => 1/answer => 1/4
     * TC: O(log(n))
     */

    public static void main(String[] args) {
        System.out.println(findPow(2, 14)); // 16384.0
        System.out.println(findPow(2, -2)); // 0.25

    }

    public static double findPow(double x, int n) {
        double answer = 1.0;
        //to avoid overflow:
        long num = n;
        if (n < 0) {
            num = -1 * num; //get absolute value
        }
        while (num > 0) {
            if (num % 2 == 0) {
                x = x * x;
                num = num / 2;
            } else {
                answer = answer * x;
                num = num - 1;
            }
        }
        if (n < 0) {
            return (double) (1.0) / (double) (answer);
        }
        return answer;
    }
}
