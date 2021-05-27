import java.util.LinkedList;
import java.util.*;

class Road {
    private final int MAX_LANES = 3;
    private int lengthOfRoad;

    // Because we're going to use a Depth-First Search (DFS), we use a PriorityQueue to hold the next steps.
    // Positions that are further down the road (e.g., a larger step value) are considered "bigger."
    private HashMap<Position, PriorityQueue<Position>> graphOfRoad = new HashMap<>();
    private HashMap<Position, Boolean> visitedPosList = new HashMap<>();

    Road(int[] obstacles) {
        lengthOfRoad = obstacles.length;

        // build a graph based on the road and list of obstacles
        for (int lane = 0; lane < MAX_LANES; ++lane) {
            for (int step = 0; step < lengthOfRoad; ++step) {

                // we don't store rocks in the graph
                if (hasObstacle(lane, step, obstacles)) continue;

                // we have an open space or an ending point
                Position curPosition = new Position(lane, step);
                PriorityQueue<Position> adjacentPositions = new PriorityQueue<>();

                // is there a forward path?
                if (canMoveForward(lane, step, obstacles)) {
                    adjacentPositions.add( new Position(lane,step+1));
                }

                // is there an upper path?
                if (canMoveUpOne(lane, step, obstacles)) {
                    adjacentPositions.add( new Position(lane-1, step));
                } else if (canMoveUpTwo(lane, step, obstacles)) {
                    adjacentPositions.add( new Position(lane-2, step));
                }

                // is there a lower path?
                if (canMoveDownOne(lane, step, obstacles)) {
                    adjacentPositions.add( new Position(lane + 1, step));
                } else if (canMoveDownTwo(lane, step, obstacles)) {
                    adjacentPositions.add( new Position(lane + 2, step));
                }

                graphOfRoad.put(curPosition, adjacentPositions);

            } // for step
        } // for lane

    } // Road() constructor

    boolean hasObstacle(int lane, int step, int[] obstacles) {
        // none of the first steps can have an obstacle
        if (step == 0) return false;
        // none of the last  steps can have an obstacle
        if (step == (obstacles.length - 1)) return false;
        // let's check the middle for an obstacle
        boolean b = ((obstacles[step] - 1) == lane);
        return b;
    }

    boolean isStepOutOfRange(int step) {
        boolean b = (step < 0) || (step >= (lengthOfRoad));
        return b;
    }

    boolean isEndOfRoad(int step) {
        return (step == (lengthOfRoad - 1));
    }

    boolean canMoveForward(int lane, int step, int[] obstacles) {
        if (isLaneOutOfRange(lane)) return false;
        if (isStepOutOfRange(step)) return false;
        int nextStep = step + 1;
        if (isStepOutOfRange(nextStep)) return false;
        if (hasObstacle(lane, nextStep, obstacles)) return false;
        return true;
    }

    boolean isLaneOutOfRange(int lane) {
        boolean b = (lane < 0) || (lane >= MAX_LANES);
        return b;
    } // isLaneOutOfRange()

    boolean canMoveUpOne(int lane, int step, int[] obstacles) {
        // guardrail check
        if (isLaneOutOfRange(lane)) return false;
        if (isStepOutOfRange(step)) return false;
        // If we're in the top lane, no go.
        if (lane == 0) return false;
        // If we're in the middle and there's a rock in the top lane, no go.
        if ((lane == 1) && hasObstacle(0, step, obstacles)) return false;
        // if we're in the bottom lane and there's a rock in the middle lane, no go.
        if ((lane == 2) && hasObstacle(1, step, obstacles)) return false;
        return true;
    }

    boolean canMoveUpTwo(int lane, int step, int[] obstacles) {
        // guardrail check
        if (isLaneOutOfRange(lane)) return false;
        if (isStepOutOfRange(step)) return false;
        // the top lane must be open
        if (hasObstacle(0, step, obstacles)) return false;
        // the middle lane must have a rock
        if (!hasObstacle(1, step, obstacles)) return false;
        // we must be making this call from the bottom lane
        if (lane != 2) return false;
        return true;
    }

    boolean canMoveDownOne(int lane, int step, int[] obstacles) {
        // guardrail check
        if (isLaneOutOfRange(lane)) return false;
        if (isStepOutOfRange(step)) return false;
        // if we're in the bottom lane, no go.
        if (lane == 2) return false;
        // if we're in the middle lane and there's a rock in the bottom lane, no go.
        if ((lane == 1) && hasObstacle(2, step, obstacles)) return false;
        // if we're in the top lane  and there's a rock in the middle lane, no go.
        if ((lane == 0) && hasObstacle(1, step, obstacles)) return false;
        return true;
    }

    boolean canMoveDownTwo(int lane, int step, int[] obstacles) {
        // guardrail check
        if (isLaneOutOfRange(lane)) return false;
        if (isStepOutOfRange(step)) return false;
        // the bottom lane must be open
        if (hasObstacle(2, step, obstacles)) return false;
        // the middle lane must have a rock
        if (!hasObstacle(1, step, obstacles)) return false;
        // we must be making this call from the top lane
        if (lane != 0) return false;
        return true;
    }

    String strOfAdjPositions(Queue<Position> adjPositions) {
        if (adjPositions.size() == 0) return "<Empty>";

        StringBuilder sb = new StringBuilder();
        for (var pos : adjPositions) {
            sb.append(pos.toString()).append(", ");
        }
        return sb.toString();
    } // strOfAdjPositions()

    public void print() {
        if (graphOfRoad.isEmpty()) {
            System.out.println("graphOfRoad is <empty>");
            return;
        }

        for (var entry : graphOfRoad.entrySet()) {
            var curPosition = entry.getKey();
            var adjPositions = entry.getValue();
            System.out.println(curPosition + " -> " + strOfAdjPositions(adjPositions));
        } // for entry
    } // print()

    boolean isEndOfRoad( Position pos) {
        boolean result = (pos.getStep() == (lengthOfRoad - 1));
        return result;
    }

    boolean isLaneChange(Position curPos, Position nextPos ) {
        boolean result = (curPos.getLane() != nextPos.getLane());
        return result;
    }

    int walkabout(Position curPos, int laneChanges) {
        if (isEndOfRoad(curPos)) {
            return 0;
        } // if

        // get the list of next possible positions and visit them
        PriorityQueue<Position> nextPosList = graphOfRoad.get(curPos);
        for ( var nextPos : nextPosList) {

            // if we've already seen this one, ignore it
            if (visitedPosList.containsKey(nextPos)) continue;

            // This one is new, Let's explore it
            visitedPosList.put(nextPos,true);
            int delta = isLaneChange(curPos, nextPos) ? 1 : 0;
            walkabout(nextPos, laneChanges + delta);

        } // for nextPos

        return 0;

    } // walkabout()

    public int minSideJumps2() {
        Position startingPoint = new Position(1,0);
        int laneChanges = walkabout(startingPoint,0);
        return laneChanges;
    } // minSideJumps()

    public int minSideJumps() {
        int sideJumps = 0;
        boolean isSearching = true;
        // to keep track of the positions we need to check
        Queue<Position> unvisitedPositions = new LinkedList<>();
        var startingPos = new Position(1,0);
        unvisitedPositions.add(startingPos);
        // to keep track of the positions we've seen before
        Queue<Position> visitedPositions = new LinkedList<>();
        // to keep track of the distances from our starting point to each of the other nodes.
        HashMap<Position,Integer> distances = new HashMap<>();
        distances.put(startingPos,0);


        while (!unvisitedPositions.isEmpty()) {
            Position curPos = unvisitedPositions.poll();

            if (!visitedPositions.contains(curPos)) {
                visitedPositions.add(curPos);

                if (isEndOfRoad(curPos)) break;

                PriorityQueue<Position> adjacentPositions = graphOfRoad.get(curPos);
                for (var adjPos : adjacentPositions) {
                    if (!visitedPositions.contains(adjPos)) {
                        unvisitedPositions.add(adjPos);
                    } // if
                } // for adjPos
            } // if
        } // while

        System.out.println("dump of visited Queue");
        for (var pos : visitedPositions) {
            System.out.print("(" + pos.getLane() + "," + pos.getStep() + "), ");
        }
        System.out.println();

        return sideJumps;
    } // minSideJumps()

} // class Road
