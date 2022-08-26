/*
Problem 141. Linked List Cycle
https://leetcode.com/problems/linked-list-cycle/
Given head, the head of a linked list, determine if the linked list has a cycle in it.
There is a cycle in a linked list if there is some node in the list that can be reached again
by continuously following the next pointer. Internally, pos is used to denote the index of the node
that tail's next pointer is connected to. Note that pos is not passed as a parameter.
Return true if there is a cycle in the linked list. Otherwise, return false.

Example 1:
    Input: head = [3,2,0,-4], pos = 1
    Output: true
    Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).

Example 2:
    Input: head = [1,2], pos = 0
    Output: true
    Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.

Example 3:
    Input: head = [1], pos = -1
    Output: false
    Explanation: There is no cycle in the linked list.

Constraints:
    The number of the nodes in the list is in the range [0, 104].
    -105 <= Node.val <= 105
    pos is -1 or a valid index in the linked-list.

Follow up: Can you solve it using O(1) (i.e. constant) memory?
 */
import java.util.HashSet;

public class LinkedListCycle {

    // first idea was to keep track of the visited nodes in a HashSet
    //  time complexity: O(n)
    // space complexity: O(n) because of hashSet
    // runtime: 13ms, 47.5 MB of memory
    public boolean hasCycle1(ListNode head) {
        HashSet<ListNode> visitedNodes = new HashSet<>();

        ListNode node = head;

        while (node != null) {
            if (visitedNodes.contains(node)) {
                // if we've seen this node before, there is a cycle
                return true;
            } else {
                visitedNodes.add(node);
            }
            node = node.next;
        } // while

        return false;

    } // hasCycle()

    // Next idea was to have two pointers: a "slow pointers" moving forward one node at a time and
    // "fast pointer" moving twice as fast.  If the fast pointer ever catches up to the slow pointer,
    // we know there is a cycle
    //  time complexity: O(n)
    // space complexity: O(1)
    // runtime: 0ms 43.9 MB of memory
    public boolean hasCycle2(ListNode head) {
        ListNode fastNode = head;
        ListNode slowNode = head;
        while(fastNode != null && fastNode.next != null){
            slowNode = slowNode.next;           // go to the next node
            fastNode = fastNode.next.next;      // jump two nodes ahead
            if(fastNode == slowNode) {
                return true; // linked list has a cycle
            }
        } //while
        return false; // linked list has no cycle
    } // hasCycle2()


    /*
     *
     */
    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
        val = x;
        next = null;
      } // ListNode() constructor
    } // class ListNode

    public static void main(String[] args) {
        var obj = new LinkedListCycle();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        System.out.println(obj.hasCycle2(head));

        head.next.next.next = head;
        System.out.println(obj.hasCycle2(head));
    } // main()

} // class LinkedListCycle
