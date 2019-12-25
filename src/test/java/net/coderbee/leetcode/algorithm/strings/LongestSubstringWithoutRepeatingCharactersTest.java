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

		Assert.assertEquals(3, LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstringLine("dvdf"));
		Assert.assertEquals(3, LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstringLine("abcabcbb"));
		Assert.assertEquals(1, LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstringLine("bbbbb"));
		Assert.assertEquals(3, LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstringLine("pwwkew"));
		Assert.assertEquals(5, LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstringLine("tmmzuxt"));

		Assert.assertEquals(3, LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstringBetter("dvdf"));
		Assert.assertEquals(3, LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstringBetter("abcabcbb"));
		Assert.assertEquals(1, LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstringBetter("bbbbb"));
		Assert.assertEquals(3, LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstringBetter("pwwkew"));
		Assert.assertEquals(5, LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstringBetter("tmmzuxt"));
	}

}
