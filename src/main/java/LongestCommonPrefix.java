/*
LeetCode
14. Longest Common Prefix
https://leetcode.com/problems/longest-common-prefix/

Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".

Example 1:
  Input: strs = ["flower","flow","flight"]
  Output: "fl"

Example 2:
  Input: strs = ["dog","racecar","car"]
  Output: ""
Explanation: There is no common prefix among the input strings.


Constraints:
   1 <= strs.length <= 200
   0 <= strs[i].length <= 200
   strs[i] consists of only lowercase English letters.
 */

public class LongestCommonPrefix {

    public String longestCommonPrefix(final String[] strs) {
        // some quick checks
        if (strs == null) return null;
        if (strs.length == 0) return "";

        for (int charIndex = 0; (charIndex < strs[0].length()); charIndex++) {
            // grab a char off the first string
            char ch1  = strs[0].charAt(charIndex);

            // compare this char to the chars in the other strings at the same index value
            for (int StringIndex = 1; (StringIndex < strs.length); StringIndex++) {
                if ((charIndex == strs[StringIndex].length()) || (ch1 != strs[StringIndex].charAt(charIndex))) {
                    // We got here because we ran out of string OR we found two different chars.
                    // Either way, we're done.  Time to return a substring of the chars that did match.
                    return strs[0].substring(0, charIndex);
                } // if

            } // for StringIndex

        } // for charIndex

        return strs[0];

    } // longestCommonPrefix()

    public static void main(String[] args) {
    } // main()

} // class LongestCommonPrefix

