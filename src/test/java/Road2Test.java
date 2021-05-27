import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Road2Test {

    @Test
    public void testTestToString() {
        System.out.println("0 1 2 3 4 5 6 7 8");

        // Test 1
        int[] obstacles1 = {0,1,2,3,0};
        var road = new Road2(obstacles1);
        System.out.println(road);

    } // testTestToString

    @Test
    public void testMarkVisited() {
        // TODO: Implement
    }

    @Test
    public void testWasVisited() {
        // TODO: Implement
    }

    @Test
    public void testHasObstacle() {
        // TODO: Implement
    }

    @Test
    public void testTestToString1() {
    }

    @Test
    public void testIsEndOfRoad() {
    }

    @Test
    public void testIsClosed() {
    }

    @Test
    public void testCanMoveForward() {
        int[] obstacles1 = {0,0,2,0};
        var road = new Road2(obstacles1);
        boolean actualResults;
        Position p1, p2;

        // TEST 1
        // can we move into open space?
        actualResults = road.canMoveForward();
        assertTrue(actualResults);

        // TEST 2
        // can't move forward into a rock
        int[] obstacles2 = {0,2,0};
        road = new Road2(obstacles2);
        actualResults = road.canMoveForward();
        assertFalse(actualResults);

        // TEST 3
        // can move into finish line
        int[] obstacles3 = {0,0,0};
        road = new Road2(obstacles3);
        road.moveForward();
        actualResults = road.canMoveForward();
        assertTrue(actualResults);

    } // testCanMoveForward()

    @Test
    public void testMoveForward() {
        int[] obstacles1 = {0,0,2,0};
        var road = new Road2(obstacles1);
        boolean actualResults;
        Position p1, p2;

        // TEST 1
        // can move forward into open space
        p1 = road.getCurrentPosition();
        road.moveForward();
        p2 = road.getCurrentPosition();
        assertNotEquals(p1,p2);

        // TEST 2
        // when you try to move forward into a rock,
        // the move fails and you're returned the original pos
        p1 = road.getCurrentPosition();
        road.moveForward();
        p2 = road.getCurrentPosition();
        assertEquals(p1,p2);

        // TEST 3
        // can move forward into the final line
        int[] obstacles2 = {0,0,0};
        road = new Road2(obstacles2);
        road.moveForward();
        p1 = road.getCurrentPosition();
        road.moveForward();
        p2 = road.getCurrentPosition();
        assertNotEquals(p1,p2);

    } // testMoveForward()

    @Test
    public void testCanMoveUp() {
        int[] obstacles1 = {0,1,0};
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
        int[] obstacles2 = {0,1,0};
        road = new Road2(obstacles2);
        road.moveDown();
        road.moveForward();
        actualResults = road.canMoveUp();
        assertTrue(actualResults);

    } // testCanMoveUp()

    @Test
    public void testMoveUp() {
        boolean actualResults;

        int[] obstacles1 = {0,1,0};
        var road = new Road2(obstacles1);
        Position p1, p2;

        // TEST 1
        // Can move up one lane into an open space?
        p1 = road.getCurrentPosition();
        road.moveUp();
        p2 = road.getCurrentPosition();
        assertNotEquals(p1,p2);

        // Can move up and out of bounds?
        p1 = road.getCurrentPosition();
        road.moveUp();
        p2 = road.getCurrentPosition();
        assertEquals(p1,p2);

        // Can not move up into a rock?
        road.reset();
        road.moveForward();
        p1 = road.getCurrentPosition();
        road.moveUp();
        p2 = road.getCurrentPosition();
        assertEquals(p1,p2);

        // can jump over a rock.
        road.reset();
        road.moveDown();
        road.moveForward();
        p1 = road.getCurrentPosition();
        road.moveUp();
        p2 = road.getCurrentPosition();
        assertNotEquals(p1,p2);

    } // testMoveUp()

    @Test
    public void testCanMoveDown() {
        int[] obstacles1 = {0,1,0};
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
        int[] obstacles3 = {0,3,0};
        road = new Road2(obstacles3);
        road.moveForward();
        actualResults = road.canMoveDown();
        assertFalse(actualResults);

        // TEST 4
        // Can jump down and over a rock into an open space?
        int[] obstacles4 = {0,2,0};
        road = new Road2(obstacles4);
        road.moveUp();
        road.moveForward();
        actualResults = road.canMoveDown();
        assertTrue(actualResults);

    } // testCanMoveDown()

    @Test
    public void testMoveDown() {
        int[] obstacles1 = {0,1,0};
        var road = new Road2(obstacles1);
        boolean actualResults;
        Position p1, p2;

        // TEST 1
        // Move down one lane into an open space?
        p1 = road.getCurrentPosition();
        road.moveDown();
        p2 = road.getCurrentPosition();
        assertNotEquals(p1,p2);

        // TEST 2
        // Move down and out of bounds?
        p1 = road.getCurrentPosition();
        road.moveDown();
        p2 = road.getCurrentPosition();
        assertEquals(p1,p2);

        // TEST 3
        // Can move down into a rock?
        int[] obstacles3 = {0,3,0};
        road = new Road2(obstacles3);
        road.moveForward();
        p1 = road.getCurrentPosition();
        road.moveDown();
        p2 = road.getCurrentPosition();
        assertEquals(p1,p2);

        // TEST 4
        // Can jump down and over a rock into an open space?
        int[] obstacles4 = {0,2,0};
        road = new Road2(obstacles4);
        road.moveUp();
        road.moveForward();
        p1 = road.getCurrentPosition();
        road.moveDown();
        p2 = road.getCurrentPosition();
        assertNotEquals(p1,p2);

    } // testMoveDown()

    @Test
    public void testBackup() {
    }

    @Test
    public void testGetLaneChanges() {
        boolean expectedResult, actualResult;


    } // testGetLaneChanges()

    @Test
    public void testRoadMarkersToString() {
    }

    @Test
    public void testLaneToString() {
    }

    @Test
    public void testTestToString2() {
    }

    @Test
    public void testTestMarkVisited() {
    }

    @Test
    public void testTestWasVisited() {
    }

    @Test
    public void testNeedsObstacle() {
    }

    @Test
    public void testTestIsEndOfRoad() {
    }

    @Test
    public void testTestIsClosed() {
    }

    @Test
    public void testTestHasObstacle() {
    }

    @Test
    public void testIsOutOfBounds() {
    }

    @Test
    public void testIsAvailable() {
    }

    @Test
    public void testSaveCurrentPosition() {
    }

    @Test
    public void testMoveTo() {
    }

    @Test
    public void testTestCanMoveForward() {
    }

    @Test
    public void testTestMoveForward() {
    }

    @Test
    public void testCanMoveUpOneLane() {
    }

    @Test
    public void testCanMoveUpTwoLanes() {
    }

    @Test
    public void testTestCanMoveUp() {
    }

    @Test
    public void testTestMoveUp() {
    }

    @Test
    public void testCanMoveDownOneLane() {
    }

    @Test
    public void testCanMoveDownTwoLanes() {
    }

    @Test
    public void testTestCanMoveDown() {
    }

    @Test
    public void testTestMoveDown() {
    }

    @Test
    public void testWasLaneChange() {
    }

    @Test
    public void testMoveBack() {
    }

    @Test
    public void testTestGetLaneChanges() {
    }

    @Test
    public void testRestLanes() {
    }

    @Test
    public void testReset() {
    }

    @Test
    public void testGetCurrentPosition() {
    }
} // class Road2Test