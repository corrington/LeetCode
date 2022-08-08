import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class BestTimeToBuyAndSellStockTest {

    @Test
    public void testMaxProfit() {
        var obj = new BestTimeToBuyAndSellStock();

        assertEquals(obj.maxProfit(new int[] {7,1,5,3,6,4}), 5);
        assertEquals(obj.maxProfit(new int[] {7,6,4,3,1}), 0);
    } // testMaxProfit()

} // class BestTimeToBuyAndSellStockTest