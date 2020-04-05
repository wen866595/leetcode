package net.coderbee.leetcode.algorithm.strings;

import static org.junit.Assert.*;

import org.junit.Test;

public class AtoiTest {

	@Test
	public void test() throws Exception {
		assertEquals(42, Atoi.myAtoi("42"));
		assertEquals(42, Atoi.myAtoi("  +42"));
		assertEquals(-42, Atoi.myAtoi("-42"));
		assertEquals(4193, Atoi.myAtoi("4193 with words"));
		assertEquals(0, Atoi.myAtoi("words and 987"));
		assertEquals(-2147483648, Atoi.myAtoi("-91283472332"));
		assertEquals(2147483647, Atoi.myAtoi("2147483648"));

//		assertEquals(42, Atoi.myAtoiAutomation("42"));
//		assertEquals(42, Atoi.myAtoiAutomation("  +42"));
		assertEquals(-42, Atoi.myAtoiAutomation("-42"));
		assertEquals(4193, Atoi.myAtoiAutomation("4193 with words"));
		assertEquals(0, Atoi.myAtoiAutomation("words and 987"));
		assertEquals(-2147483648, Atoi.myAtoiAutomation("-91283472332"));
		assertEquals(2147483647, Atoi.myAtoiAutomation("2147483648"));
	}

}
