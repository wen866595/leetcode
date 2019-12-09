package net.coderbee.leetcode.algorithm.area;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TrappingRainWaterTest {
	@Test
	public void testTrapCached() throws Exception {
		assertEquals(6, TrappingRainWater.trapCached(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }));

		assertEquals(1, TrappingRainWater.trapCached(new int[] { 5, 4, 1, 2 }));

		assertEquals(14, TrappingRainWater.trapCached(new int[] { 5, 2, 1, 2, 1, 5 }));

		assertEquals(83, TrappingRainWater.trapCached(
				new int[] { 6, 4, 2, 0, 3, 2, 0, 3, 1, 4, 5, 3, 2, 7, 5, 3, 0, 1, 2, 1, 3, 4, 6, 8, 1, 3 }));

		assertEquals(3, TrappingRainWater.trapCached(new int[] { 9, 6, 8, 8, 5, 6, 3 }));

	}

	@Test
	public void test() throws Exception {
		assertEquals(6, TrappingRainWater.trap(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }));

		assertEquals(1, TrappingRainWater.trap(new int[] { 5, 4, 1, 2 }));

		assertEquals(14, TrappingRainWater.trap(new int[] { 5, 2, 1, 2, 1, 5 }));

		assertEquals(83, TrappingRainWater
				.trap(new int[] { 6, 4, 2, 0, 3, 2, 0, 3, 1, 4, 5, 3, 2, 7, 5, 3, 0, 1, 2, 1, 3, 4, 6, 8, 1, 3 }));

		assertEquals(3, TrappingRainWater.trap(new int[] { 9, 6, 8, 8, 5, 6, 3 }));

	}

}
