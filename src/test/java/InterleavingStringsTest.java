import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class InterleavingStringsTest {

    @Test
     void testIsInterleave() {
        var p = new InterleavingStrings();

        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
        assertTrue( p.isInterleave(s1, s2, s3));

        s1 = "aa"; s2 = "ab"; s3 = "aaba";
        assertTrue( p.isInterleave(s1, s2, s3));
/*
        s1 = "aabcc"; s2 = "dbbca"; s3 = "aadbbbaccc";
        assertFalse( p.isInterleave(s1, s2, s3));

        s1 = ""; s2 = ""; s3 = "";
        assertTrue( p.isInterleave(s1, s2, s3));

        s1 = "a"; s2 = "b"; s3 = "abc";
        assertFalse( p.isInterleave(s1, s2, s3));

        s1 = ""; s2 = "abcd"; s3 = "abc";
        assertFalse( p.isInterleave(s1, s2, s3));

        s1 = ""; s2 = "abc"; s3 = "abc";
        assertTrue( p.isInterleave(s1, s2, s3));

        s1 = "a"; s2 = "b"; s3 = "ab";
        assertTrue( p.isInterleave(s1, s2, s3));

        s1 = "b"; s2 = "a"; s3 = "ba";
        assertTrue( p.isInterleave(s1, s2, s3));

        s1 = "a"; s2 = "b"; s3 = "ba";
        assertTrue( p.isInterleave(s1, s2, s3));

        s1 = "bbc"; s2 = "ab"; s3 = "bbabc";
        assertTrue( p.isInterleave(s1, s2, s3));

        s1 = "abc"; s2 = "abc"; s3 = "abcabc";
        assertTrue( p.isInterleave(s1, s2, s3));

        s1 = "aceg"; s2 = "bdfh"; s3 = "abcdefgh";
        assertTrue( p.isInterleave(s1, s2, s3));
*/
    } //  testIsInterleave() ()


} // class InterleavingStringsTest