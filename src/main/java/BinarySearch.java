/*
Problem 704. Binary Search
https://leetcode.com/problems/binary-search/
Given an array of integers nums which is sorted in ascending order, and an integer target,
write a function to search target in nums. If target exists, then return its index.
Otherwise, return -1.
You must write an algorithm with O(log n) runtime complexity.

Example 1:
    Input: nums = [-1,0,3,5,9,12], target = 9
    Output: 4
    Explanation: 9 exists in nums and its index is 4

Example 2:
    Input: nums = [-1,0,3,5,9,12], target = 2
    Output: -1
    Explanation: 2 does not exist in nums so return -1

Constraints:
    1 <= nums.length <= 104
    -104 < nums[i], target < 104
    All the integers in nums are unique.
    nums is sorted in ascending order.
 */
public class BinarySearch {
    // here's a recursive solution
    private int search1(int[] nums, int target, int left, int right) {
        if (left > right) return -1; // -1 indicates target was not found

        int mid = (left + right) / 2;

        if (target < nums[mid]) {
            // search the left half of the array
            return search1(nums, target, left, mid - 1);
        } else if (target > nums[mid]) {
            // search the right half of the array
            return search1(nums, target, mid + 1, right);
        }

        return mid; // we found the target

    } // search1()

    public int search1(int[] nums, int target) {
        // System.out.println("-----------------------------");  // DEBUG
        return search1(nums, target, 0, nums.length - 1);
    } // search1()



    // here's a non-recursive solution
    public int search2(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            int mid = (left + right) / 2;

            if (target < nums[mid]) {
                // search the left half of the array
                right = mid - 1;
            } else if (target > nums[mid]) {
                // search the right half of the array
                left = mid + 1;
            } else {
                return mid; // found the target
            } // if

        } // while

        return -1; // -1 indicates target was not found

    } // search2()


} // class BinarySearch