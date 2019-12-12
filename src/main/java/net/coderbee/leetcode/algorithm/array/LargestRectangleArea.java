package net.coderbee.leetcode.algorithm.array;

/**
 * 84. 柱状图中最大的矩形
 * 
 * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 *
 */
public class LargestRectangleArea {

	public static int largestRectangleArea0(int[] heights) {
		if (heights == null || heights.length < 1) {
			return 0;
		}

		return recursive(heights, 0, heights.length - 1);
	}

	private static int recursive(int[] heights, int start, int end) {
		if (start > end) {
			return 0;
		}

		int minH = heights[start], minIndex = start;
		for (int i = start + 1; i <= end; i++) {
			if (heights[i] < minH) {
				minH = heights[i];
				minIndex = i;
			}
		}
		int maxSub = Math.max(recursive(heights, start, minIndex - 1), recursive(heights, minIndex + 1, end));

		return Math.max(maxSub, (end - start + 1) * minH);
	}

	public static int largestRectangleArea(int[] heights) {
		int len;
		if (heights == null || (len = heights.length) < 1) {
			return 0;
		}

		int max = 0;
		for (int i = 0; i < len; i++) {
			int minH = heights[i];
			for (int j = i; j < len; j++) {
				if (heights[j] == 0) {
					break;
				}
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
