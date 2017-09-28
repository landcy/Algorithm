package String;

import java.util.Stack;

public class ValidParentheses20 {
	public static boolean isValid(String s) {
		if (s == null || s.length() <= 1) {
			return false;
		}
		Stack<Character> stack = new Stack<>();
		int length = s.length();
		for (int i = 0; i < length; i++) {
			char ch = s.charAt(i);
			if (ch == '{') {
				stack.push('}');
			} else if (ch == '[') {
				stack.push(']');
			} else if (ch == '(') {
				stack.push(')');
			} else if (stack.isEmpty() || stack.peek() != ch) {
				return false;
			} else {
				stack.pop();
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String[] tests = new String[] { "{(})", "d","{d}","", null, "(){}", "{()}", "[]" };
		for (String s : tests) {
			System.out.println(isValid(s));
		}
	}
}
