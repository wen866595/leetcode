package net.coderbee.leetcode.algorithm.area;

import org.junit.Assert;
import org.junit.Test;

public class ContainerWithMostWaterTest {

	@Test
	public void test() {
		ContainerWithMostWater obj = new ContainerWithMostWater();

		Assert.assertEquals(49, obj.maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }));
	}

}
