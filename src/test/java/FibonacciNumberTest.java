import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FibonacciNumberTest {

    @Test
    public void testFib() {

        var p = new FibonacciNumber();

        assertEquals(p.fib(0), 0);
        assertEquals(p.fib(1), 1);
        assertEquals(p.fib(2), 1);
        assertEquals(p.fib(3), 2);
        assertEquals(p.fib(4), 3);
        assertEquals(p.fib(5), 5);
        assertEquals(p.fib(6), 8);
        assertEquals(p.fib(7), 13);
        assertEquals(p.fib(8), 21);
        assertEquals(p.fib(9), 34);

    } // testFib()

} // class FibonacciNumberTest