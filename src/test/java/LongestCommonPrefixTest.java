import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestCommonPrefixTest {

    @Test
    void testLongestCommonPrefix() {
        // test cases
        var p = new LongestCommonPrefix();

        String[] s0 = {"a"};
        assertEquals("a", p.longestCommonPrefix(s0));  // "a"

        String[] s1 = {"flower","flow","flight"};
        assertEquals("fl", p.longestCommonPrefix(s1));  // "fl"

        String[] s2 = {"dog","racecar","car"};
        assertEquals("", p.longestCommonPrefix(s2));  // ""

        String[] s3 = {"flowmeter", "flowerpot", "flowstone", "flowerage", "flowchart", "flowerers", "flowerets", "flowerful" };
        assertEquals("flow", p.longestCommonPrefix(s3));  // "flow"

        String[] s4 = {""};
        assertEquals("", p.longestCommonPrefix(s4));  // ""

        String[] s5 = {"dog"};
        assertEquals("dog", p.longestCommonPrefix(s5));  // "dog"

        String[] s6 = {"dog", "dog", "dog", "dog", "dog"};
        assertEquals("dog", p.longestCommonPrefix(s6));  // "dog"

        String[] s7 = { "whatchamacallit", "whimsicalnesses", "whippersnappers", "wholesomenesses" };
        assertEquals("wh", p.longestCommonPrefix(s7));  // "wh"

        String[] s8 = { "whatchamacallit", "whimsicalnesses", "whippersnappers", "wholesomenesses" , "" };
        assertEquals("", p.longestCommonPrefix(s8));  // ""

        String[] s9 = { "whatchamacallit", "whimsicalnesses", "whippersnappers", "wholesomenesses" , "w" };
        assertEquals("w", p.longestCommonPrefix(s9));  // "w"

        String[] s10 = {};
        assertEquals("", p.longestCommonPrefix(s10));  // ""

        String[] s11 = { "whatchamacallit", "w", "whimsicalnesses", "whippersnappers", "wholesomenesses"};
        assertEquals("w", p.longestCommonPrefix(s11));  // "w"

        String[] s12 = { "w", "whatchamacallit", "whimsicalnesses", "whippersnappers", "wholesomenesses"};
        assertEquals("w", p.longestCommonPrefix(s12));  // "w"

    } // testLongestCommonPrefix()
} // class LongestCommonPrefixTest