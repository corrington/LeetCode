/*
Problem 66. Plus One
https://leetcode.com/problems/plus-one/

You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.

Increment the large integer by one and return the resulting array of digits.

Example 1:
Input: digits = [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Incrementing by one gives 123 + 1 = 124.
Thus, the result should be [1,2,4].

Example 2:
Input: digits = [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
Incrementing by one gives 4321 + 1 = 4322.
Thus, the result should be [4,3,2,2].

Example 3:
Input: digits = [9]
Output: [1,0]
Explanation: The array represents the integer 9.
Incrementing by one gives 9 + 1 = 10.
Thus, the result should be [1,0].

Constraints:
   1 <= digits.length <= 100
   0 <= digits[i] <= 9
   digits does not contain any leading 0's.
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        if (digits.length == 0) return digits;
        // side effect: this method may or may not change the elements
        // in the original array of digits.  I'm not a fan of this approach.
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int temp = digits[i] + carry;
            carry = temp / 10;
            digits[i] = temp % 10;

            // an optimization
            // For example, if we are given {5,6,7}, we add 1 to 7 and we are done.
            // Since there is no carry value, there is no reason to process the 5 and 6.
            // If we are given {7,8,9}, then we need only process, the 9, then the 8,
            // and we're done.  No need to process the 7 b/c we have a zero carry.
            if (carry == 0) return digits;
        } // for i

        // if our number of digits increased (because of a final carry)
        // we need to create a new array that is one element larger,
        // copy over the digits from the original array and tack on the carry.
        if (carry > 0) {
            int[] newDigits = new int[digits.length + 1];
            for (int i = 0; i < digits.length; i++) {
                newDigits[i+1] = digits[0];
            } // for i
            newDigits[0] = carry;
            return newDigits;
        } // if

        return digits;

    } // plusOne1()

    public int[] plusOne2(final int[] digits) {
        if (digits.length == 0) return digits;
        // Treats the original array of digits as immutable (read-only)
        // This solution is less efficient. It's the price we pay for immutability.
        int[] newDigits = new int[digits.length];
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int temp = digits[i] + carry;
            carry = temp / 10;
            newDigits[i] = temp  % 10;

            // note, we don't have the zero carry optimization from the first solution,
            // because we have to copy all the digits from the original array into the
            // new digits array. Yeah, we're making some necessary calculations, but
            // they are not a big waste of time.
        } // for i

        // If our number of digits increased (because of a final carry)
        // we need to create a new array that is one element larger,
        // copy over the digits from the original array and tack on the carry.
        if (carry > 0) {
            int[] newBiggerDigits = new int[newDigits.length + 1];
            for (int i = 0; i < newDigits.length; i++) {
                newBiggerDigits[i+1] = newDigits[0];
            } // for i
            newBiggerDigits[0] = carry;
            newDigits = newBiggerDigits;
        } // if

        return newDigits;

    } // plusOne2()

} // class PlusOne