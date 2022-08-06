import java.util.HashMap;
import java.util.Random;
/*
LeetCode.com
Problem 1137. N-th Tribonacci Number
The Tribonacci sequence Tn is defined as follows:

     T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.

Given n, return the value of Tn.

Example 1:
   Input: n = 4
   Output: 4
   Explanation:
   T_3 = 0 + 1 + 1 = 2
   T_4 = 1 + 1 + 2 = 4

Example 2:
   Input: n = 25
   Output: 1389537

Constraints:
     0 <= n <= 37
     The answer is guaranteed to fit within a 32-bit integer, ie. answer <= 2^31 - 1.
 */
public class NthTribonacciNumber {

           // HashMap( key=n, value=Tribonacci term )
    HashMap<Integer, Integer> cachedTribonaccis = new HashMap<>(37);
    int[] cachedTribonaccis2 = new int[37];

    // here's the classic recursive solution
    public int tribonacciClassic(int n) {
        if (n == 0) return 0;
        if (n <= 2) return 1;
        return tribonacciClassic(n - 1) +
                tribonacciClassic(n - 2) +
                tribonacciClassic(n - 3);
    } // tribonacci()


    // Here's a faster version of the recursive solution.
    // It stores the final result into a HashMap for a fast lookup cache later.
    public int tribonacci(int n) {
        // if we've seen this n before, pull the answer from the cache
        if (cachedTribonaccis.containsKey(n)) return cachedTribonaccis.get(n);

        if (n == 0) return 0;
        if (n <= 2) return 1;

        int result = tribonacciClassic(n - 1) +
                tribonacciClassic(n - 2) +
                tribonacciClassic(n - 3);

        cachedTribonaccis.put(n, result);

        return result;

    } // tribonacci()


    // Here's another faster version of the recursive solution.
    // It uses a HashMap to store the intermediate terms as well
    // as the final term.
    public int tribonacci2(int n) {
        // if we've seen this n before, pull the answer from the cache
        if (cachedTribonaccis.containsKey(n)) return cachedTribonaccis.get(n);

        if (n == 0) return 0;
        if (n <= 2) return 1;

        int firstTerm = tribonacci(n - 1);
        cachedTribonaccis.put(n - 1, firstTerm);

        int secondTerm = tribonacci(n - 2);
        cachedTribonaccis.put(n - 2, secondTerm);

        int thirdTerm = tribonacci(n - 3);
        cachedTribonaccis.put(n - 3, thirdTerm);

        int answer = firstTerm + secondTerm + thirdTerm;
        cachedTribonaccis.put(n, answer);

        return answer;

    } // tribonacci2()


    // Here's another faster version of the recursive solution.
    // This one is similar to the previous version, expect it uses
    // an array rather than a hashmap. I was curious to see if the
    // overhead associated with a hashmap was significant.
    // As expected, this solution performed only slightly better
    // than the hashmap.
    public int tribonacci3(int n) {
        // if we've seen this n before, pull the answer from the cache
        if (cachedTribonaccis2[n] > 0) return cachedTribonaccis2[n];

        if (n == 0) return 0;
        if (n <= 2) return 1;

        int firstTerm = tribonacci(n - 1);
        cachedTribonaccis2[n - 1] = firstTerm;

        int secondTerm = tribonacci(n - 2);
        cachedTribonaccis2[n - 2] = secondTerm;

        int thirdTerm = tribonacci(n - 3);
        cachedTribonaccis2[n - 3] = thirdTerm;

        int answer = firstTerm + secondTerm + thirdTerm;
        cachedTribonaccis2[n] = answer;

        return answer;

    } // tribonacci3()


    public static void main(String[] args) {

        Random rand = new Random(); //instance of random class
        var obj = new NthTribonacciNumber();

        // prime the cache
        //obj.tribonacci3(37);

        var sw1 = new Stopwatch();

        for (int i = 0; i < 1000; i++) {
            int result = obj.tribonacci3(rand.nextInt(37));
        } // for i


        System.out.println("elapsedTime: " + sw1.elapsedTime());

    } // main()


} // class NthTribonacciNumber
