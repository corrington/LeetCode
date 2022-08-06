/*
LeetCode.com
Problem 746. Min Cost Climbing Stairs
You are given an integer array cost where cost[i] is the cost of ith step on a staircase.
Once you pay the cost, you can either climb one or two steps.

You can either start from the step with index 0, or the step with index 1.

Return the minimum cost to reach the top of the floor.

Example 1:
    Input: cost = [10,15,20]
    Output: 15
    Explanation: You will start at index 1.
        - Pay 15 and climb two steps to reach the top.
    The total cost is 15.

Example 2:
    Input: cost = [1,100,1,1,1,100,1,1,100,1]
    Output: 6
    Explanation: You will start at index 0.
        - Pay 1 and climb two steps to reach index 2.
        - Pay 1 and climb two steps to reach index 4.
        - Pay 1 and climb two steps to reach index 6.
        - Pay 1 and climb one step to reach index 7.
        - Pay 1 and climb two steps to reach index 9.
        - Pay 1 and climb one step to reach the top.
    The total cost is 6.

Constraints:
    2 <= cost.length <= 1000
    0 <= cost[i] <= 999

 My Notes:
 This is a poorly worded problem. I assume "the top of the floor"
 is one element after the last element in the input array, which
 would have a cost of zero.
 For example, cost = [10, 15, 20, 0]

 Unlike some solutions I saw on LeetCode, I think it's bad form
 to modify the input array, especially when you don't need to.
  */
public class MinCostClimbingStairs {

    // Complexity : Time: O(n) ; Space: O(1)
    public int minCostClimbingStairs(int[] cost) {

        int prevMinCost = 0;
        int currMinCost = cost[cost.length-1];

        for (int i = cost.length - 2; i >= 0; i--) {
            int temp = cost[i] + Math.min(currMinCost, prevMinCost);
            prevMinCost = currMinCost;
            currMinCost = temp;
        } // for i

        return Math.min(currMinCost, prevMinCost);

    } // minCostClimbingStairs()

} // class MinCostClimbingStairs
