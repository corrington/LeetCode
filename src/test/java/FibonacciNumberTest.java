import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FibonacciNumberTest {

    @Test
     void testFib() {

        var obj = new FibonacciNumber();

        assertEquals(obj.fib1(0), 0);
        assertEquals(obj.fib1(1), 1);
        assertEquals(obj.fib1(2), 1);
        assertEquals(obj.fib1(3), 2);
        assertEquals(obj.fib1(4), 3);
        assertEquals(obj.fib1(5), 5);
        assertEquals(obj.fib1(6), 8);
        assertEquals(obj.fib1(7), 13);
        assertEquals(obj.fib1(8), 21);
        assertEquals(obj.fib1(9), 34);

        assertEquals(obj.fib2(0), 0);
        assertEquals(obj.fib2(1), 1);
        assertEquals(obj.fib2(2), 1);
        assertEquals(obj.fib2(3), 2);
        assertEquals(obj.fib2(4), 3);
        assertEquals(obj.fib2(5), 5);
        assertEquals(obj.fib2(6), 8);
        assertEquals(obj.fib2(7), 13);
        assertEquals(obj.fib2(8), 21);
        assertEquals(obj.fib2(9), 34);

        assertEquals(obj.fib3(0), 0);
        assertEquals(obj.fib3(1), 1);
        assertEquals(obj.fib3(2), 1);
        assertEquals(obj.fib3(3), 2);
        assertEquals(obj.fib3(4), 3);
        assertEquals(obj.fib3(5), 5);
        assertEquals(obj.fib3(6), 8);
        assertEquals(obj.fib3(7), 13);
        assertEquals(obj.fib3(8), 21);
        assertEquals(obj.fib3(9), 34);

        assertEquals(obj.fib4(0), 0);
        assertEquals(obj.fib4(1), 1);
        assertEquals(obj.fib4(2), 1);
        assertEquals(obj.fib4(3), 2);
        assertEquals(obj.fib4(4), 3);
        assertEquals(obj.fib4(5), 5);
        assertEquals(obj.fib4(6), 8);
        assertEquals(obj.fib4(7), 13);
        assertEquals(obj.fib4(8), 21);
        assertEquals(obj.fib4(9), 34);

    } // testFib()

} // class FibonacciNumberTest