import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BestTimeToBuyAndSellStockTest {

    @Test
    void testMaxProfit() {
        var obj = new BestTimeToBuyAndSellStock();

        assertEquals(5, obj.maxProfit(new int[] {7,1,5,3,6,4}));
        assertEquals(0, obj.maxProfit(new int[]{7, 6, 4, 3, 1}));
    } // testMaxProfit()

} // class BestTimeToBuyAndSellStockTest