import java.util.TreeSet;
/*
Given a string s, find the length of the longest substring without repeating characters.

Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

Example 4:
Input: s = ""
Output: 0

Constraints:
0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.

 */
public class LongestSubstringWithoutRepeatingCharacters {

    /*
    We have two indexes: head and tail.  Tail advances forward stuffing new chars
    into a set. When we bump into a duplicate char, we have two conditions:
    1) head and tail are pointing to the dupe char. In this case, we simply
    increment head.
    2) head and tail are pointing to different chars. In this case, we have to
    increment head (and removing its corresponding chars) until we find a matching char.
    Then increment head one more time.
     */

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0)
            return 0;

        var set = new TreeSet<Character>();
        int maxLength = 0;
        int head = 0, tail = 0;

        while (tail < s.length()) {
            char ch = s.charAt(tail);
            // Have we seen this char before?
            if (set.contains(ch)) {
                // Are head and tail pointing to the same char?
                if (s.charAt(head) != ch) {
                    // If not, increment head until we do
                    while (s.charAt(head) != ch) {
                        set.remove(s.charAt(head));
                        head++;
                    } // while
                } // if
                // Increment head one more time to get past the dupe char
                head++;
            } // if
            set.add(ch);
            tail++;
            maxLength = Math.max(set.size(),maxLength);
        }  // for i
        return maxLength;
    } // lengthOfLongestSubstring

    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstring("abcabcbb")); // 3
        System.out.println(lengthOfLongestSubstring("bbbbb")); // 1
        System.out.println(lengthOfLongestSubstring("pwwkew"));  // 3
        System.out.println(lengthOfLongestSubstring(""));  // 0
        System.out.println(lengthOfLongestSubstring(" "));  // 1
        System.out.println(lengthOfLongestSubstring("dvdf")); // 3
        System.out.println(lengthOfLongestSubstring("dvqrdfraftq")); // 5
    } // main()
} // class LongestSubstringWithoutRepeatingCharacters
