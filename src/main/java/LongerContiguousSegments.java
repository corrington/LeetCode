public class LongerContiguousSegments {



    public static boolean checkZeroOnes(String s) {
        int currZeros = 0;
        int longestZeros = 0;
        int currOnes = 0;
        int longestOnes = 0;
        boolean isCountingZeros = true;

        for (int i = 0; i < s.length(); ++i) {
            char digit = s.charAt(i);
        if (isCountingZeros) {
            if (digit == '0') {
                currZeros++;
            } else {
                longestZeros = Math.max(longestZeros, currZeros);
                currZeros = 0;
                isCountingZeros = false;
            }
        } else {
            if (digit == '1') {
                currOnes++;
            } else {
                longestOnes = Math.max(longestOnes, currOnes);
                currOnes = 0;
                isCountingZeros = true;
            }
        }
        } // for i

        return longestOnes > longestZeros;

    } // checkZeroOnes()


    public static void main(String[] args){
        System.out.println(checkZeroOnes("1101") + " should be true");
        System.out.println(checkZeroOnes("111000") + " should be false");
        System.out.println(checkZeroOnes("110100010") + " should be false");
    } // main()

} // class LongerContiguousSegments()