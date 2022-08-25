/*
Problem 876. Middle of the Linked List
https://leetcode.com/problems/middle-of-the-linked-list/

Given the head of a singly linked list, return the middle node
of the linked list.
If there are two middle nodes, return the second middle node.

Example 1:
    Input: head = [1,2,3,4,5]
    Output: [3,4,5]
    Explanation: The middle node of the list is node 3.

Example 2:
    Input: head = [1,2,3,4,5,6]
    Output: [4,5,6]
    Explanation: Since the list has two middle nodes with values 3 and 4,
    we return the second one.

Constraints:
    The number of nodes in the list is in the range [1, 100].
    1 <= Node.val <= 100
 */
public class MiddleOfTheLinkedList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        } // ListNode()
    }

    private ListNode head;
    private ListNode tail;

    public ListNode getHead() {
        return this.head;
    } // getHead()

    // append a new node to the end of the list
    public void add(int value) {
        ListNode newNode = new ListNode(value);

        if (this.head == null) {
            this.head = newNode;
        } else {
            tail.next = newNode;
        } // if
        this.tail = newNode;
    } // add()

    public void add( int[] values) {
        for (var value : values) {
            add(value);
        } // for value
    } // add()

    public void clear() {
        ListNode node = this.head;
        while (node != null) {
            ListNode t = node.next;
            node.next = null;
            node = t;
        } // while
        this.head = null;
        this.tail = null;
    } // clear()


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        ListNode node = this.head;
        while (node != null) {
            sb.append(node.val);
            if (node.next != null) {
                sb.append(",");
            } // if
            node = node.next;
        } // while
        sb.append("]");
        return sb.toString();
    } // toString()

    // return a pointer to the middle node
    // time complexity O(n), actually O(1.5 * n)
    // space complexity O(1)
    public ListNode middleNode(ListNode head) {
        if (head == null) return null;

        // calculate the midpoint of the list
        int sizeOfList = 0;
        ListNode node = head;
        while (node != null) {
            node = node.next;
            sizeOfList++;
        } // while

        int midPoint = (sizeOfList / 2);

        // find the node at the midpoint of the list
        node = head;
        for (int i = 0; i < midPoint; i++) {
            node = node.next;
        } // for

        return node;
    } // middleNode()

    // time complexity O(n), actually O(.5 * n)
    // space complexity O(1)
    public ListNode middleNode2(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while ((fast.next != null) && (fast.next.next != null)) {
            fast = fast.next.next;
            slow = slow.next;
        } // while

        if (fast.next != null) {
            slow = slow.next;
        } // if

        return slow;
    } // middleNode()

} // class MiddleOfTheLinkedList
