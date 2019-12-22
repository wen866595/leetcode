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
				if (matrix[r][c] == '1' && pureArea(r, c, matrix.length - 1, matrix[r].length - 1) > max) {
					trace(matrix, r, c, r, c);
				}
			}
		}

		System.out.println("\n\n\n");
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
		if (nextCol < matrix[curRow].length) {
			boolean addRight = true;
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
		if (nextRow < matrix.length) {
			boolean addNextRow = true;
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

	final int pureArea(int startRow, int startCol, int curRow, int curCol) {
		return (curRow - startRow + 1) * (curCol - startCol + 1);
	}

	int calcArea(int startRow, int startCol, int curRow, int curCol) {
		int area = pureArea(startRow, startCol, curRow, curCol);
		System.out.println(
				"startRow:" + startRow + ", startCol:" + startCol + ", curRow:" + curRow + ", curCol:" + curCol);
		max = Math.max(max, area);
		return area;
	}

}
