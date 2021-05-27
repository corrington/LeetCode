public class LinkedList {

    Node head;

    public LinkedList() {
        head = null;
    } // LinkedList()

    public void append(int data) {
        // if we don't have a list yet, create the first node and we're done.
        if (head == null) {
            head = new Node(data);
            return;
        }

        // if we have a list, navigate to the end of the list and add a new node there
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = new Node(data);

    } // append()

    public void prepend(int data) {
        // if we don't have a list yet, create the first node and we're done.
        if (head == null) {
            head = new Node(data);
            return;
        } // if

        var newFirstNode = new Node(data);
        newFirstNode.next = head;
        head = newFirstNode;

    }  // prepend()

    public void deleteFirstOccurrence(int data) {
        // Special cass: If we have no list, we're done.
        if (head == null) {
            return;
        } // if

        // Special case: If the first node in the list is a match,
        // we simply update head point to the next node in the list.
        if (head.data == data) {
            head = head.next;
            return;
        } // if

        // Walk through the rest of the list and "bypass" each node
        // that contains matching data.
        Node curr = head;
        while (curr.next != null) {
            if (curr.next.data == data) {
                curr.next = curr.next.next;
                return;
            } // if
            curr = curr.next;
        } // while

    } // deleteWithValue()

    public void clear() {
            head = null;
    } // clear()

    public String toString() {
        if (head == null) return "";

        StringBuilder sb = new StringBuilder();
        sb.append("[");

        Node curr = head;
        while (curr != null) {
            sb.append(curr.data);
            if (curr.next != null) {
                sb.append(",");
            }
            curr = curr.next;
        } // while
        sb.append("]");

        String str = sb.toString();
        return str;

    } // toString()

    private class Node {
        Node next;
        int data;

        Node(int data) {
            next = null;
            this.data = data;
        }
    } // class Node

} // class LinkedList
