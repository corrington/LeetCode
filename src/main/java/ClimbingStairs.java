/*
70. Climbing Stairs
You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Example 1:
    Input: n = 2
    Output: 2
    Explanation: There are two ways to climb to the top.
        1. 1 step + 1 step
        2. 2 steps

Example 2:
   Input: n = 3
   Output: 3
   Explanation: There are three ways to climb to the top.
        1. 1 step + 1 step + 1 step
        2. 1 step + 2 steps
        3. 2 steps + 1 step

Constraints:
   1 <= n <= 45
 */

public class ClimbingStairs {

    // DP (Bottom Up Approach)
    // To calculate the new value we only need the previous two values
    // Complexity : Time: O(n) ; Space: O(1)
    public int climbStairs(int n) {
        if (n <= 1) return 1;

        int prevStep = 1;
        int currStep = 2;

        for (int i = 3; i <= n; i++) {
            int temp = currStep + prevStep;
            prevStep = currStep;
            currStep = temp;
        } // for step

        return currStep;

    } // climbStairs()

    // a classic recursive solution
    // Complexity : Time: O(2^n) ; Space: O(n)
    public int climbStairs2(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        return climbStairs2(n - 1) + climbStairs2(n - 2);
    } // climbStairs2

} // class ClimbingStairs
