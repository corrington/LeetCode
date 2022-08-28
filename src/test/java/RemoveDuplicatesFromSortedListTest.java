import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RemoveDuplicatesFromSortedListTest {

    @Test
    void deleteDuplicates() {
        var obj = new RemoveDuplicatesFromSortedList();

        assertArrayEquals(new int[] {}, ListNode.toArray(obj.deleteDuplicates(ListNode.toList(new int[] {}))));
        assertArrayEquals(new int[] {1}, ListNode.toArray(obj.deleteDuplicates(ListNode.toList(new int[] {1}))));

        assertArrayEquals(new int[] {1,2}, ListNode.toArray(obj.deleteDuplicates(ListNode.toList(new int[] {1,1,2}))));
        assertArrayEquals(new int[] {1,2}, ListNode.toArray(obj.deleteDuplicates(ListNode.toList(new int[] {1,2,2}))));
        assertArrayEquals(new int[] {1,2}, ListNode.toArray(obj.deleteDuplicates(ListNode.toList(new int[] {1,1,2,2}))));
        assertArrayEquals(new int[] {1,2}, ListNode.toArray(obj.deleteDuplicates(ListNode.toList(new int[] {1,2,2,2,2}))));
        assertArrayEquals(new int[] {1,2}, ListNode.toArray(obj.deleteDuplicates(ListNode.toList(new int[] {1,1,1,1,2}))));

        assertArrayEquals(new int[] {1,2,3}, ListNode.toArray(obj.deleteDuplicates(ListNode.toList(new int[] {1,1,2,3,3}))));
        assertArrayEquals(new int[] {1,2,3}, ListNode.toArray(obj.deleteDuplicates(ListNode.toList(new int[] {1,1,2,2,3,3}))));

    } // deleteDuplicates()

} // class RemoveDuplicatesFromSortedListTest