/*
Problem 278. First Bad Version
https://leetcode.com/problems/first-bad-version/
278. First Bad Version
You are a product manager and currently leading a team to develop a new product.
Unfortunately, the latest version of your product fails the quality check.
Since each version is developed based on the previous version, all the versions
after a bad version are also bad.
Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one,
which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which returns whether version is bad.
Implement a function to find the first bad version. You should minimize the number of calls to the API.

Example 1:
    Input: n = 5, bad = 4
    Output: 4
    Explanation:
    call isBadVersion(3) -> false
    call isBadVersion(5) -> true
    call isBadVersion(4) -> true
    Then 4 is the first bad version.

Example 2:
    Input: n = 1, bad = 1
    Output: 1

Constraints:
    1 <= bad <= n <= 231 - 1
 */
public class FirstBadVersion {

    public static int firstBadVersion1(int n) {
        int left = 1;
        int right = n;

        while (left <= right) {

            int mid = (left + right) / 2;

            boolean isMidLeftBad = isBadVersion(mid - 1);
            boolean isMidRightBad = isBadVersion(mid);

            if (!isMidLeftBad && isMidRightBad) {
                // we found the last good one and the first bad one
                return mid;
            } else if (!isMidLeftBad) {
                // The left one is good. Search the right side.
                left = mid + 1;
            } else  {
                // Both are bad. Search the left side.
                right = mid - 1;
            }

        } // while

        return -1;

    } // firstBadVersion1()


    public static int firstBadVersion2(int n) {
        int left = 1, right = n;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if(!isBadVersion(mid))
                left = mid + 1;
            else
                right = mid;
        } // while

        return left;

    } // firstBadVersion2()

    static boolean isBadVersion(int version) {
        return version >= 1702766719;
    } // isBadVersion()

    public static void main(String[] args) {
        System.out.println(firstBadVersion1(2126753390));
        System.out.println(firstBadVersion2(2126753390));
    } // main()

} // class FirstBadVersion
