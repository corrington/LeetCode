import java.util.ArrayList;
import java.util.HashMap;

public class Summing {

    private static final HashMap<Integer, Long> memoFib = new HashMap<>();
    private static final HashMap<String, Long> memoPaths = new HashMap<>();
    private static final HashMap<Integer, Boolean> memoSums = new HashMap<>();
    private static final HashMap<Integer, int[]> memo4 = new HashMap<>();
    private static final HashMap<Integer, int[]> memoSumBest = new HashMap<>();


    public static long fibClassic(int n) {
        if (n == 0) return 0;
        if ((n == 1) || (n == 2)) return 1;
        return fibClassic(n - 1) + fibClassic(n - 2);
    }

    public static long fibMemo(int n) {
        if (memoFib.containsKey(n)) return memoFib.get(n);
        if (n == 0) return 0;
        if ((n == 1) || (n == 2)) return 1;
        long value = fibMemo(n - 1) + fibMemo(n - 2);
        memoFib.put(n, value);
        return value;
    } // fib()

    public static int maxPathsClassic( int width, int height) {
        if ((width == 0) || (height == 0)) return 0;
        if ((width == 1) || (height == 1)) return 1;
        return  maxPathsClassic(width - 1, height) + maxPathsClassic( width, height -1 );
    } // maxPathsClassic()

    public static long maxPathsMemo( int width, int height) {
        String key = "(" + width + "," + height + ")";
        if (memoPaths.containsKey(key)) return memoPaths.get(key);
        if ((width == 0) || (height == 0)) return 0;
        if ((width == 1) || (height == 1)) return 1;
        long value = maxPathsMemo(width - 1, height) + maxPathsMemo( width, height -1 );
        memoPaths.put(key,value);
        return value;
    } // maxPathsClassic()

    public static boolean canSumClassic( int targetSum, int[] numbers, String leftPadding) {
        System.out.println(leftPadding + "***Starting canSumClassic() with targetSum of " + targetSum);
        if (targetSum < 0) {
            System.out.println(leftPadding + "returning false b/c targetSum < 0");
            return false;
        }
        if (targetSum == 0) {
            System.out.println(leftPadding + "returning true b/c targetSum == 0");
            return true;
        }

        for (int num : numbers) {
            int remainder = targetSum - num;
            System.out.println(leftPadding + remainder + " = " + targetSum + " - " +  num);
            leftPadding = leftPadding + "    ";
            if (canSumClassic(remainder, numbers, leftPadding)) {
                System.out.println(leftPadding + "returning true b/c of remainder " + remainder);
                return true;
            }
        } // for num
        System.out.println(leftPadding + "returning false**");
        return false;
    } // canSumClassic()

    public static boolean canSumMemo( int targetSum, int[] numbers) {

        if (memoSums.containsKey(targetSum)) {
            return memoSums.get(targetSum);
        }

        if (targetSum < 0) {
            return false;
        }
        if (targetSum == 0) {
            return true;
        }

        for (int num : numbers) {
            int remainder = targetSum - num;
            if (canSumMemo(remainder, numbers)) {
                memoSums.put(targetSum,true);
                return true;
            }
        } // for num
        memoSums.put(targetSum,false);
        return false;
    } // canSumMemo()

    public static int[] copyAndAppend( int [] oldArray, int num) {
        int oldLength = oldArray.length;
        int newLength = oldArray.length + 1;
        int[] newArray = new int[newLength];
        System.arraycopy(oldArray,0, newArray,0, oldLength);
        newArray[newLength - 1] = num;
        return newArray;
    }

    public static int[] howSumClassic(int targetSum, int[] numbers) {
        if (targetSum <= 0) return new int[] {};

        for (var num : numbers) {
            int remainder = targetSum - num;
            int[] answers = howSumClassic(remainder,numbers);
            if (answers != null) {
                return copyAndAppend(answers, num);
            }
        } // for num
        return new int[] {};
    } // howSumClassic()

    public static int[] howSumMemo(int targetSum, int[] numbers) {
        if (memo4.containsKey(targetSum)) return memo4.get(targetSum);
        if (targetSum <= 0) return new int[] {};

        for (var num : numbers) {
            int remainder = targetSum - num;
            int[] answers = howSumClassic(remainder,numbers);
            if (answers != null) {
                int[] updatedAnswers = copyAndAppend(answers, num);
                memo4.put(targetSum, updatedAnswers);
                return updatedAnswers;
            }
        } // for num
        memo4.put(targetSum, null);
        return new int[] {};
    } // howSumMemo()

    public static int[] bestSumClassic(int targetSum, int[] numbers) {
        if (targetSum <= 0) return new int[] {};

        int[] shortestCombo = null;
        for (int i = 0; i < numbers.length; ++i) {
            int remainder = targetSum - numbers[i];
            int[] remainderCombo = bestSumClassic(remainder,numbers);
            if (remainderCombo != null) {
                int[] combo = copyAndAppend(remainderCombo, numbers[i]);
                if ((shortestCombo == null) || (combo.length < shortestCombo.length)) {
                    shortestCombo = combo;
                } // if
            } // if
        } // for i
        return shortestCombo;
    } // bestSumClassic()


    public static int[] shortestSumMemo(int targetSum, int[] numbers) {
        if (memoSumBest.containsKey(targetSum)) return memoSumBest.get(targetSum);
        if (targetSum == 0) return new int[] {};
        if (targetSum < 0) return new int[] {};

        int[] shortestCombo = null;
        for (int i = 0; i < numbers.length; ++i) {
            int remainder = targetSum - numbers[i];
            int[] remainderCombo = shortestSumMemo(remainder,numbers);
            if (remainderCombo != null) {
                int[] combo = copyAndAppend(remainderCombo, numbers[i]);
                if ((shortestCombo == null) || (combo.length < shortestCombo.length)) {
                    shortestCombo = combo;
                } // if
            } // if
        } // for i
        memoSumBest.put(targetSum,shortestCombo);
        return shortestCombo;
    } // bestSumMemo()

    public static boolean canConstructClassic(String targetWord, String[] wordBank) {
        if (targetWord.length() == 0) return true;

        for (var word : wordBank) {
            if (targetWord.startsWith(word)) {
                String newTargetWord = targetWord.substring(word.length());
                boolean result = canConstructClassic(newTargetWord, wordBank);
                if(result) return true;
            } // if
        } // for word
        return false;
    } // canConstructClassic()


    private static boolean canConstructMemo(String targetWord, String[] wordBank, HashMap<String, Boolean> memo) {
        if (memo.containsKey(targetWord)) return memo.get(targetWord);
        if (targetWord.length() == 0) return true;

        for (var word : wordBank) {
            if (targetWord.startsWith(word)) {
                String suffix = targetWord.substring(word.length());
                boolean result = canConstructMemo(suffix, wordBank, memo);
                if (result) {
                    memo.put(targetWord, true);
                    return true;
                }
            } // if
        } // for word
        memo.put(targetWord, false);
        return false;
    } // private canConstructMemo()

    public static boolean canConstructMemo(String targetWord, String[] wordBank) {
        final HashMap<String, Boolean> memoHashMap = new HashMap<>();
        boolean result = canConstructMemo(targetWord, wordBank, memoHashMap);
        return result;
    } // public canConstructMemo()

    private static int countConstructMemo(String targetWord, String[] wordBank, HashMap<String, Integer> memo) {
        if (memo.containsKey(targetWord)) return memo.get(targetWord);
        if (targetWord.length() == 0) return 1;

        int totalCombos = 0;
        for (int i = 0; i < wordBank.length; ++i) {
            String word = wordBank[i];
            if (targetWord.startsWith(word)) {
                String suffix = targetWord.substring(word.length());
                totalCombos += countConstructMemo(suffix, wordBank, memo);
            } // if
        } // for i

        memo.put(targetWord, totalCombos);
        return totalCombos;
    } // private countConstructMemo()

    public static int countConstructMemo(String targetWord, String[] wordBank) {
        final HashMap<String, Integer> memoHashMap = new HashMap<>();
        int result = countConstructMemo(targetWord, wordBank, memoHashMap);
        return result;
    } // public countConstructMemo()


    public static  ArrayList<ArrayList<String>> allConstructClassic(String target, String[] fragmentsBank) {
        if (target.length() == 0) {
            var s = new ArrayList<ArrayList<String>>();
            return s;
        }
        var wordCombos = new ArrayList<ArrayList<String>>();
        for (int i = 0; i < fragmentsBank.length; ++i) {
            String fragment = fragmentsBank[i];
            if (target.startsWith(fragment)) {
                String suffix = target.substring(fragment.length());
                var result = allConstructClassic(suffix, fragmentsBank);

                if (result.size() == 0) {
                    // we have our first fragment of our first combo
                    ArrayList<String> s = new ArrayList<>();
                    s.add(fragment);
                    wordCombos.add(s);
                } // if
            } // if
        } // for i

        return wordCombos;

    } // allConstructClassic()


    public static void main(String[] args) {
        System.out.println(allConstructClassic("purple", new String[] { "purp", "p", "ur", "le", "purpl"})); // 2
        //System.out.println(countConstructMemo("abcdef", new String[] { "ab", "abc", "cd", "def", "abcd"})); // 1
        //System.out.println(countConstructMemo("skateboard", new String[] { "bo", "rd", "ate", "t", "ska", "sk", "boar" })); // 0
        //System.out.println(countConstructMemo("", new String[] { "cat", "dog", "mouse"})); // 1
        //System.out.println(countConstructMemo("enterapotentpot", new String[] { "a", "p", "ent", "enter", "ot", "o", "t"})); // 4
        //System.out.println(countConstructMemo("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[] { "e", "ee", "eee", "eeee", "eeeee"})); // 0

        System.out.println();
    } // main ()

    public static class Stopwatch {

        private long startTime;

        // Initializes a new stopwatch.
        public Stopwatch() {
            startTime = System.nanoTime();
        } // Stopwatch()

        // Returns the elapsed CPU time (in nanoseconds) since the stopwatch was created.
        // @return elapsed CPU time (in nanoseconds) since the stopwatch was created
        public double elapsedTime() {
            long nowTime = System.nanoTime();
            return (nowTime - startTime);
            //return (nowTime - startTime) / 1000.0;
        } // elapsedTime()

        public void reset() {
            startTime = System.currentTimeMillis();
        } // reset()

    } // class Stopwatch
} // class Summing
