package net.coderbee.leetcode.algorithm.area;

public class SurfaceAreaOf3dShapes {

	public static int surfaceArea(int[][] grid) {
		int cnt = 0, cross = 0;
		for (int r = 0; r < grid.length; r++) {
			for (int c = 0; c < grid[r].length; c++) {
				int n = grid[r][c];
				if (n > 0) {
					cnt += n * 4 + 2;
					int up;
					if (r > 0 && (up = grid[r - 1][c]) > 0) {
						cross += Math.min(up, n);
					}
					int left;
					if (c > 0 && (left = grid[r][c - 1]) > 0) {
						cross += Math.min(left, n);
					}
				}
			}
		}

		return cnt - cross * 2;
	}

}
