package net.coderbee.leetcode.algorithm.area;

import static org.junit.Assert.*;

import org.junit.Test;

public class SurfaceAreaOf3dShapesTest {

	@Test
	public void test() throws Exception {
		assertEquals(10, SurfaceAreaOf3dShapes.surfaceArea(new int[][] { { 2 } }));
		assertEquals(34, SurfaceAreaOf3dShapes.surfaceArea(new int[][] { { 1, 2 }, { 3, 4 } }));
		assertEquals(16, SurfaceAreaOf3dShapes.surfaceArea(new int[][] { { 1, 0 }, { 0, 2 } }));
		assertEquals(32, SurfaceAreaOf3dShapes.surfaceArea(new int[][] { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } }));
		assertEquals(46, SurfaceAreaOf3dShapes.surfaceArea(new int[][] { { 2, 2, 2 }, { 2, 1, 2 }, { 2, 2, 2 } }));
	}

}
