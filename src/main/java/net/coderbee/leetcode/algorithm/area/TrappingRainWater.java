package net.coderbee.leetcode.algorithm.area;

public class TrappingRainWater {

	public static int trap(int[] height) {
		if (height == null || height.length == 1) {
			return 0;
		}

		return trap(height, 0);
	}

	private static int trap(int[] height, int start) {
		if (start == -1 || start >= height.length) {
			return 0;
		}

		int regionStart = findDownSide(height, start);
		if (regionStart == -1) {
			return 0;
		}
		int regionEnd = -1;
		int pos = regionStart;
		do {
			int bottom = findUpside(height, pos);
			if (bottom == -1) {
				break;
			}
			int tmpEnd = findDownSide(height, bottom + 1);
			if (tmpEnd == -1) {
				break;
			} else {
				pos = tmpEnd;
				if (regionEnd == -1) {
					regionEnd = tmpEnd;
				} else if (height[tmpEnd] >= height[regionEnd]) {
					regionEnd = tmpEnd;
				}
			}
		} while (height[regionEnd] < height[regionStart]);

		if (regionEnd == -1) {
			return 0;
		}

		return area(height, regionStart, regionEnd) + trap(height, regionEnd);
	}

	private static int area(int[] height, int regionStart, int regionEnd) {
		int h = Math.min(height[regionStart], height[regionEnd]);
		int area = (regionEnd - regionStart - 1) * h;
		for (int i = regionStart + 1; i < regionEnd; i++) {
			area -= Math.min(height[i], h);
		}
		System.out.println("regionStart:" + regionStart + ", regionEnd:" + regionEnd + ", area:" + area);
		return area;
	}

	private static int findUpside(int[] height, int start) {
		while (start + 1 < height.length && height[start] >= height[start + 1]) {
			start++;
		}
		return start == height.length ? -1 : start;
	}

	private static int findDownSide(int[] height, int start) {
		while (start + 1 < height.length && height[start] <= height[start + 1]) {
			start++;
		}
		return start == height.length ? -1 : start;
	}

}
