/*
136. Single Number
https://leetcode.com/problems/single-number/

Given a non-empty array of integers nums, every element appears twice except for one.
Find that single one.

You must implement a solution with a linear runtime complexity and use only constant
extra space.

Example 1:
Input: nums = [2,2,1]
Output: 1

Example 2:
Input: nums = [4,1,2,1,2]
Output: 4

Example 3:
Input: nums = [1]
Output: 1

Constraints:
    1 <= nums.length <= 3 * 104
    -3 * 104 <= nums[i] <= 3 * 104
Each element in the array appears twice except for one element which appears only once.
 */

import java.util.HashMap;

public class SingleNumber {

    // My initial solution used a hashMap
    public int singleNumber1(int[] nums) {
        if (nums.length == 1) return nums[0];

        // create a hashMap so we can keep track of how many times
        // we encounter each number
                            // <key=number, value=count>
        var hashMap = new HashMap<Integer,Integer>((nums.length / 2) + 1);

        // walk through the array of numbers and increase the count each time
        // we encounter the number
        for (int num : nums) {
            int count = hashMap.getOrDefault(num,0) + 1;
            hashMap.put(num,count);
        } // for num

        // look through our hashmap to find the single number
        // (the only number with a count of one)
        for (var entry : hashMap.entrySet()) {
            if (entry.getValue() == 1)
                return entry.getKey();
        } // for entry

        return 0;

    } // singleNumber1()


    // Then I found a more efficient solution on the internet...
    // https://www.studytonight.com/java-examples/xor-operator-in-java
    // Embarrassing and educational  =)
    public int singleNumber2(int[] nums) {
        int result = 0;
        for(int i : nums){
            result ^= i;
        }
        return result;
    } // singleNumber2()

} // class SingleNumber
