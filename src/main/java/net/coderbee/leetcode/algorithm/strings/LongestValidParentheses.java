package net.coderbee.leetcode.algorithm.strings;

import java.util.Stack;

public class LongestValidParentheses {

	public static int longestValidParentheses(String s) {
		if (s == null || s.length() <= 1) {
			return 0;
		}

		int max = 0;
		int[] dp = new int[s.length()];
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == ')') {
				if (s.charAt(i - 1) == '(') {
					// ()()
					dp[i] = 2 + (i >= 2 ? dp[i - 2] : 0);
				} else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
					// ()(()())
					dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] >= 2 ? dp[i - dp[i - 1] - 2] : 0);
				}
				max = Math.max(max, dp[i]);
			}
		}

		return max;
	}

	public static int bf(String s) {
		if (s == null || s.length() < 2) {
			return 0;
		}

		int max = 0;
		for (int i = 0; i < s.length() - max; i++) {
			Stack<Character> stack = new Stack<Character>();
			for (int j = i + 1; j < s.length(); j += 2) {
				if (isValid(stack, s, j - 1, j)) {
					max = Math.max(max, j - i + 1);
				} else if (!stack.isEmpty() && stack.elementAt(0) == ')') {
					i = j - 1;
					break;
				}
			}
		}

		return max;
	}

	static boolean isValid(Stack<Character> stack, String s, int start, int end) {
		for (int i = start; i <= end; i++) {
			if (s.charAt(i) == '(') {
				stack.push('(');
			} else {
				if (!stack.isEmpty() && stack.peek() == '(') {
					stack.pop();
				} else {
					stack.push(')');
					break;
				}
			}
		}
		return stack.isEmpty();
	}

}
