import java.util.Arrays;

/*
It is a sweltering summer day, and a boy wants to buy some ice cream bars.

At the store, there are n ice cream bars. You are given an array costs of length n, where costs[i] is the price of the ith ice cream bar in coins. The boy initially has coins coins to spend, and he wants to buy as many ice cream bars as possible.

Return the maximum number of ice cream bars the boy can buy with coins coins.

Note: The boy can buy the ice cream bars in any order.
 */
public class MaximumIceCreamBars {

    public int maxIceCream(int[] costs, int coins) {

        Arrays.sort(costs);

        for (int i = 0, coinsRemaining = coins; i < costs.length; ++i) {
            if ((coinsRemaining -= costs[i]) < 0) {
                return i;
            } // if
        } // for i

        return costs.length;

    } // maxIceCream()

} // class MaximumIceCreamBars
