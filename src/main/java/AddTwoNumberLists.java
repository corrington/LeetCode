/*
https://leetcode.com/problems/add-two-numbers/
You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order, and each of their nodes contains a single digit.
Add the two numbers and return the sum as a linked list.

Constraints:
You may assume the two numbers do not contain any leading zero, except the number 0 itself.
The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.

Example
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.

Example
Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
*/
public class AddTwoNumberLists {

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode aList = l1;
        ListNode bList = l2;
        ListNode sListHead = new ListNode();
        ListNode sList = sListHead;
        boolean isAdding = true;
        int carryover = 0;

        while (isAdding) {

            int aVal = (aList == null) ? 0 : aList.val;
            int bVal = (bList == null) ? 0 : bList.val;

            // add the numbers and determine if there is a carryover
            // (e.g., 9+1=10, we have to carryover the 1 to the next addition)
            int sVal = aVal + bVal + carryover;
            sList.val = (sVal % 10);
            carryover = (sVal / 10);

            // are there more digits to process?
            if (aList != null) aList = aList.next;
            if (bList != null) bList = bList.next;

            // do we have more digits in either list and/or a carryover to add?
            boolean moreToDo = (aList != null) || (bList != null) || (carryover > 0);
            if (moreToDo) {
                sList.next = new ListNode();
                sList = sList.next;
            } else {
                isAdding = false;
            } // if

        } // while

        return sListHead;

    } // addTwoNumbers()

    private static ListNode populateList(int[] values) {
        ListNode listHead = new ListNode();
        ListNode listTail = listHead;
        for (int i = 0; i < values.length; ++i) {
            listTail.val = values[i];
            if (i < (values.length - 1)) {
                listTail.next = new ListNode();
                listTail = listTail.next;
            } // if
        } // for i
        return listHead;
    } // populateList()

    public static void main(String[] args) {
        ListNode aList = populateList(new int[]{9, 9, 9, 9, 9, 9, 9});
        ListNode bList = populateList(new int[]{9, 9, 9, 9});
        ListNode sListHead = addTwoNumbers(aList, bList);

        System.out.println(aList);
        System.out.println(bList);
        System.out.println(sListHead);
    } // main()

    /**
     * Definition for singly-linked list (provided by LeetCode)
     */
    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public String toString() {
            StringBuilder str = new StringBuilder();
            str.append("[");
            ListNode index = this;
            while (index != null) {
                str.append(index.val);
                index = index.next;
                if (index != null) {
                    str.append(",");
                } // if
            } // while
            str.append("]");
            return str.toString();
        } // toString()

    } // class ListNode

} // class AddTwoNumberLists

