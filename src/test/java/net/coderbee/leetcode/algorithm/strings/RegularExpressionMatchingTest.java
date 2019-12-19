package net.coderbee.leetcode.algorithm.strings;

import static org.junit.Assert.*;

import org.junit.Test;

public class RegularExpressionMatchingTest {

	@Test
	public void test() throws Exception {
		assertFalse(RegularExpressionMatching.isMatch("aa", "a"));
		assertTrue(RegularExpressionMatching.isMatch("aa", "a*"));
		assertTrue(RegularExpressionMatching.isMatch("aa", ".*"));
		assertTrue(RegularExpressionMatching.isMatch("aab", "c*a*b"));
		assertFalse(RegularExpressionMatching.isMatch("mississippi", "mis*is*p*."));
		assertFalse(RegularExpressionMatching.isMatch("ab", ".*c"));
		assertTrue(RegularExpressionMatching.isMatch("a", "ab*"));
		assertFalse(RegularExpressionMatching.isMatch("a", "ab*a"));
	}

}
