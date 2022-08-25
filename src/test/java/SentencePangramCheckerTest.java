import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SentencePangramCheckerTest {

    @Test
    void testCheckIfPangram() {

        SentencePangramChecker pt = new SentencePangramChecker();
        boolean result;

        // Test 1
        result = pt.checkIfPangram("thequickbrownfoxjumpsoverthelazydog");
        assertTrue(result);

        // Test 2
        result = pt.checkIfPangram("leetcode");
        assertFalse(result);

    } // testCheckIfPangram()

} // class SentencePangramChecker