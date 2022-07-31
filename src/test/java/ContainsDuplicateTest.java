import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class ContainsDuplicateTest {

    @Test
    public void testContainsDuplicate() {
        var p = new ContainsDuplicate();

        int[] nums1 = {1,2,3,1};
        assertTrue(p.containsDuplicate(nums1));

        int[] nums2 = {1,2,3,4};
        assertFalse(p.containsDuplicate(nums2));

        int[] nums3 = {1,1,1,3,3,4,3,2,4,2};
        assertTrue(p.containsDuplicate(nums3));

        int[] nums4 = {};
        assertFalse(p.containsDuplicate(nums4));

        int[] nums5 = {1};
        assertFalse(p.containsDuplicate(nums5));

        int[] nums6 = {1,2,3,4,5,6,7,8,9,0,1};
        assertTrue(p.containsDuplicate(nums6));

    } // testContainsDuplicate()

} // class ContainsDuplicateTest