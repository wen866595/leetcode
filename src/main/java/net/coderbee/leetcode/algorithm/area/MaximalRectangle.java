package net.coderbee.leetcode.algorithm.area;

public class MaximalRectangle {
	int max = 0;

	public int maximalRectangle(char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}

		max = 0;
		for (int r = 0; r < matrix.length; r++) {
			for (int c = 0; c < matrix[r].length; c++) {
				if (matrix[r][c] == '1') {
					trace(matrix, r, c, r, c);
				}
			}
		}

//		System.out.println("\n\n\n");
		return max;
	}

	void trace(char[][] matrix, int startRow, int startCol, int curRow, int curCol) {
		calcArea(startRow, startCol, curRow, curCol);

		// 行加 1
		boolean addNextRow = traceDown(matrix, startRow, startCol, curRow, curCol);

		// 列加 1
		boolean addNextCol = traceRight(matrix, startRow, startCol, curRow, curCol);

		// 行列都加 1
		int nextRow = curRow + 1;
		int nextCol = curCol + 1;
		if (addNextRow && addNextCol && matrix[nextRow][nextCol] == '1') {
			trace(matrix, startRow, startCol, nextRow, nextCol);
		}
	}

	boolean traceRight(char[][] matrix, int startRow, int startCol, int curRow, int curCol) {
		int nextCol = curCol + 1;
		boolean addRight = nextCol < matrix[curRow].length;
		if (addRight) {
			for (int r = startRow; r <= curRow; r++) {
				if (matrix[r][nextCol] == '0') {
					addRight = false;
					break;
				}
			}
			if (addRight) {
				calcArea(startRow, startCol, curRow, curCol + 1);
				traceRight(matrix, startRow, startCol, curRow, curCol + 1);
				return true;
			}
		}
		return false;
	}

	boolean traceDown(char[][] matrix, int startRow, int startCol, int curRow, int curCol) {
		int nextRow = curRow + 1;
		boolean addNextRow = nextRow < matrix.length;
		if (addNextRow) {
			for (int c = startCol; c <= curCol; c++) {
				if (matrix[nextRow][c] == '0') {
					addNextRow = false;
					break;
				}
			}
			if (addNextRow) {
				calcArea(startRow, startCol, curRow + 1, curCol);
				traceDown(matrix, startRow, startCol, curRow + 1, curCol);
				return true;
			}
		}
		return false;
	}

	int calcArea(int startRow, int startCol, int curRow, int curCol) {
		int area = (curRow - startRow + 1) * (curCol - startCol + 1);
//		System.out.println(
//				"startRow:" + startRow + ", startCol:" + startCol + ", curRow:" + curRow + ", curCol:" + curCol);
		max = Math.max(max, area);
		return area;
	}

}
