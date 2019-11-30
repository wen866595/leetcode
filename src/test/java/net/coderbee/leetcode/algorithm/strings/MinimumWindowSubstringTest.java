package net.coderbee.leetcode.algorithm.strings;

import static org.junit.Assert.*;

import org.junit.Test;

public class MinimumWindowSubstringTest {

	@Test
	public void test() throws Exception {
		assertTrue("baca".equals(MinimumWindowSubstring.minWindow("acbbaca", "aba")));
		assertTrue("BANC".equals(MinimumWindowSubstring.minWindow("ADOBECODEBANC", "ABC")));
		assertTrue("BANC".equals(MinimumWindowSubstring.minWindow("ADOBECODEBBBANC", "ABC")));
		assertTrue("".equals(MinimumWindowSubstring.minWindow("a", "aa")));
	}

}
