import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecompressRunLengthEncodedListTest {

    @Test
    void decompressRLEList1() {
        var obj = new DecompressRunLengthEncodedList();

        assertArrayEquals(new int[] {2,4,4,4}, obj.decompressRLEList1(new int[] {1,2,3,4}));
        assertArrayEquals(new int[] {1,3,3}, obj.decompressRLEList1(new int[] {1,1,2,3}));
        assertArrayEquals(new int[] {}, obj.decompressRLEList1(new int[] {}));
        assertArrayEquals(new int[] {1,1,1,1,1}, obj.decompressRLEList1(new int[] {5,1}));
    } // decompressRLElist1()

    @Test
    void decompressRLEList2() {
        var obj = new DecompressRunLengthEncodedList();

        assertArrayEquals(new int[] {2,4,4,4}, obj.decompressRLEList2(new int[] {1,2,3,4}));
        assertArrayEquals(new int[] {1,3,3}, obj.decompressRLEList2(new int[] {1,1,2,3}));
        assertArrayEquals(new int[] {}, obj.decompressRLEList2(new int[] {}));
        assertArrayEquals(new int[] {1,1,1,1,1}, obj.decompressRLEList2(new int[] {5,1}));
    } // decompressRLElist2()

} // class DecompressRunLengthEncodedListTest