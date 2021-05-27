public class ZigZagConversion {
/*
6. ZigZag Conversion
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of
rows like this: (you may want to display this pattern in a fixed font for better legibility)

    P   A   H   N
    A P L S I I G
    Y   I   R

And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:
    string convert(string s, int numRows);

Example 1:
Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"

Example 2:
Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:
    P     I    N
    A   L S  I G
    Y A   H R
    P     I

Example 3:
Input: s = "A", numRows = 1
Output: "A"

Constraints:
1 <= s.length <= 1000
s consists of English letters (lower-case and upper-case), ',' and '.'.
1 <= numRows <= 1000
 */
    public static String convert(String s, int numRows) {
        if ((s == null) || (s.length() == 0)) return "";
        if (numRows == 1) return s;

        // create an array of string builders, one for each row
        StringBuilder[] sbs = new StringBuilder[numRows];
        for (int i = 0; i < numRows; ++i) {
            sbs[i] = new StringBuilder();
        } // for i;

        // scan through the string and stuff each letter into its appropriate sb.
        int index = 0;
        boolean isAscending = false;
        for (int i = 0; i < s.length(); ++i) {

            sbs[index].append(s.charAt(i));

            // if we hit the min or the max, we have to flip our direction,
            // like a SIN wave oscillates inside the min and max
            if ((index == 0) || (index == (numRows - 1))) {
                isAscending = ! isAscending;
            }

            index +=  isAscending ? 1 : -1;

        } // for i

        // glue together all of the string builders, convert it to a string, and return it
        StringBuilder sbFinal = new StringBuilder();
        for (var sb : sbs) {
            sbFinal.append(sb);
        }

        String result = sbFinal.toString();
        return result;

    } // convert()

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
        System.out.println("PAHNAPLSIIGYIR\n");
        System.out.println(convert("PAYPALISHIRING", 4));
        System.out.println("PINALSIGYAHRPI\n");
        System.out.println(convert("A", 1));
        System.out.println("A\n");
    } // main()

} // class ZigZagConversion