package net.coderbee.leetcode.algorithm.strings;

import static org.junit.Assert.*;

import org.junit.Test;

public class LongestSubstringTest {

	@Test
	public void test() throws Exception {
		assertEquals(3, LongestSubstring.longestSubstring("bbaaacbd", 3));
		assertEquals(3, LongestSubstring.longestSubstring("aaabb", 3));
		assertEquals(5, LongestSubstring.longestSubstring("aaabb", 2));
		assertEquals(0, LongestSubstring.longestSubstring("aaabb", 4));
		assertEquals(5, LongestSubstring.longestSubstring("ababbc", 2));
		assertEquals(6, LongestSubstring.longestSubstring("ababbc", 1));
		
		assertEquals(3, LongestSubstring.longestSubstringNNN("aaabb", 3));
		assertEquals(0, LongestSubstring.longestSubstringNNN("aaabb", 4));
		assertEquals(5, LongestSubstring.longestSubstringNNN("ababbc", 2));
		assertEquals(6, LongestSubstring.longestSubstringNNN("ababbc", 1));
	}

}
