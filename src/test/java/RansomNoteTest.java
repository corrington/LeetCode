import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RansomNoteTest {

    @Test
    void canConstructTest() {

        var obj = new RansomNote();

        assertFalse(obj.canConstruct("a", "b" ));
        assertFalse(obj.canConstruct("aa", "ab" ));
        assertTrue(obj.canConstruct("aa", "aab" ));

        assertTrue(obj.canConstruct("aa", "abcabc" ));
        assertTrue(obj.canConstruct("xyz", "xyz" ));
        assertTrue(obj.canConstruct("abcxyz", "xyzabc" ));
        assertFalse(obj.canConstruct("abc", "xyz" ));
        assertTrue(obj.canConstruct("z", "abcdefghijklmnopqrstuvwxyz" ));

    } // canConstructTest()

} // class RansomNoteTest