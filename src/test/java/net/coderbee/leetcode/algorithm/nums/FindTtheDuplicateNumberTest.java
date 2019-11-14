package net.coderbee.leetcode.algorithm.nums;

import static org.junit.Assert.*;

import org.junit.Test;

public class FindTtheDuplicateNumberTest {

	@Test
	public void test() throws Exception {
		assertEquals(2, FindTtheDuplicateNumber.findDuplicate(new int[] { 1, 3, 4, 2, 2 }));
		assertEquals(3, FindTtheDuplicateNumber.findDuplicate(new int[] { 3, 1, 3, 4, 2 }));
		assertEquals(1, FindTtheDuplicateNumber.findDuplicate(new int[] { 1, 3, 4, 2, 1 }));
		assertEquals(1, FindTtheDuplicateNumber.findDuplicate(new int[] { 8, 1, 1, 9, 5, 4, 2, 7, 3, 6 }));
		assertEquals(1, FindTtheDuplicateNumber.findDuplicate(new int[] { 1, 1 }));
	}
}
