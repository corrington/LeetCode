import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClimbingStairsTest {

    @Test
     void testClimbStairs() {

        var obj = new ClimbingStairs();

        assertEquals(1, obj.climbStairs(0));
        assertEquals(1, obj.climbStairs(1));
        assertEquals(2, obj.climbStairs(2));
        assertEquals(3, obj.climbStairs(3));
        assertEquals(5, obj.climbStairs(4));
        assertEquals(8, obj.climbStairs(5));

    } // testClimbStairs()

} // class ClimbingStairsTest