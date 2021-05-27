/*
https://leetcode.com/problems/longest-palindromic-substring/
Given a string s, return the longest palindromic substring in s.

Example 1:
Input: s = "babad"
Output: "bab"
Note: "aba" is also a valid answer.

Example 2:
Input: s = "cbbd"
Output: "bb"

Example 3:
Input: s = "a"
Output: "a"

Example 4:
Input: s = "ac"
Output: "a"

Constraints:
1 <= s.length <= 1000
string consist of only digits and English letters (lower-case and/or upper-case)
 */
public class LongestPalindromicSubstring {

    private static boolean isPalindrome(String s) {
        if (s.length() == 1) return true;
        if ((s.length() == 2) && (s.charAt(0) == s.charAt(1))) return true;

        for (int i = 0; i < (s.length() / 2); ++i) {
            // Compare the chars at the front of the the string with those at the back.
            // If we find a difference, the string is NOT a palindrome.
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        } // for i
        return true;
    } // isPalindrome()

    /*
    The simple brute force method.
     */
    public static String longestPalindrome1(String s) {
        if (s.length() == 1) return s;

        String longestPal = "";
        for (int head = 0; head < s.length() - 1; ++head) {
            for (int tail = head + 1; tail <= s.length(); ++tail) {
                String sub = s.substring(head, tail);
                if (isPalindrome(sub)) {
                    if (sub.length() > longestPal.length()) {
                        longestPal = sub;
                    }
                }
            } // for tail
        } // for head
        return longestPal;
    } // longestPalindrome1()

    /*
    A slightly improved brute force method.
    Using the beginIndex and endIndex, a "window" is defined.
    The window is slid along the string and substrings within the window
    and extracted and tested. When the window hits the end of the string,
    the window is shrunk by one and the process begins again.
    Because the window size is going from large to small, the first palindrome
    found is returned. If no palindrome exists, the first letter of the string
    is returned.
     */
    public static String longestPalindrome2(String s) {
        if (s.length() == 1) return s;

        // Define a "window" and slide it left to right across the string.
        // After each iteration, make the window a little smaller
        for (int windowSize = s.length() - 1; windowSize > 0; --windowSize) {
            for (int beginIndex = 0; beginIndex < s.length() - windowSize; ++beginIndex) {
                int endIndex = beginIndex + windowSize + 1;
                // extract a substring from within the window and test it
                String candidate = s.substring(beginIndex, endIndex);
                if (isPalindrome(candidate)) {
                    // the first palindrome found is the largest
                    return candidate;
                }
            }
        } // for window

        // Since we didn't find a palindrome, return string's first character.
        return s.substring(0, 1);

    } // longestPalindrome()

    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);               // check for the odd-length palindromes
            int len2 = expandAroundCenter(s, i, i + 1);     //  check for the even-length palindromes
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad")); // bab
        System.out.println(longestPalindrome("cbbd")); // bb
        System.out.println(longestPalindrome("a")); // a
        System.out.println(longestPalindrome("ac")); // a
        System.out.println(longestPalindrome("anutforajaroftuna")); // anutforajaroftuna
        System.out.println(longestPalindrome("asdfasdfanutforajaroftunaeasgeg")); // anutforajaroftuna
        System.out.println(longestPalindrome("tacocatfefd")); // tacocat
        System.out.println(longestPalindrome("oejftacocat")); // tacocat
        System.out.println(longestPalindrome("cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc")); // a
    } // main()

} // class LongestPalindromicSubstring
