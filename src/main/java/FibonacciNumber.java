import java.util.Arrays;

/*
LeetCode.com
Problem 509. Fibonacci Number
The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence,
such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,

     F(0) = 0, F(1) = 1
     F(n) = F(n - 1) + F(n - 2), for n > 1.
     Given n, calculate F(n).

Example 1:
Input: n = 2
Output: 1
Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.

Example 2:
Input: n = 3
Output: 2
Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.

Example 3:
Input: n = 4
Output: 3
Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.

Constraints:
    0 <= n <= 30
 */

public class FibonacciNumber {

    // This is the classic (slow) recursive solution
    // time complexity O(2^n)
    // space complexity O(n)
    public int fib1(int n) {
        if (n == 0) return 0;
        if (n <= 2) return 1;
        return fib1(n - 1) + fib1(n - 2);
    } // fib1()


    // A more performant version that uses an array as a cache
    // time complexity O(n)
    // space complexity O(n)
    public int fib2(int n) {
        if (n < 2) return n;

        int[] cache = new int[n + 1];
        Arrays.fill(cache,-1);

        cache[0] = 0;
        cache[1] = 1;
        return fib2(n, cache);
    } // fib2()

    // overloaded private method with cache
    private int fib2(int n, int[] cache) {
        if (cache[n] >= 0) return cache[n];
        cache[n] = fib2(n - 1, cache) + fib2(n - 2, cache);
        return cache[n];

    } // fib2()


    // A very fast non-recursive version.
    // time complexity O(n)
    // space complexity O(n)
    public int fib3(int n) {
        if (n < 2) return n;

        int[] cache = new int[n+1];
        cache[0] = 0; // f(0) = 0
        cache[1] = 1; // f(1) = 1;
        for (int i = 2; i <= n; i++) {
            cache[i] = cache[i-1] + cache[i-2];
        } // for i
        return cache[n];
    } // fib3()


    // A very fast non-recursive version that requires very additional space.
    // time complexity O(n)
    // space complexity O(1)
    public int fib4(int n) {
        if (n < 2) return n;

        int prevValue = 0; // f(0) = 0
        int currValue = 1; // f(1) = 1
        for (int i = 2; i <= n; i++) {
            int temp = currValue + prevValue;
            prevValue = currValue;
            currValue = temp;
        } // for i
        return currValue;
    } // fib4()

} // class FibonacciNumber