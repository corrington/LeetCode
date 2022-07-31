import org.testng.annotations.Test;

import static org.testng.internal.junit.ArrayAsserts.assertArrayEquals;


public class PlusOneTest {

    @Test
    public void testPlusOne() {
        var p = new PlusOne();

        int[] nums1 = {1,2,3};
        int[] exp1 = {1,2,4};
        assertArrayEquals(exp1, p.plusOne(nums1));

        int[] nums2 = {4,3,2,1};
        int[] exp2 = {4,3,2,2};
        assertArrayEquals(exp2, p.plusOne(nums2));

        int[] nums3 = {8};
        int[] exp3 = {9};
        assertArrayEquals(exp3, p.plusOne(nums3));

        int[] nums4 = {9};
        int[] exp4 = {1,0};
        assertArrayEquals(exp4, p.plusOne(nums4));

        int[] nums5 = {9,9,9,9,9};
        int[] exp5  = {1,0,0,0,0,0};
        assertArrayEquals(exp5, p.plusOne(nums5));

    } // testPlusOne()

    @Test
    public void testPlusOne2() {
        var p = new PlusOne();

        int[] nums1 = {1,2,3};
        int[] exp1 = {1,2,4};
        assertArrayEquals(exp1, p.plusOne2(nums1));

        int[] nums2 = {4,3,2,1};
        int[] exp2 = {4,3,2,2};
        assertArrayEquals(exp2, p.plusOne2(nums2));

        int[] nums3 = {8};
        int[] exp3 = {9};
        assertArrayEquals(exp3, p.plusOne2(nums3));

        int[] nums4 = {9};
        int[] exp4 = {1,0};
        assertArrayEquals(exp4, p.plusOne2(nums4));

        int[] nums5 = {9,9,9,9,9};
        int[] exp5  = {1,0,0,0,0,0};
        assertArrayEquals(exp5, p.plusOne2(nums5));

    } // testPlusOne()

} // class PlusOneTest