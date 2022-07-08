import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class RemoveDuplicatesFromSortedArrayTest {

    @Test
    public void testRemoveDuplicates() {
        var p = new RemoveDuplicatesFromSortedArray();

        int[] input1 = {};
        assertEquals(p.removeDuplicates(input1), 0);
        int[] input2 = {1};
        assertEquals(p.removeDuplicates(input2), 1);
        int[] input3 = {1,2};
        assertEquals(p.removeDuplicates(input3), 2);
        int[] input4 = {1,2,3};
        assertEquals(p.removeDuplicates(input4), 3);
        int[] input5 = {1,1,1,2,3};
        assertEquals(p.removeDuplicates(input5), 3);
        int[] input6 = {1,2,3,3,3};
        assertEquals(p.removeDuplicates(input6), 3);
        int[] input7 = {1,2,2,2,3};
        assertEquals(p.removeDuplicates(input7), 3);
        int[] input8 = {1,1,1,2,2,2,3,3,3};
        assertEquals(p.removeDuplicates(input8), 3);
        int[] input9 = {1,1,1,2,3,3,4,5,5,5,6,7};
        assertEquals(p.removeDuplicates(input9), 7);
        int[] input10 = {1,1,1,2,3,3,3,4,5,5,5,5,6,7,7,7,7,7,8,9,9,9,9,9,9};
        assertEquals(p.removeDuplicates(input10), 9);


    } // testRemoveDuplicates()
} // class RemoveDuplicatesFromSortedArrayTest