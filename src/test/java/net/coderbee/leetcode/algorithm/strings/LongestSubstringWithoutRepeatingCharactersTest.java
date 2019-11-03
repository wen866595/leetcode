package net.coderbee.leetcode.algorithm.strings;

import org.junit.Assert;
import org.junit.Test;

public class LongestSubstringWithoutRepeatingCharactersTest {

	@Test
	public void test() {
		Assert.assertEquals(3, LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("dvdf"));
		Assert.assertEquals(3, LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("abcabcbb"));
		Assert.assertEquals(1, LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("bbbbb"));
		Assert.assertEquals(3, LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("pwwkew"));
	}

}
