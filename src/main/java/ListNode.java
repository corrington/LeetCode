/*
 * Definition for singly-linked list
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    } // ListNode()

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    } // ListNode()


    // a utility method that converts a linked list to an int array
    public static int[] toArray(ListNode head) {
        if (head == null) return new int[0];
        // determine size of array
        ListNode node = head;
        int size = 0;
        while (node != null) {
            size++;
            node = node.next;
        } // while
        int[] values = new int[size];
        // copy elements from list into array
        node = head;
        for (int i = 0; i < size; i++, node = node.next) {
            values[i] = node.val;
        } // for i
        return values;
    } // toArray()

    // a utility method that converts an int array to a linked list.
    public static ListNode toList(int[] values) {
        if ((values == null) || (values.length == 0)) return null;

        ListNode head = null;
        ListNode node = null;
        for (var value : values) {
            if (head == null) {
                head = new ListNode(value);
                node = head;
            } else {
                node.next = new ListNode(value);
                node = node.next;
            }
        } // for
        return head;
    } // toList()

    // a utility method that converts a linked list of ints to a string
    public static String toString(ListNode head) {
        StringBuilder sb = new StringBuilder("[");
        while (head != null) {
            sb.append(head.val);
            if (head.next != null) sb.append(",");
            head = head.next;
        }
        sb.append("]");
        return sb.toString();
    } // toString

} // class ListNode
