import java.util.ArrayDeque;
import java.util.Deque;

class Road2 {
    private final int MAX_LANES = 3;
    Deque<Position> prevPositions;
    private int lengthOfRoad;
    private RoadMarkers[][] road;
    private int laneChanges = 0;
    // starting position
    private int curLane = 1;
    private int curStep = 0;
    Road2(int[] obstacles) {
        lengthOfRoad = obstacles.length;
        road = new RoadMarkers[MAX_LANES][lengthOfRoad];
        prevPositions = new ArrayDeque<>();

        // first step
        road[0][0] = RoadMarkers.OPEN;
        road[1][0] = RoadMarkers.FROG;
        road[2][0] = RoadMarkers.OPEN;

        // middle steps
        for (int lane = 0; lane < MAX_LANES; ++lane) {
            for (int step = 1; step < (lengthOfRoad - 1); ++step) {
                road[lane][step] = RoadMarkers.OPEN;
                if (needsObstacle(lane, step, obstacles)) {
                    road[lane][step] = RoadMarkers.ROCK;
                } // if
            } // for road
        } // for lane

        // last step
        road[0][lengthOfRoad - 1] = RoadMarkers.END;
        road[1][lengthOfRoad - 1] = RoadMarkers.END;
        road[2][lengthOfRoad - 1] = RoadMarkers.END;

    } // Road constructor

    String roadMarkersToString(RoadMarkers marker) {
        switch (marker) {
            case FROG:
                return "F";
            case OPEN:
                return ".";
            case VISITED:
                return "V";
            case ROCK:
                return "R";
            case END:
                return "E";
            default:
                return "?";
        } // switch marker
    } // roadMarkersToString()

    String laneToString(RoadMarkers[] lane) {
        StringBuilder sb = new StringBuilder();
        for (RoadMarkers roadMarkers : lane) {
            String marker = roadMarkersToString(roadMarkers) + " ";
            sb.append(marker);
        } // for i
        return sb.toString();
    } // laneToString()

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int lane = 0; lane < MAX_LANES; ++lane) {
            sb.append(laneToString(road[lane]));
            if (lane < (MAX_LANES - 1)) {
                sb.append("\n");
            }
        }  // for lane
        return sb.toString();
    } // toString()

    void markVisited(int lane, int step) {
        if (road[lane][step] == RoadMarkers.OPEN) {     // we do this so we don't
            road[lane][step] = RoadMarkers.VISITED;     // overwrite the END markers
        }
    } // markVisited()

    boolean wasVisited(int lane, int step) {
        return (road[lane][step] == RoadMarkers.VISITED);
    } // wasVisited()

    boolean needsObstacle(int lane, int step, int[] obstacles) {
        // none of the first steps can have an obstacle
        if (step == 0) return false;
        // none of the last  steps can have an obstacle
        if (step == (obstacles.length - 1)) return false;
        // let's check the middle for an obstacle
        boolean b = ((obstacles[step] - 1) == lane);
        return b;
    } // hasObstacle

    public boolean isEndOfRoad() {
        boolean b = (road[curLane][curStep] == RoadMarkers.END);
        return b;
    } // isEndOfRoad()

    public boolean hasPathsAvalable() {
        // have we explored every path possible?
        boolean b;
        b = (road[0][0] == RoadMarkers.VISITED);
        b = b && (road[1][0] == RoadMarkers.FROG);
        b = b && (road[2][0] == RoadMarkers.VISITED);
        b = b && (road[1][1] == RoadMarkers.VISITED);
        b = b && prevPositions.isEmpty();
        return !b;
    } // hasPathAvalable()

    boolean hasObstacle(int lane, int step) {
        boolean b = (road[lane][step] == RoadMarkers.ROCK);
        return b;
    }

    boolean isOutOfBounds(int lane, int step) {
        boolean b = (step < 0) || (step >= lengthOfRoad) || (lane < 0) || (lane >= MAX_LANES);
        return b;
    }

    boolean isAvailable(int lane, int step) {
        if (isOutOfBounds(lane, step)) return false;
        if (hasObstacle(lane, step)) return false;
        Boolean result = wasVisited(lane, step);
        return result;
    }

    void saveCurrentPosition() {
        Position curPos = new Position(curLane, curStep);
        prevPositions.push(curPos);
    }

    void moveTo(int nextLane, int nextStep) {
        saveCurrentPosition();
        // did we switch one or more lanes?
        curLane = nextLane;
        curStep = nextStep;
        markVisited(curLane, curStep);
    }

    public boolean canMoveForward() {
        int nextLane = curLane;
        int nextStep = curStep + 1;
        boolean result = isAvailable(nextLane, nextStep);
        return result;
    }

    public void moveForward() {
        if (!canMoveForward()) return;
        moveTo(curLane, curStep + 1);
    }

    boolean canMoveUpOneLane() {
        int nextLane = curLane - 1;
        int nextStep = curStep;
        boolean result = isAvailable(nextLane, nextStep);
        return result;
    }

    boolean canMoveUpTwoLanes() {
        // For this to work, we must be on the bottom lane...
        if (curLane != 2)
            return false;

        // and there must be a rock in the middle lane...
        if (!hasObstacle(1, curStep))
            return false;

        // and the position in the top lane must be open.
        if (!isAvailable(0, curStep))
            return false;

        return true;
    } // canMoveUpTwoLanes()

    public boolean canMoveUp() {
        if (canMoveUpOneLane()) return true;
        if (canMoveUpTwoLanes()) return true;
        return false;
    }

    public void moveUp() {
        int nextLane = curLane;
        int nextStep = curStep;

        if (canMoveUpOneLane()) {
            nextLane = curLane - 1;
        } else if (canMoveUpTwoLanes()) {
            nextLane = curLane - 2;
        }

        moveTo(nextLane, nextStep);
        laneChanges++;
    }

    boolean canMoveDownOneLane() {
        int nextLane = curLane + 1;
        int nextStep = curStep;
        boolean result = isAvailable(nextLane, nextStep);
        return result;
    }

    boolean canMoveDownTwoLanes() {
        // For this to work, we must be on the top lane...
        if (curLane != 0) return false;

        // and there must be a rock in the middle lane...
        if (!hasObstacle(1, curStep)) return false;

        // and the position in the bottom lane must be open.
        if (!isAvailable(2, curStep)) return false;

        return true;
    }

    public boolean canMoveDown() {
        if (canMoveDownOneLane()) return true;
        if (canMoveDownTwoLanes()) return true;
        return false;
    }

    public void moveDown() {
        int nextLane = curLane;
        int nextStep = curStep;

        if (canMoveDownOneLane()) {
            nextLane = curLane + 1;
        } else if (canMoveDownTwoLanes()) {
            nextLane = curLane + 2;
        }

        moveTo(nextLane, nextStep);
        laneChanges++;
    }

    boolean wasLaneChange(Position pos1, Position pos2) {
        boolean b = pos1.getLane() != pos2.getLane();
        return b;
    }

    public void moveBack() {
        if (prevPositions.isEmpty()) return;
        Position curPos = new Position(curLane, curStep);
        Position prevPos = prevPositions.pop();
        if (wasLaneChange(curPos, prevPos)) {
            laneChanges--;
        } // if
    } // moveBack()

    public int getLaneChanges() {
        return laneChanges;
    } // getLaneChanges()

    void restLanes() {
        for (int lane = 0; lane < MAX_LANES; ++lane) {
            for (int step = 0; step < lengthOfRoad; ++step) {
                if (road[lane][step] == RoadMarkers.VISITED) {
                    road[lane][step] = RoadMarkers.OPEN;
                } // if
            } // for step
        } // for lane
    } // restLanes()

    public void reset() {
        restLanes();
        prevPositions.clear();
        laneChanges = 0;
        // set starting position
        curLane = 1;
        curStep = 0;
    } // reset()

    Position getCurrentPosition() {
        return new Position(curLane, curStep);
    } // getCurrentPosition()


    private enum RoadMarkers {FROG, OPEN, VISITED, ROCK, END}


} // class Road
