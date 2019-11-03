package net.coderbee.leetcode.algorithm.strings;

import org.junit.Assert;
import org.junit.Test;

public class LongestPalindromeTest {

	@Test
	public void test() {
		LongestPalindrome obj = new LongestPalindrome();

		Assert.assertTrue("bababab".equals(obj.longestPalindrome("bababab")));
		Assert.assertTrue("bab".equals(obj.longestPalindrome("babad")));
		Assert.assertTrue("bb".equals(obj.longestPalindrome("cbbd")));
		Assert.assertTrue("a".equals(obj.longestPalindrome("abc")));
		Assert.assertTrue("".equals(obj.longestPalindrome("")));
	}

}
