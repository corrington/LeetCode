/*
Problem 383. Ransom Note
https://leetcode.com/problems/ransom-note/
Given two strings ransomNote and magazine, return true if ransomNote can be constructed
by using the letters from magazine and false otherwise.

Each letter in magazine can only be used once in ransomNote.

Example 1:
    Input: ransomNote = "a", magazine = "b"
    Output: false

Example 2:
    Input: ransomNote = "aa", magazine = "ab"
    Output: false

Example 3:
    Input: ransomNote = "aa", magazine = "aab"
    Output: true

Constraints:
    1 <= ransomNote.length, magazine.length <= 105
    ransomNote and magazine consist of lowercase English letters.
 */
public class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        // [0] = number of 'a's, [1] = number of 'b's. etc.
        char[] countsOfLettersInMagazine = new char[26];

        // determine number of each lowercase letter in the magazine
        for (var letter : magazine.toCharArray()) {
            int letterIndex = letter - 'a';
            countsOfLettersInMagazine[ letterIndex ]++;
        } // for

        // ensure we have enough of each letter to complete the ransom note
        for (var letter : ransomNote.toCharArray()) {
            int letterIndex = letter - 'a';
            if (countsOfLettersInMagazine[ letterIndex ] == 0) return false;
            countsOfLettersInMagazine[ letterIndex ]--;
        } // for

        return true;

    } // canConstruct()

} // class RansomNote
