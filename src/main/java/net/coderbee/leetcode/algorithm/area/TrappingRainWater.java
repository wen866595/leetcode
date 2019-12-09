package net.coderbee.leetcode.algorithm.area;

public class TrappingRainWater {

	public static int trapCached(int[] height) {
		if (height == null || height.length <= 1) {
			return 0;
		}

		int[] cache = new int[height.length];
		// 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1
		cache[0] = height[0];
		for (int i = 1; i < height.length; i++) {
			if (height[i] > height[i - 1]) {
				cache[i - 1] = 0;
				cache[i] = height[i];
			} else if (height[i] < height[i - 1]) {
				cache[i] = 0;
			}
		}

		return calc(height, cache);
	}

	private static int calc(int[] height, int[] cache) {
		int start = 0;
		while (start < cache.length && cache[start] == 0) {
			start++;
		}
		if (start == cache.length) {
			return 0;
		}

		int area = 0;
		do {
			int end = -1;
			int pos = start + 1;
			while (pos < cache.length) {
				if (cache[pos] != 0) {
					if (end == -1) {
						end = pos;
					}

					if (cache[pos] >= cache[start]) {
						end = pos;
						break;
					} else if (cache[pos] > cache[end]) {
						end = pos;
					}
				}

				pos++;
			}
			if (end == -1) {
				break;
			}

			area += area(height, start, end);

			start = end;
		} while (start < cache.length);

		return area;
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
