package net.coderbee.leetcode.algorithm.strings;

import static org.junit.Assert.*;

import org.junit.Test;

public class EditDistanceTest {

	@Test
	public void test() throws Exception {
		assertEquals(3, EditDistance.minDistance("horse", "ros"));
		assertEquals(5, EditDistance.minDistance("intention", "execution"));
	}

}
