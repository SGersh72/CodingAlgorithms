public class ReverseInteger {
    /**
     * LeetCode 7
     * Given a signed 32-bit integer x, return x with its digits reversed.
     * If reversing x causes it to go outside the signed 32-bit integer range, return 0.
     *
     * Note: The (-) sign follow
     *
     */

    public static void main(String[] args) {

        //Because the condition starts at MIN or MAX_VALUE / 10, r == MIN or r == MAX returns 0
        System.out.println(reverseInt(Integer.MAX_VALUE)); // 0
        System.out.println(reverseInt(Integer.MAX_VALUE + 1)); // 0
        System.out.println(reverseInt(Integer.MIN_VALUE)); // 0
        System.out.println(reverseInt(Integer.MIN_VALUE -1)); // 0
        System.out.println(reverseInt(123456789));  // 987654321
        System.out.println(reverseInt(-123456789));  // -987654321
    }

    //TC: O(log n), SC: O(1)

    public static int reverseInt(int x) {
        int reversed = 0;

        while(x != 0) {  // since x can be less than 0
            //Get the last digit
            int lastDigit = x % 10;
            //Test that reverse is in range, before the last digit + the last digit
            // MAX_VALUE == 2147483647
            if (reversed > Integer.MAX_VALUE/10 || (reversed == Integer.MAX_VALUE/10 && lastDigit > 7)) {
                return 0;
            }
            // MIN_VALUE == - 2147483648
            if (reversed < Integer.MIN_VALUE/10 || (reversed == Integer.MIN_VALUE/10 && lastDigit < -8)) {
                return 0;
            }
            //Append last digit
            reversed = reversed * 10 + lastDigit;

            //remove last digit from x
            x = x / 10;
        }
        return reversed;
    }
}