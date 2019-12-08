package net.coderbee.leetcode.algorithm.array;

import static org.junit.Assert.*;

import org.junit.Test;

public class Search2dMatrixiiTest {

	@Test
	public void test() throws Exception {
		int[][] matrix = new int[][] { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 },
				{ 10, 13, 14, 17, 24 }, { 18, 21, 23, 26, 30 } };

		assertTrue(Search2dMatrixii.searchMatrix(matrix, 5));
		assertFalse(Search2dMatrixii.searchMatrix(matrix, 20));

		int[][] matrix2 = new int[][] { { 5 }, { 6 } };
		assertTrue(Search2dMatrixii.searchMatrix(matrix2, 5));
	}

}
