package net.coderbee.leetcode.algorithm.strings;

import static org.junit.Assert.*;

import org.junit.Test;

public class MagicalStringTest {

	@Test
	public void test() throws Exception {
		assertEquals(2, MagicalString.magicalString(4));
		assertEquals(5, MagicalString.magicalString(10));

		assertEquals(2, MagicalString.magicalStringQueue(4));
		assertEquals(5, MagicalString.magicalStringQueue(10));
	}

}
