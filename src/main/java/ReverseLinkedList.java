/*
Problem 206. Reverse Linked List
https://leetcode.com/problems/reverse-linked-list/
Given the head of a singly linked list, reverse the list, and return the reversed list.
Example 1:
    Input: head = [1,2,3,4,5]
    Output: [5,4,3,2,1]
Example 2:
    Input: head = [1,2]
    Output: [2,1]
Example 3:
    Input: head = []
    Output: []
Constraints:
    The number of nodes in the list is the range [0, 5000].
    -5000 <= Node.val <= 5000
 */

public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode prevNode = null;
        ListNode currNode = head;

        while (currNode != null) {
            ListNode nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        } // while

        return prevNode;

    } // reverseList()


    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    } // class ListNode

} // class ReverseLinkedList