package net.coderbee.leetcode.algorithm.strings;

import static org.junit.Assert.*;

import org.junit.Test;

public class DecodeStringTest {

	@Test
	public void test() throws Exception {
		assertTrue("aaabFFFFcbFFFFc".equals(DecodeString.decodeString0("3[a]2[b4[F]c]")));
		assertTrue("aaabcbc".equals(DecodeString.decodeString0("3[a]2[bc]")));
		assertTrue("accaccacc".equals(DecodeString.decodeString0("3[a2[c]]")));
		assertTrue("abcabccdcdcdef".equals(DecodeString.decodeString0("2[abc]3[cd]ef")));

		assertTrue("aaabFFFFcbFFFFc".equals(DecodeString.decodeString("3[a]2[b4[F]c]")));
		assertTrue("aaabcbc".equals(DecodeString.decodeString("3[a]2[bc]")));
		assertTrue("accaccacc".equals(DecodeString.decodeString("3[a2[c]]")));
		assertTrue("abcabccdcdcdef".equals(DecodeString.decodeString("2[abc]3[cd]ef")));
	}
}
