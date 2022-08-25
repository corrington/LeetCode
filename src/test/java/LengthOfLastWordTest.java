import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LengthOfLastWordTest {

    @Test
     void testLengthOfLastWord() {
        var p = new LengthOfLastWord();

        assertEquals(p.lengthOfLastWord("Hello World"), 5);
        assertEquals( p.lengthOfLastWord("   fly me   to   the moon  "), 4);
        assertEquals( p.lengthOfLastWord("luffy is still joyboy"), 6);
        //
        assertEquals( p.lengthOfLastWord("a"), 1);
        assertEquals( p.lengthOfLastWord(" a"), 1);
        assertEquals( p.lengthOfLastWord("a "), 1);
        assertEquals( p.lengthOfLastWord("spellbook"), 9);
        assertEquals( p.lengthOfLastWord("   a   "), 1);
        assertEquals( p.lengthOfLastWord("bee   "), 3);
        assertEquals( p.lengthOfLastWord("   bee   "), 3);
        assertEquals( p.lengthOfLastWord("   bee"), 3);

    } // testLengthOfLastWord()
} // class LengthOfLastWordTest