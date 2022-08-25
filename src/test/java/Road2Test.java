import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Road2Test {

    @Test
    void testCanMoveForward() {
        int[] obstacles1 = {0, 0, 2, 0};
        var road = new Road2(obstacles1);
        boolean actualResults;
        Position p1, p2;

        // TEST 1
        // can we move into open space?
        actualResults = road.canMoveForward();
        assertTrue(actualResults);

        // TEST 2
        // can't move forward into a rock
        int[] obstacles2 = {0, 2, 0};
        road = new Road2(obstacles2);
        actualResults = road.canMoveForward();
        assertFalse(actualResults);

        // TEST 3
        // can move into finish line
        int[] obstacles3 = {0, 0, 0};
        road = new Road2(obstacles3);
        road.moveForward();
        actualResults = road.canMoveForward();
        assertTrue(actualResults);

    } // testCanMoveForward()

    @Test
    void testMoveForward() {
        int[] obstacles1 = {0, 0, 2, 0};
        var road = new Road2(obstacles1);
        boolean actualResults;
        Position p1, p2;

        // TEST 1
        // can move forward into open space
        p1 = road.getCurrentPosition();
        road.moveForward();
        p2 = road.getCurrentPosition();
        assertNotEquals(p1, p2);

        // TEST 2
        // when you try to move forward into a rock,
        // the move fails and you're returned the original pos
        p1 = road.getCurrentPosition();
        road.moveForward();
        p2 = road.getCurrentPosition();
        assertEquals(p1, p2);

        // TEST 3
        // can move forward into the final line
        int[] obstacles2 = {0, 0, 0};
        road = new Road2(obstacles2);
        road.moveForward();
        p1 = road.getCurrentPosition();
        road.moveForward();
        p2 = road.getCurrentPosition();
        assertNotEquals(p1, p2);

    } // testMoveForward()

    @Test
    void testCanMoveUp() {
        int[] obstacles1 = {0, 1, 0};
        var road = new Road2(obstacles1);
        boolean actualResults;
        Position p1, p2;

        // TEST 1
        // Can move up one lane into an open space?
        actualResults = road.canMoveUp();
        assertTrue(actualResults);

        // TEST 2
        // Can move up and out of bounds?
        road.moveUp();
        actualResults = road.canMoveUp();
        assertFalse(actualResults);

        // TEST 3
        // Can move up into a rock?
        road.reset();
        road.moveForward();
        actualResults = road.canMoveUp();
        assertFalse(actualResults);

        // TEST 4
        // Can jump over a rock into an open space?
        int[] obstacles2 = {0, 1, 0};
        road = new Road2(obstacles2);
        road.moveDown();
        road.moveForward();
        actualResults = road.canMoveUp();
        assertTrue(actualResults);

    } // testCanMoveUp()

    @Test
    void testMoveUp() {
        boolean actualResults;

        int[] obstacles1 = {0, 1, 0};
        var road = new Road2(obstacles1);
        Position p1, p2;

        // TEST 1
        // Can move up one lane into an open space?
        p1 = road.getCurrentPosition();
        road.moveUp();
        p2 = road.getCurrentPosition();
        assertNotEquals(p1, p2);

        // Can move up and out of bounds?
        p1 = road.getCurrentPosition();
        road.moveUp();
        p2 = road.getCurrentPosition();
        assertEquals(p1, p2);

        // Can not move up into a rock?
        road.reset();
        road.moveForward();
        p1 = road.getCurrentPosition();
        road.moveUp();
        p2 = road.getCurrentPosition();
        assertEquals(p1, p2);

        // can jump over a rock.
        road.reset();
        road.moveDown();
        road.moveForward();
        p1 = road.getCurrentPosition();
        road.moveUp();
        p2 = road.getCurrentPosition();
        assertNotEquals(p1, p2);

    } // testMoveUp()

    @Test
    void testCanMoveDown() {
        int[] obstacles1 = {0, 1, 0};
        var road = new Road2(obstacles1);
        boolean actualResults;
        Position p1, p2;

        // TEST 1
        // Can move down one lane into an open space?
        actualResults = road.canMoveDown();
        assertTrue(actualResults);

        // TEST 2
        // Can move down and out of bounds?
        road.moveDown();
        actualResults = road.canMoveDown();
        assertFalse(actualResults);

        // TEST 3
        // Can move down into a rock?
        int[] obstacles3 = {0, 3, 0};
        road = new Road2(obstacles3);
        road.moveForward();
        actualResults = road.canMoveDown();
        assertFalse(actualResults);

        // TEST 4
        // Can jump down and over a rock into an open space?
        int[] obstacles4 = {0, 2, 0};
        road = new Road2(obstacles4);
        road.moveUp();
        road.moveForward();
        actualResults = road.canMoveDown();
        assertTrue(actualResults);

    } // testCanMoveDown()

    @Test
    void testMoveDown() {
        int[] obstacles1 = {0, 1, 0};
        var road = new Road2(obstacles1);
        boolean actualResults;
        Position p1, p2;

        // TEST 1
        // Move down one lane into an open space?
        p1 = road.getCurrentPosition();
        road.moveDown();
        p2 = road.getCurrentPosition();
        assertNotEquals(p1, p2);

        // TEST 2
        // Move down and out of bounds?
        p1 = road.getCurrentPosition();
        road.moveDown();
        p2 = road.getCurrentPosition();
        assertEquals(p1, p2);

        // TEST 3
        // Can move down into a rock?
        int[] obstacles3 = {0, 3, 0};
        road = new Road2(obstacles3);
        road.moveForward();
        p1 = road.getCurrentPosition();
        road.moveDown();
        p2 = road.getCurrentPosition();
        assertEquals(p1, p2);

        // TEST 4
        // Can jump down and over a rock into an open space?
        int[] obstacles4 = {0, 2, 0};
        road = new Road2(obstacles4);
        road.moveUp();
        road.moveForward();
        p1 = road.getCurrentPosition();
        road.moveDown();
        p2 = road.getCurrentPosition();
        assertNotEquals(p1, p2);

    } // testMoveDown()

} // class Road2Test