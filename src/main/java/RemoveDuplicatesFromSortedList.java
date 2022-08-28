/*
Problem 83. Remove Duplicates from Sorted List
https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 */
public class RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        ListNode currNode = head;
        ListNode nextNode = head.next;

        while (currNode.next != null) {
            if (currNode.val == nextNode.val) {
                // The current value is the same as the next one,
                // so we have to bypass the next one.
                nextNode = nextNode.next;
                currNode.next = nextNode;
            } else {
                currNode = nextNode;
                nextNode = nextNode.next;
            } // of
        } // while
        return head;
    } // deleteDuplicates()


} // class RemoveDuplicatesFromSortedList
