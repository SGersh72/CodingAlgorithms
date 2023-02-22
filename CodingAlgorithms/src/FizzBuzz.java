import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    /**
     * Given an integer n, return a String array from 1 to n
     * If a number is a multiple of 3 -> "Fizz", multiply of 5 -> "Buzz",
     * and for a multiple of both (15)  3 AND 5 -> "FizzBuzz",
     * else a String of number itself
     *
     * //TC = O(n) and SC = O(n)
     */

    public static void main(String[] args) {

        System.out.println(fizzbuzz(15));
        //[1, 2, Fizz, 4, Buzz, Fizz, 7, 8, Fizz, Buzz, 11, Fizz, 13, 14, FizzBuzz]


    }

    public static List<String> fizzbuzz(int n) {
        List<String> list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if ((i % 3 == 0) & (i % 5 == 0) ) {
                list.add("FizzBuzz");
            }
            else if (i % 3 == 0) {
                list.add("Fizz");
            }
            else if (i % 5 == 0) {
                list.add("Buzz");
            }
            else {
                list.add(Integer.toString(i));
            }
        }
        return list;
    }
}
