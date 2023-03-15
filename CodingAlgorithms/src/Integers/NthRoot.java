package Integers;

/**
 * Given a number (x) and a root (n), find the nth root of x. Allowed result error = 0.001
 * Ex: number x is 27, and root n is 3, the nth root of x is 3 (or with error: 2.999, or 3.001)
 * number x = 7, and root n = 3, what is the result of 7^(1/3) = 1.913
 * Binary Search Algorithm: ex. x = 27 and n = 3
 * L = 27, R = 1, Mid = (L+R)/2 = 14
 * Multiply Mid n times: 14 * 14* 14 > R => Shift R to Mid : R = 14, L = 1, Mid = 7.5
 * 7.5 * 7.5 * 7.5 > 27 => R = Mid = 7.5, L = 1, Mid = 4.25
 * 4.25 * 4.25 * 4.25 > 27 => L = 4.25, Mid = 2.625
 * 2.625 * 2.625 * 2.625 < R => L = Mid = 2.625, R = 4.25, Mid = 6.855/2 = 3.4375
 * 3.4375 * 3.4375 * 3.4375 = 14 > R => R = Mid = 3.4375, Mid = (2.625 + 3.4375)/2 = 3.03125
 * 3.03125 * 3.03125 * 3.03125 = 27.85 > 27 => R = Mid = 3.03125, Mid = (2.625 + 3.03125)/2 = 2.828125
 * 2.828125 * 2.828125 * 2.828125 = 22.62 < 27 => L = Mid = 2.828125, R = 3.03125, Mid = 2.92968
 * 2.92968 * 2.92968 * 2.92968 = 25... < 27 => L = Mid = 2.92968, R = 3.03125, Mid = 2.980
 * 2.980 * 2.980 * 2.980 = 26.4636 < 27 => L = Mid = 2.980, R = 3.03125, Mid = 3.005625
 * 3.005625 * 3.005625 * 3.005625 = 27.15 > 27 => R = Mid = 3.005625, L = 2.980, Mid = 2.9928
 * 2.9928 * 2.9928 * 2.9928 = 26.806 < 27 => L = Mid = 2.9928, R = 3.005625, Mid = 2.9992
 * L = Mid = 2.9992, R = 3.005625, Mid = 3.0024 ==> R = Mid = 3.0024, L = 2.9992, Mid = 3.0008...
 * R = Mid = 3.0008, L = 2.9992, Mid = 3   3 * 3 * 3 = 27 (Math.abs(3 - 3.0008) < 0.001)
 * The answer can be either 3 or even 3.0008 would be acceptable
 * TC = O(log2(x)), SC = O(1)
 */

public class NthRoot {

    public static void main(String[] args) {

        System.out.println(nthRoot(27.0, 3)); // 2.99951171875
        System.out.println(nthRoot(7.0, 3)); // 1.91259765625
        System.out.println(nthRoot(1000.0, 3)); // 9.999399185180664
        System.out.println(nthRoot(0.0, 3));  // 0.0
        System.out.println(nthRoot(1.0, 3)); // 1.0


    }

    public static double nthRoot(double x, int n) {
        double right = x;
        double left = 1.0;
        double error = 0.001;

        if (x == 0) return 0;

        while ((right - left) > error) {
            double mid = (right + left) / 2.0;
            if (multiply(mid, n) > x) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return left; // one can return right instead

    }

    private static double multiply(double mid, int n) {
        double result = 1.0;
        for (int i = 1; i <= n; i++) {
            result = result * mid;
        }
        return result;
    }

}
