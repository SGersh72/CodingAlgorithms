package Strings;

public class LongestCommonPrefix {
    /**
     * LeetCode 14
     * Write a function to find the longest common prefix string amongst an array of strings.
     * If there is no common prefix, return an empty string.
     * Ex: ["flower", "flow", "flight"] => return "fl"
     * Algorithm:
     * 1) Assign the arr[0] (flower) to the variable prefix
     * 2) examine whether arr[1] (flow) is equal to prefix (flower). If not, omit the last char (flowe) from
     * the prefix and repeat the test-> (flow, omitted 'e','r') ->
     * 3) repeat the test for the other elements in the array, with the shortened prefix (flight) -> "fl"
     */

    public static void main(String[] args) {

        String[] srtingArray1 = {"axonk", "axonk", "axnl"};
        String[] srtingArray2 = {"axo", "bonk", "anl"};

        System.out.println(longestCommonPrefix(srtingArray2));

    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";

            String prefix = strs[0];
            for (int i = 1; i < strs.length; i++) {
                while (strs[i].indexOf(prefix) != 0) {
                    prefix = prefix.substring(0, prefix.length() - 1);
                    if (prefix.isEmpty()) return "";
                }

                }
            return  "\"" + prefix + "\"";
            }
}
