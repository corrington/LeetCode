/*
LeetCode.com
58. Length of Last Word
https://leetcode.com/problems/length-of-last-word/
Given a string s consisting of words and spaces, return the length of the last word in the string.

A word is a maximal substring consisting of non-space characters only.

Example 1:
Input: s = "Hello World"
Output: 5
Explanation: The last word is "World" with length 5.

Example 2:
Input: s = "   fly me   to   the moon  "
Output: 4
Explanation: The last word is "moon" with length 4.

Example 3:
Input: s = "luffy is still joyboy"
Output: 6
Explanation: The last word is "joyboy" with length 6.


Constraints:
    1 <= s.length <= 104
    s consists of only English letters and spaces ' '.
    There will be at least one word in s.
 */

public class LengthOfLastWord {

    // This version creates no additional strings
    // and only scans the end of the source string
    public int lengthOfLastWord(final String s) {
        if (s.length() == 0) return 0;

        int tail = s.length() - 1;

        // Find the end of the last word (possibly skipping over trailing spaces)
        while((tail >= 0) && (s.charAt(tail) == ' ')) {
            tail--;
        } // while

        // Find the start of the last word by skipping over  non-spaces
        int head = tail;
        while((head >= 0) && (s.charAt(head) != ' ')) {
            head--;
        } // while

        return (tail - head);

    } // lengthOfLastWord()


    // This version creates an array of strings
    public int lengthOfLastWord2(final String s) {
        if (s.length() == 0) return 0;

        // split the input string into an array of strings
        String[] arrOfStrs = s.split(" ");

        // grab the last string and return its length
        return arrOfStrs[arrOfStrs.length-1].length();

    } // lengthOfLastWord2()

} // class LengthOfLastWord2
