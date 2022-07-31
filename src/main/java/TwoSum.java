import java.util.HashMap;

/*
1. Two Sum
https://leetcode.com/problems/two-sum/
Given an array of integers nums and an integer target, return indices of the two numbers
such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use
the same element twice.

You can return the answer in any order.

Example 1:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:
Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3:
Input: nums = [3,3], target = 6
Output: [0,1]

Constraints:
  2 <= nums.length <= 104
  -109 <= nums[i] <= 109
  -109 <= target <= 109
  Only one valid answer exists.


Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?
 */
public class TwoSum {

    /*
    Create a hashmap which accepts Integer datatype as key (number) and value (array index).
    Walk through the array.
    For each element, calculate the number needed (dff).  For example, if nums[0] = 5 and the target is 7,
    the difference is 2.  Now, we check the hashmap with the key of 2.
    If found, return the pair of indices in an array.
    Assuming we didn't find a match, add the current key(number)  and its value(array index) to the hashmap.
    Repeat until we find the correct pair.
    Time Complexity: O(n)
    Space Complexity: O(n)
     */
    public int[] twoSum(int[] nums, int target) {
                            // key=number, value=array index
        var hashMap = new HashMap<Integer, Integer>(nums.length);

        for (int idx = 0; idx < nums.length; idx++) {
            int num = nums[idx];
            int diff = target - num;
            if (hashMap.containsKey(diff)) {
                int[] result = {hashMap.get(diff),idx};
                return result;
            } // if
            hashMap.put(num,idx);
        } // for i

        return null;

    } // twoSum()

} // class TwoSum
