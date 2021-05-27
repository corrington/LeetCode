import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MinimumSidewayJumps2Test {

    @Test
    public void testMinSideJumps() {
        var msj = new MinimumSidewayJumps2();
        int expectedResult;
        int actualResult;

        // Test 1
        System.out.println("** Test 1");
        int[] input1 = {0,1,2,3,0};
        expectedResult = 0; // TODO: should be 2
        actualResult = msj.minSideJumps(input1);
        assertEquals(actualResult, expectedResult);

        // Test 2
        System.out.println("\n** Test 2");
        int[] input2 = { 0,1,1,3,3,0};
        expectedResult = 0;
        actualResult = msj.minSideJumps(input2);
        assertEquals(actualResult, expectedResult);

        // Test 3
        System.out.println("\n** Test 3");
        int[] input3 = { 0,2,1,0,3,0};
        expectedResult = 0; // TODO: should be 2
        actualResult = msj.minSideJumps(input3);
        assertEquals(actualResult, expectedResult);

    } // testMinSideJumps()

} // class MinimumSidewayJumps2Test