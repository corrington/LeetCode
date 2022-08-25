import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HouseRobberTest {

    @Test
     void testRob() {
        var obj = new HouseRobber();

        assertEquals(obj.rob(new int[] {2,1,1,2}), 4);
        assertEquals(obj.rob(new int[] {1}), 1);
        assertEquals(obj.rob(new int[] {1,2}), 2);
        assertEquals(obj.rob(new int[] {1,9,2}), 9);
        assertEquals(obj.rob(new int[] {1,0,2}), 3);
        assertEquals(obj.rob(new int[] {1,2,3,1}), 4);
        assertEquals(obj.rob(new int[] {2,7,9,3,1}), 12);

    } // testRob()

} // class HouseRobberTest