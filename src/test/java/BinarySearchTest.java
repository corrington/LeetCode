import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinarySearchTest {

    @Test
    void testSearch() {
        var obj = new BinarySearch();

        assertEquals(-1, obj.search(new int[] {1}, 0));
        assertEquals(0, obj.search(new int[] {1}, 1));
        assertEquals( 0, obj.search(new int[] {1,2}, 1));
        assertEquals( 1, obj.search(new int[] {1,2}, 2));
        assertEquals( 0, obj.search(new int[] {1,2,3}, 1));
        assertEquals(1, obj.search(new int[] {1,2,3}, 2) );
        assertEquals(2, obj.search(new int[] {1,2,3}, 3));
        assertEquals(-1, obj.search(new int[] {1,2,3}, 4));
        assertEquals(-1, obj.search(new int[] {3,4,5}, 1));
        assertEquals(-1, obj.search(new int[] {1,2,3,4}, 0));
        assertEquals(0, obj.search(new int[] {1,2,3,4}, 1));
        assertEquals(1, obj.search(new int[] {1,2,3,4}, 2));
        assertEquals(2, obj.search(new int[] {1,2,3,4}, 3));
        assertEquals(3, obj.search(new int[] {1,2,3,4}, 4));
        assertEquals(-1, obj.search(new int[] {1,2,3,4}, 5));

        assertEquals(4, obj.search(new int[] {-1,0,3,5,9,12}, 9));
        assertEquals(-1, obj.search(new int[] {-1,0,3,5,9,12}, 2));
    } // testSearch()

} // class BinarySearchTest