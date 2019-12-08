package net.coderbee.leetcode.algorithm.array;

import java.util.Arrays;

public class Search2dMatrixii {

	public static boolean searchMatrix(int[][] matrix, int target) {
		if (matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}
		int rowStart = 0;
		while (rowStart < matrix.length && matrix[rowStart][0] <= target) {
			rowStart++;
		}

		for (int i = 0; i < rowStart; i++) {
			if (matrix[i][matrix[i].length - 1] >= target && Arrays.binarySearch(matrix[i], target) >= 0) {
				return true;
			}
		}

		return false;
	}

}
