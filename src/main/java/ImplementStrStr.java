/*
LeetCode.com
https://leetcode.com/problems/implement-strstr/
28. Implement strStr()
Implement strStr().

Given two strings needle and haystack, return the index of the first occurrence of needle in haystack,
or -1 if needle is not part of haystack.

Clarification:
What should we return when needle is an empty string? This is a great question to ask during an interview.
For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent
with C's strstr() and Java's indexOf().

Constraints:
1 <= haystack.length, needle.length <= 104
haystack and needle consist of only lowercase English characters.
 */
public class ImplementStrStr {

    public int strStr(final String haystack, final String needle) {

        // some quick checks
        if (haystack == null) return -1;
        if (needle == null) return -1;
        if (needle.length() == 0) return 0;  // Consistent with C's strstr() and Java's indexOf().
        if (haystack.length() < needle.length()) return -1;

        // move through the haystack until we find the first matching character
        for (int haystackIndex = 0; haystackIndex <= (haystack.length() - needle.length()); haystackIndex++) {

            if (haystack.charAt(haystackIndex) == needle.charAt(0)) {

                // compare the chars in both strings until we find 1) run out of haystack or needle, or 2) we find a mismatch
                int haystackIndexTemp = haystackIndex;
                int needleIndex = 0;
                while ((haystackIndexTemp < haystack.length()) && (needleIndex < needle.length()) && (haystack.charAt(haystackIndexTemp) == needle.charAt(needleIndex))) {
                    haystackIndexTemp++;
                    needleIndex++;
                } // while
                // If we got to the end of the needle, we found the first occurrence of needle in haystack
                if (needleIndex == needle.length()) {
                    return haystackIndex;
                } // if

            } // if

        } // for i

        return -1;  // we never found a match

    } // strStr()


    public static void main(String[] args)
    {
        var p = new ImplementStrStr();

        // a handful of test cases
        // found
        System.out.println(p.strStr("","")); // 0
        System.out.println(p.strStr("a","")); // 0
        System.out.println(p.strStr("a","a")); // 0
        System.out.println(p.strStr("aaa","aaa")); // 0
        System.out.println(p.strStr("abc","c"));  // 2
        System.out.println(p.strStr("hello","ll")); // 2
        System.out.println(p.strStr("aaabbbccc", "aaa")); // 0
        System.out.println(p.strStr("aaabbbccc", "bbb")); // 3
        System.out.println(p.strStr("aaabbbccc","ccc"));  // 6
        System.out.println(p.strStr("aaabbbccccccaaacccccc","ccc"));  // 6

        // not found
        System.out.println("*********");
        System.out.println(p.strStr(null,null));
        System.out.println(p.strStr(null,"aa"));
        System.out.println(p.strStr("aaa",null));
        System.out.println(p.strStr("a","x"));
        System.out.println(p.strStr("awww","x"));
        System.out.println(p.strStr("c","abc"));
        System.out.println(p.strStr("ccc","aaabbbccc"));
        System.out.println(p.strStr("aaaaa","bba"));

    } // main()

} // class ImplementStrStr
