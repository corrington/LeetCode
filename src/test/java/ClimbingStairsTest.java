import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ClimbingStairsTest {

    @Test
    public void testClimbStairs() {

        var obj = new ClimbingStairs();

        assertEquals(obj.climbStairs(0), 1);
        assertEquals(obj.climbStairs(1), 1);
        assertEquals(obj.climbStairs(2), 2);
        assertEquals(obj.climbStairs(3), 3);
        assertEquals(obj.climbStairs(4), 5);
        assertEquals(obj.climbStairs(5), 8);

    } // testClimbStairs()

} // class ClimbingStairsTest