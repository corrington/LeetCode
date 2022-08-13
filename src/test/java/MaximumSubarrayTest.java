import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MaximumSubarrayTest {

    @Test
    public void testMaxSubArray() {
        var obj = new MaximumSubarray();

        assertEquals(obj.maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}), 6);
        //assertEquals(obj.maxSubArray(new int[] {1}), 1);
        //assertEquals(obj.maxSubArray(new int[] {5,4,-1,7,8}), 23);

    } // testMaxSubArray()

} // class MaximumSubarrayTest