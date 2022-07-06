/*
21. Merge Two Sorted Lists
https://leetcode.com/problems/merge-two-sorted-lists/
You are given the heads of two sorted linked lists list1 and list2.
Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
Return the head of the merged linked list.

Constraints:
The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both list1 and list2 are sorted in non-decreasing order.
 */
public class MergeTwoSortedLists {

    // Make a new list that is a merger of list1 and list2.
    // This implementation leaves list1 and list2 unmodified and creates a new merged list.
    ListNode mergeTwoLists(final ListNode list1, final ListNode list2) {

        // we'll need cursors to move along the lists
        var list1Curr = list1;
        var list2Curr = list2;

        // Let's set up the merged list
        ListNode mergedListHeadDummy = new ListNode();   // creating a dummy head, which we will discard at the end
        ListNode mergedListTail = mergedListHeadDummy;

        // loop through both lists until we run out of nodes to process
        boolean merging = true;
        while(merging) {

            if ((list1Curr != null) && (list2Curr == null)) {
                // list1 has one or more nodes, but list2 is empty
                // let's just append the rest of list1 to the back of the merged list
                mergedListTail.next = dupeList(list1Curr);
                list1Curr = null;
            } else if ((list1Curr == null) && (list2Curr != null)) {
                //  list1 is empty, but list2 has one or more nodes
                // let's just append the rest of list2 to the back of the merged list
                mergedListTail.next = dupeList(list2Curr);
                list2Curr = null;

            } else if ((list1Curr != null) /* && (list2Curr != null) */) {
                // both lists have nodes to compare
                if (list1Curr.val < list2Curr.val) {
                    mergedListTail.next = new ListNode(list1Curr.val, list1Curr.next);
                    mergedListTail = mergedListTail.next;
                    list1Curr = list1Curr.next;
                } else {
                    mergedListTail.next = new ListNode(list2Curr.val, list2Curr.next);
                    mergedListTail = mergedListTail.next;
                    list2Curr = list2Curr.next;
                } // if

            } else {
                // both lists are done.
                merging = false;
            } // if

        } // while

        return mergedListHeadDummy.next;

    } // mergeTwoLists()

    // duplicate the given list and return the head of the new list
    ListNode dupeList(final ListNode list) {
        if (list == null) return null;

        ListNode oldListTail = list;

        ListNode newListHead = new ListNode(list.val);
        ListNode newListTail = newListHead;

        while (oldListTail.next != null) {
            oldListTail = oldListTail.next;
            newListTail.next = new ListNode(oldListTail.val);
            newListTail = newListTail.next;
        } // while

        return newListHead;

    } // dupeList()

    void printList(final ListNode list) {
         if (list == null) {
             System.out.println("list is empty");
             return;
         }

        ListNode listCurr = list;
        System.out.print("[");
         do {
             System.out.print(listCurr.val);
             listCurr = listCurr.next;
             if (listCurr != null) System.out.print(",");
         } while (listCurr != null);
        System.out.println("]");
    } // printList

    public static void main(String[] args) {
        var p = new MergeTwoSortedLists();

        // list must be created "backwards" in order to sorted in increasing order
        var node1c = new ListNode(4);
        var node1b = new ListNode(2, node1c);
        var list1 = new ListNode(1, node1b);

        var node2c = new ListNode(6);
        var node2b = new ListNode(5, node2c);
        var list2 = new ListNode(3, node2b);

        var mergedList = p.mergeTwoLists(list1, list2);

        node1c.val = 77;
        node1b.val = 77;
        list1.val = 77;

        node2c.val = 55;
        node2b.val = 55;
        list2.val = 55;

        System.out.print("list1 is ");
        p.printList(list1);
        System.out.print("list2 is ");
        p.printList(list2);

        System.out.print("mergedList is ");
        p.printList(mergedList);

    } // main()

} // class MergeTwoSortedLists

