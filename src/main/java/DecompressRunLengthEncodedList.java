/*
Problem 1313. Decompress Run-Length Encoded List
https://leetcode.com/problems/decompress-run-length-encoded-list/
We are given a list nums of integers representing a list compressed with run-length encoding.

Consider each adjacent pair of elements [freq, val] = [nums[2*i], nums[2*i+1]] (with i >= 0).
For each such pair, there are freq elements with value val concatenated in a sublist.
Concatenate all the sublists from left to right to generate the decompressed list.
Return the decompressed list.

Example 1:
    Input: nums = [1,2,3,4]
    Output: [2,4,4,4]
    Explanation: The first pair [1,2] means we have freq = 1 and val = 2 so we generate the array [2].
    The second pair [3,4] means we have freq = 3 and val = 4 so we generate [4,4,4].
    At the end the concatenation [2] + [4,4,4] is [2,4,4,4].

Example 2:
    Input: nums = [1,1,2,3]
    Output: [1,3,3]

Constraints:
    2 <= nums.length <= 100
    nums.length % 2 == 0
    1 <= nums[i] <= 100
 */
import java.util.ArrayList;

public class DecompressRunLengthEncodedList {

    public int[] decompressRLEList1(int[] nums) {
        var decompressedArrayList = new ArrayList<Integer>();

        for (int i = 0; i < nums.length; i += 2) {
            int freq = nums[i];
            int value = nums[i+1];
            for (int f = 0; f < freq; f++) {
                decompressedArrayList.add(value);
            } // for c
        } // for i

        int[] decompressedList = new int[decompressedArrayList.size()];
        for (int i = 0; i < decompressedArrayList.size(); i++ ) {
            decompressedList[i] = decompressedArrayList.get(i);
        } // for i

        return decompressedList;
    } // decompressRLEList1()


    // This solution follows the same basic approach, but abandons the ArrayList for a simple array.
    // Time is a little faster and space is a little less b/c we don't have the conversion overhead.
    public int[] decompressRLEList2(int[] nums) {

        // Sum the frequencies so we can determine the size
        // of the int array we'll need for the decompressed values
        int numOfDecompressedElements = 0;
        for (int i = 0; i < nums.length; i += 2) {
            numOfDecompressedElements += nums[i];  // freq
        } // for i

        int[] decompressedList = new int[ numOfDecompressedElements ];

        // Now, decompress the Run-Length Encoded List [freq,val]
        int decompressedListIndex = 0;
        for (int i = 0; i < nums.length; i += 2) {
            int freq = nums[i];
            int value = nums[i+1];
            for (int f = 0; f < freq; f++) {
                decompressedList[ decompressedListIndex++ ] = value;
            } // for
        } // for i

        return decompressedList;
    } // decompressRLEList2()

} // class DecompressRunLengthEncodedList