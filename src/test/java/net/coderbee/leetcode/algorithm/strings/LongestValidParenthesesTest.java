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

		assertEquals(2, LongestValidParentheses.bf("(()"));
		assertEquals(4, LongestValidParentheses.bf(")()())"));
		assertEquals(4, LongestValidParentheses.bf("()())()"));
		assertEquals(8, LongestValidParentheses.bf("(()())()"));
		assertEquals(2, LongestValidParentheses.bf("()(()"));
		assertEquals(4, LongestValidParentheses.bf("())()()"));
		assertEquals(6, LongestValidParentheses.bf("()(())"));

		assertEquals(2, LongestValidParentheses.scan("(()"));
		assertEquals(4, LongestValidParentheses.scan(")()())"));
		assertEquals(4, LongestValidParentheses.scan("()())()"));
		assertEquals(8, LongestValidParentheses.scan("(()())()"));
		assertEquals(2, LongestValidParentheses.scan("()(()"));
		assertEquals(4, LongestValidParentheses.scan("())()()"));
		assertEquals(6, LongestValidParentheses.scan("()(())"));
	}

}
