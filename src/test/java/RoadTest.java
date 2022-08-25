import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoadTest {

    @Test
    void testHasObstacle() {

        int[] obstacles = {0,1,2,3,0};
        Road road = new Road(obstacles);
        boolean actualResult;

        // test first step
        actualResult = road.hasObstacle(0,0, obstacles);
        assertFalse(actualResult);
        // test middle step with obstacle
        actualResult = road.hasObstacle(0,1, obstacles);
        assertTrue(actualResult);
        // test middle step without obstacle
        actualResult = road.hasObstacle(0,2, obstacles);
        assertFalse(actualResult);
        // test last step
        actualResult = road.hasObstacle(0,(obstacles.length-1), obstacles);
        assertFalse(actualResult);
    }

    @Test
    void testIsStepOutOfRange() {
        int[] obstacles = {0,1,2,3,0};
        Road road = new Road(obstacles);
        boolean actualResult;

        // test out of bounds on the left
        actualResult = road.isStepOutOfRange(-1);
        assertTrue(actualResult);
        // test in bounds in the middle
        actualResult = road.isStepOutOfRange(2);
        assertFalse(actualResult);
        // test out of bounds on the right
        actualResult = road.isStepOutOfRange(obstacles.length);
        assertTrue(actualResult);
    }


    @Test
    void testIsEndOfRoad() {
        int[] obstacles = {0,1,2,3,0};
        Road road = new Road(obstacles);
        boolean actualResult;

        // test out of bounds on the left
        actualResult = road.isEndOfRoad(-1);
        assertFalse(actualResult);
        // test in  bounds in the middle
        actualResult = road.isEndOfRoad(2);
        assertFalse(actualResult);
        // test out of bounds on the right
        actualResult = road.isEndOfRoad(obstacles.length);
        assertFalse(actualResult);
        // test at the end of the road
        actualResult = road.isEndOfRoad(obstacles.length-1);
        assertTrue(actualResult);
    }

    @Test
    void testCanMoveForward() {
        int[] obstacles = {0,1,2,3,0};
        Road road = new Road(obstacles);
        boolean actualResult;

        // test if lane is out of bounds on the top
        actualResult = road.canMoveForward(-1, 1, obstacles);
        assertFalse(actualResult);
        // test if lane is out of bounds on the bottom
        actualResult = road.canMoveForward( 3, 1, obstacles);
        assertFalse(actualResult);
        // test if step is out of bounds on the left
        actualResult = road.canMoveForward( 0, -1, obstacles);
        assertFalse(actualResult);
        // test if step is out of bounds on the right
        actualResult = road.canMoveForward( 0, obstacles.length, obstacles);
        assertFalse(actualResult);
        // test if a rock is ahead
        actualResult = road.canMoveForward( 0, 0, obstacles);
        assertFalse(actualResult);
        // test if no rocks ahead
        actualResult = road.canMoveForward( 0, 2, obstacles);
        assertTrue(actualResult);
        // test can move into finish line
        actualResult = road.canMoveForward( 0, (obstacles.length - 1), obstacles);
        assertFalse(actualResult);
    }

    @Test
    void testIsLaneOutOfRange() {
        int[] obstacles = {0,1,2,3,0};
        Road road = new Road(obstacles);
        boolean actualResult;

        // test out of bounds on the top
        actualResult = road.isLaneOutOfRange(-1);
        assertTrue(actualResult);
        // test in bounds in the middle
        actualResult = road.isLaneOutOfRange(1);
        assertFalse(actualResult);
        // test out of bounds on the bottom
        actualResult = road.isLaneOutOfRange(3);
        assertTrue(actualResult);
    }

    @Test
    void testCanMoveUpOne() {
        int[] obstacles = {0,1,2,3,0};
        Road road = new Road(obstacles);
        boolean actualResult;

        // test lane is out of bounds on top
        actualResult = road.canMoveUpOne(-1,0, obstacles);
        assertFalse(actualResult);
        // test from the top lane
        actualResult = road.canMoveUpOne(0,0, obstacles);
        assertFalse(actualResult);
        // test from the middle lane without a rock in the top lane
        actualResult = road.canMoveUpOne(1,0, obstacles);
        assertTrue(actualResult);
        // test from the middle lane with a rock in the top lane
        actualResult = road.canMoveUpOne(1,1, obstacles);
        assertFalse(actualResult);
        // test from the bottom lane without a rock in the middle lane
        actualResult = road.canMoveUpOne(2,1, obstacles);
        assertTrue(actualResult);
        // test from the bottom lane with a rock in the middle lane
        actualResult = road.canMoveUpOne(2,2, obstacles);
        assertFalse(actualResult);
        // test lane is out of bounds on bottom
        actualResult = road.canMoveUpOne(3,0, obstacles);
        assertFalse(actualResult);
    }

    @Test
    void testCanMoveUpTwo() {
        int[] obstacles = {0, 1, 2, 3, 0};
        Road road = new Road(obstacles);
        boolean actualResult;

        // lane is out of bounds on top
        actualResult = road.canMoveUpTwo(-1, 0, obstacles);
        assertFalse(actualResult);
        // can move up two from the top lane
        actualResult = road.canMoveUpTwo(0, 0, obstacles);
        assertFalse(actualResult);
        // can move up two from the middle lane
        actualResult = road.canMoveUpTwo(1, 0, obstacles);
        assertFalse(actualResult);
        // can move up two from the bottom lane with a rock in the middle, but no rock in the top lane
        actualResult = road.canMoveUpTwo(2, 2, obstacles);
        assertTrue(actualResult);
        // can move up two from the bottom lane with a rock in the top lane, but no rock in the middle
        actualResult = road.canMoveUpTwo(2, 1, obstacles);
        assertFalse(actualResult);
        // lane is out of bounds on bottom
        actualResult = road.canMoveUpTwo(3, 0, obstacles);
        assertFalse(actualResult);
    }

    @Test
    void testCanMoveDownOne() {
        int[] obstacles = {0,1,2,3,0};
        Road road = new Road(obstacles);
        boolean actualResult;

        // test lane is out of bounds on top
        actualResult = road.canMoveDownOne(-1,0, obstacles);
        assertFalse(actualResult);
        // test from the top lane with no rock in the middle
        actualResult = road.canMoveDownOne(0,3, obstacles);
        assertTrue(actualResult);
        // test from the top lane with rock in the middle
        actualResult = road.canMoveDownOne(0,2, obstacles);
        assertFalse(actualResult);
        // test from the middle lane without a rock in the bottom lane
        actualResult = road.canMoveDownOne(1,1, obstacles);
        assertTrue(actualResult);
        // test from the middle lane with a rock in the bottom lane
        actualResult = road.canMoveDownOne(1,3, obstacles);
        assertFalse(actualResult);
        // test lane is out of bounds on bottom lane
        actualResult = road.canMoveDownOne(2,0, obstacles);
        assertFalse(actualResult);
    }

    @Test
    void testCanMoveDownTwo() {
        int[] obstacles = {0, 1, 2, 3, 0};
        Road road = new Road(obstacles);
        boolean actualResult;

        // lane is out of bounds on top
        actualResult = road.canMoveDownTwo(-1, 0, obstacles);
        assertFalse(actualResult);
        // can move down two from the top lane with a rock in the middle and an open space in the bottom lane
        actualResult = road.canMoveDownTwo(0, 2, obstacles);
        assertTrue(actualResult);
        // can move down two from the top lane with a rock in the bottom lane
        actualResult = road.canMoveDownTwo(0, 3, obstacles);
        assertFalse(actualResult);
        // lane is out of bounds on bottom
        actualResult = road.canMoveDownTwo(3, 0, obstacles);
        assertFalse(actualResult);
    }

    @Test
    void testMinSideJumps() {
        System.out.println("*** Testing testMinSideJumps()");
        System.out.println("Test 1");
        int[] obstacles = {0, 1, 2, 3, 0};
        Road road = new Road(obstacles);
        int actualResult;
        int expectedResult = 0;

        actualResult = road.minSideJumps();
        assertEquals(actualResult,expectedResult);

    } // testMinSideJumps()

} // class RoadTest