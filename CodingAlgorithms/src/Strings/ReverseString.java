package Strings;

public class ReverseString {
    /**
     * LeetCode334
     * Write a function that reverse a string. The input is given as an array of characters
     * Ex: [h, e, l, l, o] --> [o, l, l, e, h]
     * Iterating from left to right and copy to another array TC = O(n) and SC = O(n)
     * For SC = O(1) :  Left and right pointers, temp variable, and replace elements in array
     * TC: O(n/2)  SC:O(1)
     */

    public static void main(String[] args) {

        char[] s = {'h', 'e', 'l', 'l', 'o'};
        System.out.println(reverseString(s));

    }

    public static char[] reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        char temp;

        while (left < right) {
            temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            right--;
            left++;
        }
        return s;
    }
}
