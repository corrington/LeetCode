/*
LeetCode.com
97. Interleaving String
https://leetcode.com/problems/interleaving-string/
Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.

An interleaving of two strings s and t is a configuration where they are divided into non-empty substrings such that:

    s = s1 + s2 + ... + sn
    t = t1 + t2 + ... + tm
    |n - m| <= 1

The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...
Note: a + b is the concatenation of strings a and b.

Constraints:
    0 <= s1.length, s2.length <= 100
    0 <= s3.length <= 200
    s1, s2, and s3 consist of lowercase English letters.
 */
public class InterleavingStrings {


    // The solution below DOES NOT WORK.
    // Look into using Memoization or 2D Dynamic Programming or 1D Dynamic Programming
    public boolean isInterleave(final String s1, final String s2, final String s3) {
        // some quick checks
        if ((s1 == null) || (s2 == null) || (s3 == null)) return false;
        if (s1.isEmpty() && s2.isEmpty() && s3.isEmpty()) return true;
        if (s1.length() + s2.length() != s3.length()) return false;

        int s1Index = 0;
        int s2Index = 0;
        int s3Index = 0;

        while (s3Index < s3.length()) {

            boolean matchesFound = false;

            while ((s1Index < s1.length()) && (s1.charAt(s1Index) == s3.charAt(s3Index))) {
                // loop through the matching letters in s1 and s3
                s1Index++;
                s3Index++;
                matchesFound = true;
            } // while

            while ((s2Index < s2.length()) && (s2.charAt(s2Index) == s3.charAt(s3Index))) {
                // now loop through the matching letters in s2 and s3
                s2Index++;
                s3Index++;
                matchesFound = true;
            } //while

            // If no matches were found, we're out of here.
            if (!matchesFound) return false;

        } // while

        return true;

    } // isInterleave()


} // class InterleavingStrings