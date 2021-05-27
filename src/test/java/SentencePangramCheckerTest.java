import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SentencePangramCheckerTest {

    @Test
    public void testCheckIfPangram() {

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