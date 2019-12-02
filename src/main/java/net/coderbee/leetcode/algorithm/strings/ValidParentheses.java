package net.coderbee.leetcode.algorithm.strings;

import java.util.Stack;

public class ValidParentheses {

	public static boolean isValid(String s) {
		if (s == null || s.isEmpty()) {
			return true;
		}

		Stack<Character> stack = new Stack<>();
		for (char ch : s.toCharArray()) {
			if (ch == '[' || ch == '{' || ch == '(') {
				stack.push(ch);
			} else if (ch == ']') {
				if (stack.isEmpty() || stack.pop() != '[') {
					return false;
				}
			} else if (ch == '}') {
				if (stack.isEmpty() || stack.pop() != '{') {
					return false;
				}
			} else if (ch == ')') {
				if (stack.isEmpty() || stack.pop() != '(') {
					return false;
				}
			}
		}

		return stack.isEmpty();
	}

}
