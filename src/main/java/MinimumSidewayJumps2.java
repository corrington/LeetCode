/*
https://leetcode.com/problems/minimum-sideway-jumps/
 */

public class MinimumSidewayJumps2 {

    public int minSideJumps(int[] obstacles) {
        int sideJumps;
        Road road = new Road(obstacles);
        road.print();
        sideJumps = road.minSideJumps();
        return sideJumps;
    } // minSideJumps()

} // class MinimumSidewayJumps2
