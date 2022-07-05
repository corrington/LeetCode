/*
https://leetcode.com/problems/palindrome-number/
 */
public class PalindromeNumber {
    public boolean isPalindrome(final int x) {
        if (x < 10) return false;                   // Palindromes must be two or more digits
                                                    // and they must be positive

        if (x % 10 == 0) return false;              // if the right most digit is a zero, the number can't be
                                                    // a palindrome b/c palindromes can't have leading zeros.

        int oldNum = x;
        long newNum = 0;

        while (oldNum > 0) {                        // loop around until there are no more digits
            int digit = oldNum % 10;                // get a copy of the right-most digit
            newNum = (newNum * 10) + digit;         // add that digit to the new num
            oldNum = oldNum / 10;                   // finally, div the right most digit off the old num
        } // while

        return newNum == (long)x;

    } // isPalindrome()

    public static void main(String[] args) {
        var p = new PalindromeNumber();
        System.out.println(p.isPalindrome(0));
        System.out.println(p.isPalindrome(1));
        System.out.println(p.isPalindrome(10));
        System.out.println(p.isPalindrome(11));
        System.out.println(p.isPalindrome(111));
        System.out.println(p.isPalindrome(Integer.MAX_VALUE));
    } // main()

} // class PalindromeNumber
