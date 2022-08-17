import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BinarySearchTest {

    @Test
    public void testSearch1() {
        var obj = new BinarySearch();

        assertEquals(0, obj.search1(new int[] {-1,0,3,5,9,12}, -1));
        assertEquals(1, obj.search1(new int[] {-1,0,3,5,9,12}, 0));
        assertEquals(2, obj.search1(new int[] {-1,0,3,5,9,12}, 3));
        assertEquals(3, obj.search1(new int[] {-1,0,3,5,9,12}, 5));
        assertEquals(4, obj.search1(new int[] {-1,0,3,5,9,12}, 9));
        assertEquals(5, obj.search1(new int[] {-1,0,3,5,9,12}, 12));

        assertEquals(-1, obj.search1(new int[] {-1,0,3,5,9,12}, -6)); // less than
        assertEquals(-1, obj.search1(new int[] {-1,0,3,5,9,12}, 2));  // in the middle
        assertEquals(-1, obj.search1(new int[] {-1,0,3,5,9,12}, 18)); // greater than

    } // testSearch1()


    @Test
    public void testSearch2() {
        var obj = new BinarySearch();

        assertEquals(0, obj.search2(new int[] {-1,0,3,5,9,12}, -1));
        assertEquals(1, obj.search2(new int[] {-1,0,3,5,9,12}, 0));
        assertEquals(2, obj.search2(new int[] {-1,0,3,5,9,12}, 3));
        assertEquals(3, obj.search2(new int[] {-1,0,3,5,9,12}, 5));
        assertEquals(4, obj.search2(new int[] {-1,0,3,5,9,12}, 9));
        assertEquals(5, obj.search2(new int[] {-1,0,3,5,9,12}, 12));

        assertEquals(-1, obj.search2(new int[] {-1,0,3,5,9,12}, -6)); // less than
        assertEquals(-1, obj.search2(new int[] {-1,0,3,5,9,12}, 2));  // in the middle
        assertEquals(-1, obj.search2(new int[] {-1,0,3,5,9,12}, 18)); // greater than

    } // testSearch2()

} // class BinarySearchTest