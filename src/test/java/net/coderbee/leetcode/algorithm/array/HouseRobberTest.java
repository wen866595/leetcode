package net.coderbee.leetcode.algorithm.array;

import static org.junit.Assert.*;

import org.junit.Test;

public class HouseRobberTest {

	@Test
	public void robii() throws Exception {
		assertEquals(3, HouseRobberii.robRecursive(new int[] { 2, 3, 2 }));
		assertEquals(3, HouseRobberii.robRecursive(new int[] { 2, 3 }));
		assertEquals(5, HouseRobberii.robRecursive(new int[] { 5 }));
		assertEquals(4, HouseRobberii.robRecursive(new int[] { 1, 2, 3, 1 }));
		assertEquals(6, HouseRobberii.robRecursive(new int[] { 1, 2, 3, 4, 1 }));

		System.out.println(HouseRobberii.robRecursive(new int[] { 114, 117, 207, 117, 235, 82, 90, 67, 143, 146, 53,
				108, 200, 91, 80, 223, 58, 170, 110, 236, 81, 90, 222, 160, 165, 195, 187, 199, 114, 235, 197, 187, 69,
				129, 64, 214, 228, 78, 188, 67, 205, 94, 205, 169, 241, 202, 144, 240 }));
	}

}
