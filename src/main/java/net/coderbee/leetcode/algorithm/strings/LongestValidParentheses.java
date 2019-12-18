package net.coderbee.leetcode.algorithm.strings;

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

}
