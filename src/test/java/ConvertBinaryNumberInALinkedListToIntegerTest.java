import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConvertBinaryNumberInALinkedListToIntegerTest {

    @Test
    void getDecimalValue1() {
        var obj = new ConvertBinaryNumberInALinkedListToInteger();

        var head = new ListNode(1);
        head.next = new ListNode(0);
        head.next.next = new ListNode(1);
        assertEquals(5, obj.getDecimalValue1(head));

        head = new ListNode(0);
        assertEquals(0, obj.getDecimalValue1(head));

    } // getDecimalValue1()


    @Test
    void getDecimalValue2() {
        var obj = new ConvertBinaryNumberInALinkedListToInteger();

        var head = new ListNode(1);
        head.next = new ListNode(0);
        head.next.next = new ListNode(1);
        assertEquals(5, obj.getDecimalValue2(head));

        head = new ListNode(0);
        assertEquals(0, obj.getDecimalValue2(head));

    } // getDecimalValue2()


} // class ConvertBinaryNumberInALinkedListToIntegerTest