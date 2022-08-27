/*
Problem 1290. Convert Binary Number in a Linked List to Integer
https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
Given head which is a reference node to a singly-linked list. The value of each node in the
linked list is either 0 or 1. The linked list holds the binary representation of a number.
Return the decimal value of the number in the linked list.
The most significant bit is at the head of the linked list.

Example 1:
    Input: head = [1,0,1]
    Output: 5
    Explanation: (101) in base 2 = (5) in base 10

Example 2:
    Input: head = [0]
    Output: 0

Constraints:
    The Linked List is not empty.
    Number of nodes will not exceed 30.
    Each node's value is either 0 or 1.
 */
public class ConvertBinaryNumberInALinkedListToInteger {

    // This solution uses StringBuilder to build up a String,
    // then converts the String to an int using radix 2.
    //  Time complexity: O(n)
    // Space complexity: O(n)
    public int getDecimalValue1(ListNode head) {
        StringBuilder sb = new StringBuilder();

        while (head != null) {
            sb.append(head.val);
            head = head.next;
        } // while

        String binaryString = sb.toString();

        return Integer.parseInt(binaryString,2);

    } // getDecimalValue1


    // This solution doesn't bother with StringBuilder or conversions.
    // It simply does the math.
    //  Time complexity: O(n)
    // Space complexity: O(1)
    public int getDecimalValue2(ListNode head) {
        int result = 0;

        while (head != null) {
            result = result * 2 + head.val;
            head = head.next;
        } // while

        return result;

    } // getDecimalValue2

} // class ConvertBinaryNumberInALinkedListToInteger