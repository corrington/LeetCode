import java.util.Arrays;

/*
LeetCode.com
53. Maximum Subarray
https://leetcode.com/problems/maximum-subarray/
Given an integer array nums, find the contiguous subarray (containing at least one number)
which has the largest sum and return its sum.

A subarray is a contiguous part of an array.

Example 1:
    Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
    Output: 6
    Explanation: [4,-1,2,1] has the largest sum = 6.

Example 2:
    Input: nums = [1]
    Output: 1

Example 3:
    Input: nums = [5,4,-1,7,8]
    Output: 23

Constraints:
    1 <= nums.length <= 105
    -104 <= nums[i] <= 104
 */
public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        System.out.println(Arrays.toString(nums));
        System.out.println("n\tcur\tmax");
        int maxSum = nums[0];
        int currSum = 0;
        for (var n : nums) {
            if (currSum < 0) {
                currSum = 0;
            }
            currSum += n;
            maxSum = Math.max(maxSum, currSum);
            System.out.println(n + "\t" + currSum + "\t" + maxSum);
        } // for n

        return maxSum;
    } // maxSubArray()

} // class MaximumSubarray