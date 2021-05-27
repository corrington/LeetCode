public class ReverseInteger {

    public static int reverseInteger(int number) {
        if (number == 0) return 0;
        if (number == Integer.MIN_VALUE) return 0;

        int dividend, remainder;
        int result = 0;

        // if the number was negative,
        // remember the facts and make the number positive,
        // so it's easier to work with
        boolean isNegative = number < 0;
        if (isNegative) {
            dividend = number * -1;
        }  else {
            dividend = number;
        } // if

        System.out.println("dividend is " + dividend);

        boolean isWorking = true;
        while (isWorking) {
            // get a copy of the right most digit
            remainder = dividend % 10;
            // slide the existing digits to the left and tack on the new digit
            result = (result * 10) + remainder;
            // peal off the right most digit
            dividend = dividend / 10;
            isWorking = (dividend > 0);
            // check for overflow
            if ((result > 214_748_364) && (dividend > 0)) return 0;
        } // while

        // If the original number was negative, negate the result
        if (isNegative) {
            result *= -1;
        } // if

        return result;
    } // reverseInteger()


    public static void main(String[] args) {
        //System.out.println( -123456 + " becomes " + reverseInteger(-123456));
    } // main()
} // class ReverseInteger
