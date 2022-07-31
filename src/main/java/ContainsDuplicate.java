import java.util.HashSet;

/*
217. Contains Duplicate
https://leetcode.com/problems/contains-duplicate/
Given an integer array nums, return true if any value appears at least twice in the array,
and return false if every element is distinct.

Example 1:
Input: nums = [1,2,3,1]
Output: true

Example 2:
Input: nums = [1,2,3,4]
Output: false

Example 3:
Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true

Constraints:
   1 <= nums.length <= 105
   -109 <= nums[i] <= 109
 */
public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        if ((nums == null) || (nums.length <=1)) return false;

        var set = new HashSet<Integer>();

        for (var n : nums) {
            if (set.contains(n)) return true;
            set.add(n);
        } // for n

        return false;

    } // containsDuplicate()

} // class ContainsDuplicate
