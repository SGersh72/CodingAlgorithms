package Integers;

public class FactorialTrailingZeroes {

    /**
     *LeetCode 172
     * Given an integer n, return the number of trailing zeroes in n! (in O(log(n)))
     * Intuition: A trailing zero is the rsult of multiplying a non-zero number by 10:
     * 1*10 = 10, 1*1-*10 = 100
     * also: 1 * 2 * 5 = 10 <= multiplying a non-zero number by numbers 2 * 5
     *
     * Factorial of 5: 5! = 1*2*3*4*5 = 1*2*3*2*(2*5) => one trailing zero in 120
     * Since in factorial calculations there are more 2s than 5s, keeping track of how many multiples of 5s
     * are present will indicate how many trailing zeros there are.
     *25! = 1*2*3*4*5*6*7*8*9*10*11*12*13*14*15*16*16*18*19*20*21*22*23*24*25
     *              5         10             15             20             25 => (1*5)*(2*5)*(3*5)*(4*5)*(5*5) => 6*5
     *            =>  6 trailing zeros
     * In Brute force solution: calculate the factorial, and using modulo, count last digits that are zeros
     * 10! = 1*2*3*4*5*6*7*8*9*10 = 3628800 => 2 (This might cause overflow)
     *
     * In non-brute solution, divide the number by 5:
     * 10! => 10/5 = 2, and 10/25 = 0 => 2 trailing zeros
     * n/5 + n/25 + n/125 + n/625... until the division returns 0
     * 25! => 25/5 = 5, 25/25 = 1, 25/125 = 0 => 5 + 1 = 6
     * TC: O(1), SC: O(log5(n))
    */

    public static void main(String[] args) {

        System.out.println(trailingZeroes(10)); //2
        System.out.println(trailingZeroes(5)); //1
        System.out.println(trailingZeroes(25)); //6
        System.out.println(trailingZeroes(0)); //0
    }

    public static int trailingZeroes(int n) {
        int zeroCount = 0;
        for (int i = 5; i <= n; i= i*5) {  //breaks when n < i
            zeroCount += n/i;
        }
        return zeroCount;
    }

    //Recursion uses stack internally. Using stack data structures the solution will not works in O(1) space
    public static int trailingZeroesRecursion(int n) {
        if (n == 0) {
            return 0;
        }
        return n / 5 + trailingZeroes(n / 5);
    }
}
