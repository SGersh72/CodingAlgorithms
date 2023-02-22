import java.util.HashSet;
import java.util.Set;

public class SingleNumber {
    /**
     * LeetCode 136
     * Given a non-empty array of integers nums, every element appears twise, except for one.
     * Find the single element.
     * Implement the solution in linear time complexity and constant time space.
     */

    public static void main(String[] args) {

    }
    //brute solution
    public static Integer findSingleNum(int[] nums){
        if (nums.length == 1) {
            return nums[0];
        }
        Set<Integer> singleNumSet = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (singleNumSet.contains(nums[i])) {
                singleNumSet.remove(nums[i]);
            }
            else {
                singleNumSet.add(nums[i]);
            }
        }
        return singleNumSet.iterator().next();
    }

}
