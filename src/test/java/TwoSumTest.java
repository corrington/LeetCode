import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TwoSumTest {

    @Test
    void testTwoSum() {
        var p = new TwoSum();

        int[] nums1 = {2,7,11,15};
        int[] exp1 = {0,1};
        assertArrayEquals(p.twoSum(nums1,9), exp1);

        int[] nums2 = {3,2,4};
        int[] exp2 = {1,2};
        assertArrayEquals(p.twoSum(nums2,6), exp2);

        int[] nums3 = {3,3};
        int[] exp3 = {0,1};
        assertArrayEquals(p.twoSum(nums3,6), exp3);


    } // testTwoSum()

} // class TwoSumTest