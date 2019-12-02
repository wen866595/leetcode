package net.coderbee.leetcode.algorithm.strings;

import static org.junit.Assert.*;

import org.junit.Test;

public class ValidParenthesesTest {

	@Test
	public void test() throws Exception {
		assertTrue(ValidParentheses.isValid("()"));
		assertTrue(ValidParentheses.isValid("()[]{}"));
		assertTrue(ValidParentheses.isValid("{[]}"));
		assertFalse(ValidParentheses.isValid("(]"));
		assertFalse(ValidParentheses.isValid("([)]"));
	}

}
