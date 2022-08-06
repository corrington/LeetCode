import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class NthTribonacciNumberTest {

    @Test
    public void testTribonacciClassic() {
        var o = new NthTribonacciNumber();

        assertEquals(o.tribonacciClassic(0),0);
        assertEquals(o.tribonacciClassic(1),1);
        assertEquals(o.tribonacciClassic(2),1);
        assertEquals(o.tribonacciClassic(3),2);
        assertEquals(o.tribonacciClassic(4),4);
        assertEquals(o.tribonacciClassic(5),7);
        assertEquals(o.tribonacciClassic(6),13);
        assertEquals(o.tribonacciClassic(7),24);
        assertEquals(o.tribonacciClassic(8),44);
        assertEquals(o.tribonacciClassic(9),81);
        assertEquals(o.tribonacciClassic(10),149);
    } // testTribonacci()

    @Test
    public void testTribonacci() {
        var o = new NthTribonacciNumber();

        assertEquals(o.tribonacci(0),0);
        assertEquals(o.tribonacci(1),1);
        assertEquals(o.tribonacci(2),1);
        assertEquals(o.tribonacci(3),2);
        assertEquals(o.tribonacci(4),4);
        assertEquals(o.tribonacci(5),7);
        assertEquals(o.tribonacci(6),13);
        assertEquals(o.tribonacci(7),24);
        assertEquals(o.tribonacci(8),44);
        assertEquals(o.tribonacci(9),81);
        assertEquals(o.tribonacci(10),149);
    } // testTribonacci()

} // class NthTribonacciNumberTest