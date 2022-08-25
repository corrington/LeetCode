import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LinkedListTest {

    @Test
     void testPrepend() {
        LinkedList list;
        String result;

        // empty list
        list = new LinkedList();
        list.prepend(4);
        result = list.toString();
        assertEquals(result, "[4]");
        list.clear();

        // populated list
        list = new LinkedList();
        list.append(5);
        list.prepend(4);
        result = list.toString();
        assertEquals(result, "[4,5]");
        list.clear();

        // populated list
        list = new LinkedList();
        list.append(5);
        list.append(6);
        list.append(7);
        list.prepend(4);
        result = list.toString();
        assertEquals(result, "[4,5,6,7]");
        list.clear();

    } //  testPrepend()

    @Test
     void testDeleteFirstOccurrence() {
        LinkedList list;
        String result;

        // null

        // beginning
        list = new LinkedList();
        list.append(5);
        list.append(6);
        list.append(7);
        list.append(8);
        list.deleteFirstOccurrence(5);
        result = list.toString();
        assertEquals(result, "[6,7,8]");
        list.clear();

        // middle
        list = new LinkedList();
        list.append(5);
        list.append(6);
        list.append(7);
        list.append(8);
        list.deleteFirstOccurrence(6);
        result = list.toString();
        assertEquals(result, "[5,7,8]");
        list.clear();

        // end
        list = new LinkedList();
        list.append(5);
        list.append(6);
        list.append(7);
        list.append(8);
        list.deleteFirstOccurrence(8);
        result = list.toString();
        assertEquals(result, "[5,6,7]");
        list.clear();

        // value not found
        list = new LinkedList();
        list.append(5);
        list.append(6);
        list.append(7);
        list.append(8);
        list.deleteFirstOccurrence(4);
        result = list.toString();
        assertEquals(result, "[5,6,7,8]");
        list.clear();

        // multiple
        list = new LinkedList();
        list.append(5);
        list.append(6);
        list.append(7);
        list.append(6);
        list.append(8);
        list.append(6);
        list.deleteFirstOccurrence(6);
        result = list.toString();
        assertEquals(result, "[5,7,6,8,6]");
        list.clear();

    } // testDeleteWithValue()

} // class LinkedListTest