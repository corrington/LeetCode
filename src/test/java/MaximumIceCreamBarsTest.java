import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumIceCreamBarsTest {

    @Test
    void testMaxIceCream() {

        MaximumIceCreamBars m = new MaximumIceCreamBars();
        int inputCoins;
        int expectedResult, actualResult;

        // Test 1
        int[] inputCosts1 =  {1,3,2,4,1};
        inputCoins = 7;
        expectedResult = 4;
        actualResult = m.maxIceCream(inputCosts1, inputCoins);
        assertEquals(actualResult,expectedResult);

        // Test 2
        int[] inputCosts2 =  {10,6,8,7,7,8};
        inputCoins = 5;
        expectedResult = 0;
        actualResult = m.maxIceCream(inputCosts2, inputCoins);
        assertEquals(actualResult,expectedResult);

        // Test 3
        int[] inputCosts3 =  {1,6,3,1,2,5};
        inputCoins = 20;
        expectedResult = 6;
        actualResult = m.maxIceCream(inputCosts3, inputCoins);
        assertEquals(actualResult,expectedResult);

    } // testMaxIceCream()

} // class MaximumIceCreamBarsTest