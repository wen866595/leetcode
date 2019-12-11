package net.coderbee.leetcode.algorithm.array;

/**
 * 84. 柱状图中最大的矩形
 * 
 * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 *
 */
public class LargestRectangleArea {

	public static int largestRectangleArea(int[] heights) {
		int len;
		if (heights == null || (len = heights.length) < 1) {
			return 0;
		}

		int max = 0;
		for (int i = 0; i < len; i++) {
			int minH = heights[i];
			for (int j = i; j < len; j++) {
				minH = Math.min(minH, heights[j]);
				int tmpArea = (j - i + 1) * minH;
				if (tmpArea > max) {
					max = tmpArea;
				}
			}
		}

		return max;
	}

}
