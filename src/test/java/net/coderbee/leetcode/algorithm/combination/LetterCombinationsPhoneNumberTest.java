package net.coderbee.leetcode.algorithm.combination;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class LetterCombinationsPhoneNumberTest {

	@Test
	public void test() {
		List<String> excepted = Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf");
		List<String> list = LetterCombinationsPhoneNumber.letterCombinations("23");
		System.out.println(list);
		Assert.assertTrue(excepted.size() == list.size());
		Assert.assertTrue(excepted.containsAll(list) && list.containsAll(excepted));
	}

}
