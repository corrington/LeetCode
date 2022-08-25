import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumSidewayJumpsTest {

    @Test
    void testMinSideJumps() {
        var msj = new MinimumSidewayJumps();
        int expectedResult;
        int actualResult;

        System.out.println("0 1 2 3 4 5 6 7 8 9");
/*
        // Test 1
        int[] input1 = {0,1,2,3,0};
        expectedResult = 2;
        actualResult = msj.minSideJumps(input1);
        assertEquals(actualResult, expectedResult);

        // Test 2
        int[] input2 = { 0,1,1,3,3,0};
        expectedResult = 0;
        actualResult = msj.minSideJumps(input2);
        assertEquals(actualResult, expectedResult);
*/
        // Test 3
        int[] input3 = { 0,2,1,0,3,0};
        expectedResult = 2;
        actualResult = msj.minSideJumps(input3);
        assertEquals(actualResult, expectedResult);

    } // testMinSideJumps()
} // class MinimumSidewayJumpsTest