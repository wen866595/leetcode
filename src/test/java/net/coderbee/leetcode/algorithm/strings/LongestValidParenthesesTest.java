package net.coderbee.leetcode.algorithm.strings;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LongestValidParenthesesTest {

	@Test
	public void test() throws Exception {
		assertEquals(2, LongestValidParentheses.longestValidParentheses("(()"));
		assertEquals(4, LongestValidParentheses.longestValidParentheses(")()())"));
		assertEquals(4, LongestValidParentheses.longestValidParentheses("()())()"));
		assertEquals(8, LongestValidParentheses.longestValidParentheses("(()())()"));
		assertEquals(2, LongestValidParentheses.longestValidParentheses("()(()"));
		assertEquals(6, LongestValidParentheses.longestValidParentheses("()(())"));
	}

}
