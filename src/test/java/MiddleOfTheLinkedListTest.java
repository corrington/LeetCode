import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MiddleOfTheLinkedListTest {

    @Test
    public void MiddleNode() {
        var list = new MiddleOfTheLinkedList();
        list.add(new int[] {1,2,3,4,5});
        MiddleOfTheLinkedList.ListNode node = list.middleNode(list.getHead());
        assertEquals(node.val, 3);


        list.clear();
        list.add(new int[] {1,2,3,4,5,6});
        node = list.middleNode(list.getHead());
        assertEquals(node.val, 4);

        list.clear();
        list.add(new int[] {1,2,3});
        node = list.middleNode(list.getHead());
        assertEquals(node.val, 2);

        list.clear();
        list.add(new int[] {1,2});
        node = list.middleNode(list.getHead());
        assertEquals(node.val, 2);

        list.clear();
        list.add(new int[] {1});
        node = list.middleNode(list.getHead());
        assertEquals(node.val, 1);

        list.clear();
        list.add(new int[] {});
        node = list.middleNode(list.getHead());
        assertNull(node);

    } // MiddleNode()

    @Test
    public void MiddleNode2() {
        var list = new MiddleOfTheLinkedList();
        list.add(new int[] {1,2,3,4,5});
        MiddleOfTheLinkedList.ListNode node = list.middleNode2(list.getHead());
        assertEquals(node.val, 3);


        list.clear();
        list.add(new int[] {1,2,3,4,5,6});
        node = list.middleNode2(list.getHead());
        assertEquals(node.val, 4);

        list.clear();
        list.add(new int[] {1,2,3});
        node = list.middleNode2(list.getHead());
        assertEquals(node.val, 2);

        list.clear();
        list.add(new int[] {1,2});
        node = list.middleNode2(list.getHead());
        assertEquals(node.val, 2);

        list.clear();
        list.add(new int[] {1});
        node = list.middleNode2(list.getHead());
        assertEquals(node.val, 1);

    } // MiddleNode2()
} // class MiddleOfTheLinkedListTest