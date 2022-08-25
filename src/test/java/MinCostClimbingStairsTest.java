import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinCostClimbingStairsTest {

    @Test
    void testMinCostClimbingStairs() {
        var obj = new MinCostClimbingStairs();

        assertEquals(obj.minCostClimbingStairs(new int[] {10,15,20}), 15);
        assertEquals(obj.minCostClimbingStairs(new int[] {1,100,1,1,1,100,1,1,100,1}), 6);
        assertEquals(obj.minCostClimbingStairs(new int[] {10,11}), 10);
        assertEquals(obj.minCostClimbingStairs(new int[] {11,10}), 10);
    } // testMinCostClimbingStairs()

} // class MinCostClimbingStairsTest