import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SingleNumberTest {

    @Test
    public void testSingleNumber1() {
        var p = new SingleNumber();

        int[] nums1 = {2,2,1};
        assertEquals(p.singleNumber1(nums1), 1);

        int[] nums2 = {4,1,2,1,2};
        assertEquals(p.singleNumber1(nums2), 4);

        int[] nums3 = {1};
        assertEquals(p.singleNumber1(nums3), 1);

        int[] nums4 = {1,1,2,2,3,3,4,4,5};
        assertEquals(p.singleNumber1(nums4), 5);

        int[] nums5 = {1,2,3,4,5,4,3,2,1};
        assertEquals(p.singleNumber1(nums5), 5);

    } // testSingleNumber()


    @Test
    public void testSingleNumber2() {
        var p = new SingleNumber();

        int[] nums1 = {2,2,1};
        assertEquals(p.singleNumber2(nums1), 1);

        int[] nums2 = {4,1,2,1,2};
        assertEquals(p.singleNumber2(nums2), 4);

        int[] nums3 = {1};
        assertEquals(p.singleNumber2(nums3), 1);

        int[] nums4 = {1,1,2,2,3,3,4,4,5};
        assertEquals(p.singleNumber2(nums4), 5);

        int[] nums5 = {1,2,3,4,5,4,3,2,1};
        assertEquals(p.singleNumber2(nums5), 5);

    } // testSingleNumber()


} // class SingleNumberTest