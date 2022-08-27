/*
Problem 234. Palindrome Linked List
https://leetcode.com/problems/palindrome-linked-list/
Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
Example 1:
    Input: head = [1,2,2,1]
    Output: true
Example 2:
    Input: head = [1,2]
    Output: false
Constraints:
    The number of nodes in the list is in the range [1, 105].
    0 <= Node.val <= 9
Follow up: Could you do it in O(n) time and O(1) space?
 */


public class PalindromeLinkedList {
    /*

        If this were an array, we'd use two indexes.  One at the start of the array and one at the end.
        During each iteration, both indexes would advance towards the middle of the array and comparisons
        would be made.
        In this problem, the data structure is a singularly linked list. So, we'll need another way to
        move from the end of the list towards the start of the list. This solution uses two pointers,
        recursion, and backtracking.
        During each method call, the forwardMovingNode moves from the start of the list towards the end.
        During the first method call, recursion is used to get the head node to the end of the linked list.
        At this point, the forwardMovingNode is still at the start of the linked list and the head node is
        at the end of the linked list.  Each time callstack unwinds, the head node moves "backwards"
        (from the end of the list towards the start) WHILE the forwardMovingNode is moves "forwards" (from the
        start of the list towards the end). Each time the comparison is made.
         Time complexity: O(n)
        Space complexity: O(1)
     */
    private ListNode forwardMovingNode;

    public boolean isPalindrome2(ListNode head) {
        if (this.forwardMovingNode == null) this.forwardMovingNode = head;
        if (head == null) return true;

        boolean flag = isPalindrome2(head.next) && (head.val == this.forwardMovingNode.val);
        this.forwardMovingNode = this.forwardMovingNode.next;

        return flag;

    } // isPalindrome()

    /*
     *
     */
    public static class ListNode {
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
    } // class ListNode


    public static void main(String[] args) {
        var obj = new PalindromeLinkedList();
        PalindromeLinkedList.ListNode head = new PalindromeLinkedList.ListNode(1);
        head.next = new PalindromeLinkedList.ListNode(2);
        head.next.next = new PalindromeLinkedList.ListNode(2);
        head.next.next.next = new PalindromeLinkedList.ListNode(1);

        System.out.println(obj.isPalindrome2(head));
    } // main()

} // class PalindromeLinkedList
