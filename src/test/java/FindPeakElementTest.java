import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindPeakElementTest {

    @Test
     void testFindPeakElement1() {
        assertEquals(FindPeakElement.findPeakElement1(new int[] {1,2,3,1}), 2);
        assertEquals(FindPeakElement.findPeakElement1(new int[] {1,2,1,3,5,6,4}), 1);
        assertEquals(FindPeakElement.findPeakElement1(new int[] {10, 20, 30, 40, 50}), 4);
        assertEquals(FindPeakElement.findPeakElement1(new int[] {100, 80, 60, 50, 20}), 0);
    } // testFindPeakElement1()

    @Test
     void testFindPeakElement2() {
        assertEquals(FindPeakElement.findPeakElement2(new int[] {1,2,3,1}), 2);
        assertEquals(FindPeakElement.findPeakElement2(new int[] {1,2,1,3,5,6,4}), 5);
        assertEquals(FindPeakElement.findPeakElement2(new int[] {10, 20, 30, 40, 50}), 4);
        assertEquals(FindPeakElement.findPeakElement2(new int[] {100, 80, 60, 50, 20}), 0);
    } // testFindPeakElement2()

} // class FindPeakElementTest