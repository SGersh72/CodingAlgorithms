package Integers;

/**
 * LeetCode 9
 * A Palindrome is read equally forwards and backwards (121, 1221, or סוס)
 * Return true if the number is a palindrome and false if it isn't.
 *
 * If the input is an integer, reverse the integer and test equality. Conditions:
 * If input integer ends with 0, but integer's length is not 0 it is not a palindrome
 * (0 is OK, but not 10, or 1000).
 * Also -121 is not a palindrome, due to the minus sign (-121 vs. 121-).
 */

public class PalindromNumber {

    public static void main(String[] args) {

//        int[] nums1 = {1, 2, 1};
//        int[] nums2 = {1, 2, 2, 1};
//        int[] nums3 = {1, 2, 3};
//        int[] nums4 = {1, 2, 3, 1};
//        System.out.println(isPalindrom(nums1));
//        System.out.println(isPalindrom(nums2));
//        System.out.println(isPalindrom(nums3));
//        System.out.println(isPalindrom(nums4));

//        System.out.println(isPalindrome(101)); //t
//        System.out.println(isPalindrome(1001)); //t
//        System.out.println(isPalindrome(1010)); //f
//        System.out.println(isPalindrome(0)); //t
//        System.out.println(isPalindrome(-101));//f

        System.out.println(isPalindromeNoOverflow(101)); //t
        System.out.println(isPalindromeNoOverflow(1001)); //t
        System.out.println(isPalindromeNoOverflow(1010)); //f
        System.out.println(isPalindromeNoOverflow(0)); //t
        System.out.println(isPalindromeNoOverflow(-101));//f

    }

    //Reversing the entire number is not the best approach, because for a large integer it may cause overflow:
    //An integer variable's value gets larger than the maximum value the variable can hold.
    // (To handle that see ReverseInteger:) TC: log(n)
    public static boolean isPalindrome(int n) {
        if (n % 10 == 0 && n != 0 || n < 0) return false;
        int toCompare = n;
        int reversed = 0;
        int lastDigit;
        while(n > 0) { // risk of overflow
            lastDigit = n % 10;
            reversed = (reversed * 10) + lastDigit;
            n = n / 10;
        }
        return toCompare == reversed;
    }

    //To avoid the overflow issue, reverse just a half of the integer, and compare that to the second half:
    // 1221 => 12 and 21(=> reversed as 12)  => n == reversed: 12 == 12 => true
    //while n > reversed (if n = 12321, n = 12 & reversed = 123 => n < r => r/10 gets rid of the last digit 3
    // => n == reversed/10: n = 12 and r = 123/10 = 12 => true) TC: O(log(n/2)), SC: O(1)

    public static boolean isPalindromeNoOverflow(int n) {
        //If a negative number, or a multiply of ten (and not a zero)
        if (n < 0 || (n % 10 == 0 && n != 0)) {
            return false;
        }
        int reversed = 0;
        int num = n;
        while (num > reversed) {  // no risk of overflow
            int lastDigit = num % 10;
            reversed = reversed * 10 + lastDigit;
            num = num/10;
            /*
            121: num = 1 and reverse = 12 => for odd numbers, remove last digit from r: n==r/10
            1221 num = 12 and reversed = 12 n==r
             */
        }
        return num == reversed || num == (reversed/10);

    }

    //
    public static boolean isPalindrom(int[] palindromArray) {
        int start = 0;
        int end = palindromArray.length - 1;

        while(start < end) {
            if (palindromArray[start] != palindromArray[end]) {
                return false;
            }
            start +=1;
            end -=start;
        }
        return true;
    }




}
