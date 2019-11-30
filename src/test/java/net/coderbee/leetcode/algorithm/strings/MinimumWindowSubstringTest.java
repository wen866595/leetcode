package net.coderbee.leetcode.algorithm.strings;

import static org.junit.Assert.*;

import org.junit.Test;

public class MinimumWindowSubstringTest {

	@Test
	public void test() throws Exception {
		assertTrue("BANC".equals(MinimumWindowSubstring.minWindow("ADOBECODEBANC", "ABC")));
		assertTrue("".equals(MinimumWindowSubstring.minWindow("a", "aa")));
	}

}
