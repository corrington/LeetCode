import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListNodeTest {

    @Test
    void toArray() {
        ListNode head = new ListNode(1);
        assertArrayEquals(new int[] {1}, ListNode.toArray(head));
        head.next =  new ListNode(2);
        assertArrayEquals(new int[] {1,2}, ListNode.toArray(head));
        head.next.next =  new ListNode(3);
        assertArrayEquals(new int[] {1,2,3}, ListNode.toArray(head));
    } // toArray()

    @Test
    void toList() {
        var head = ListNode.toList(new int[] {1});
        assertArrayEquals(new int[] {1}, ListNode.toArray(head));
        head = ListNode.toList(new int[] {1,2});
        assertArrayEquals(new int[] {1,2}, ListNode.toArray(head));
        head = ListNode.toList(new int[] {1,2,3});
        System.out.println(ListNode.toString(head));
        assertArrayEquals(new int[] {1,2,3}, ListNode.toArray(head));
    } // toList()

    @Test
    void testToString() {
        var head = new ListNode(1);
        assertEquals("[1]", ListNode.toString(head));
        head.next = new ListNode(2);
        assertEquals("[1,2]", ListNode.toString(head));
        head.next.next = new ListNode(3);
        assertEquals("[1,2,3]", ListNode.toString(head));
    } // testToString

} // class ListNodeTest