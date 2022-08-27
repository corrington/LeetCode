/*
203. Remove Linked List Elements
https://leetcode.com/problems/remove-linked-list-elements/
Given the head of a linked list and an integer val, remove all the nodes of the linked list
that has Node.val == val, and return the new head.

Example 1:
    Input: head = [1,2,6,3,4,5,6], val = 6
    Output: [1,2,3,4,5]
Example 2:
    Input: head = [], val = 1
    Output: []
Example 3:
    Input: head = [7,7,7,7], val = 7
    Output: []
Constraints:
    The number of nodes in the list is in the range [0, 104].
    1 <= Node.val <= 50
    0 <= val <= 50
 */

public class RemoveLinkedListElements {

    // This solution uses two pointers: the previous node and the current node.
    // They march down the list together, previous behind the current.
    // When a match is found, we update its next pointer to skip over the current matching node.
    // Near the end, we have to check the head.
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;

        // we'll skip over the head for now and come back to it at the end.
        ListNode prevNode = head;           // always one node behind the current node
        ListNode currNode = head.next;      // the current node

        while (currNode != null) {
            if (currNode.val == val) {
                // we found a match in the current node, so skip over it
                prevNode.next = currNode.next;
            } else {
                // no match, simply advance to the current node
                prevNode = currNode;
            } // if
            currNode = currNode.next;
        } // while

        // Time to check the head
        if (head.val == val) {
            head = head.next;
        } // if

        return head;

    } // removeElements()


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

} // class RemoveLinkedListElements
