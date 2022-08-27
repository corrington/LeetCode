import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RemoveLinkedListElementsTest {

    private String stringOf(ListNode head) {
        StringBuilder sb = new StringBuilder("[");
        while (head != null) {
            sb.append(head.val);
            if (head.next != null) sb.append(",");
            head = head.next;
        } // while
        sb.append("]");
        return sb.toString();
    } // stringOf

    @Test
    void removeElements() {
        var obj = new RemoveLinkedListElements();

        var head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        assertEquals("[1,2,3,4,5]", stringOf(obj.removeElements(head, 6)));

        head = null;
        assertEquals("[]", stringOf(obj.removeElements(head, 6)));

        head = new ListNode(7);
        head.next = new ListNode(7);
        head.next.next = new ListNode(7);
        head.next.next.next = new ListNode(7);
        assertEquals("[]", stringOf(obj.removeElements(head, 7)));

    } // removeElements()
} // class RemoveLinkedListElementsTest