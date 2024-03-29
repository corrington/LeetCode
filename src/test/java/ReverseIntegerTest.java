import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReverseIntegerTest {

    @Test
    void testReverseInteger() {
        assertEquals(ReverseInteger.reverseInteger(0),0);
        System.out.println("0 passed");
        assertEquals(ReverseInteger.reverseInteger(1),1);
        System.out.println("1 passed");
        assertEquals(ReverseInteger.reverseInteger(-1),-1);
        System.out.println("-1 passed");
        assertEquals(ReverseInteger.reverseInteger(123),321);
        System.out.println("123 passed");
        assertEquals(ReverseInteger.reverseInteger(-123),-321);
        System.out.println("-123 passed");
        assertEquals(ReverseInteger.reverseInteger(Integer.MAX_VALUE),0);
        System.out.println(Integer.MAX_VALUE + " passed");
        assertEquals(ReverseInteger.reverseInteger(Integer.MIN_VALUE),0);
        System.out.println(Integer.MIN_VALUE + " passed");

    } // testReverseInteger()

} //  class ReverseIntegerTest