/*
20. Valid Parentheses
https://leetcode.com/problems/valid-parentheses/
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:
   * Open brackets must be closed by the same type of brackets.
   * Open brackets must be closed in the correct order.

Constraints:
1 <= s.length <= 104
s consists of parentheses only '()[]{}'.

 */

import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(final String s) {
        if (s.length() == 0) return true;
        if (s.length() % 2 != 0) return false;      // there must be an even number of chars

        var stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {

            final char strParen = s.charAt(i);

            if ((strParen == '(') || (strParen == '{') || (strParen == '[')) {
                stack.push(strParen);

            } else {
                // if the stack is empty at this point,
                // there were more closings than openings e.g., "[]]"
                if (stack.empty()) return false;

                final char stackParen = stack.peek();
                // If we found a closing paren, there must be a matching open paren on the stack
                if ((strParen == ')') && (stackParen != '(')) return false;
                if ((strParen == '}') && (stackParen != '{')) return false;
                if ((strParen == ']') && (stackParen != '[')) return false;
                stack.pop();

            } // if
        } // for i

        // If there are any chars left on the stack,
        // someone forgot to close one or more of the parens, e.g., "())"
        return (stack.empty());

    } // isValid()

    public static void main(String[] args) {

        var p = new ValidParentheses();

        System.out.println(p.isValid(""));           // true
        System.out.println(p.isValid("()"));        // true
        System.out.println(p.isValid("([])"));      // true
        System.out.println(p.isValid("[({})]"));    // true
        System.out.println(p.isValid("[({([{([])}])})]"));    // true

        System.out.println(p.isValid("("));          // false
        System.out.println(p.isValid(")"));          // false
        System.out.println(p.isValid("["));         // false
        System.out.println(p.isValid("]"));        // false
        System.out.println(p.isValid("{"));         // false
        System.out.println(p.isValid("}"));         // false
        System.out.println(p.isValid("[["));        // false
        System.out.println(p.isValid("]]"));        // false
        System.out.println(p.isValid("[]]"));        // false
        System.out.println(p.isValid("[[]"));        // false
        System.out.println(p.isValid("([)]"));      // false
        System.out.println(p.isValid(")("));        // false
        System.out.println(p.isValid("[)(]"));      // false

    } // main()

} // class ValidParentheses
