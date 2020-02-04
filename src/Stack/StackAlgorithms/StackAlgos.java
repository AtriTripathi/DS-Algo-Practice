package Stack.StackAlgorithms;

import Stack.StackImplementations.LinkedStack;

public class StackAlgos {
    public boolean isValidParentheses(String s) {
        LinkedStack<Character> stack = new LinkedStack<>();
        if (s == null || s.length() == 0)
            return true;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (!stack.isEmpty() && stack.peek() == '(')
                    stack.pop();
                else return false;
            }else if (s.charAt(i) == ']') {
                if (!stack.isEmpty() && stack.peek() == '[')
                    stack.pop();
                else return false;
            }else if (s.charAt(i) == '}') {
                if (!stack.isEmpty() && stack.peek() == '{')
                    stack.pop();
                else return false;
            } else {
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String parenthesesToMatch = "{([])}";

        StackAlgos stackAlgos = new StackAlgos();
        boolean isValid = stackAlgos.isValidParentheses(parenthesesToMatch);
        System.out.println("Do the parentheses match \"" + parenthesesToMatch + "\": " + isValid);
    }
}
