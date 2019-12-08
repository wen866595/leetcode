package net.coderbee.leetcode.algorithm.array;

public class SortColors {
	// [2,0,2,1,1,0]
	public static void sortColors2(int[] nums) {
		int p0 = 0, p2 = nums.length - 1;
		for (int curr = 0; curr < p2;) {
			if (nums[curr] == 0) {
				int tmp = nums[p0];
				nums[p0] = nums[curr];
				nums[curr] = tmp;
				p0++;
				curr++;
			} else if (nums[curr] == 2) {
				int tmp = nums[p2];
				nums[p2] = nums[curr];
				nums[curr] = tmp;
				p2--;
			} else {
				curr++;
			}
		}
	}

	public static void sortColors(int[] nums) {
		int[] colors = new int[3];
		for (int n : nums) {
			colors[n]++;
		}
		for (int i = 0, n = 0; i < colors.length; i++) {
			for (int j = 0; j < colors[i]; j++, n++) {
				nums[n] = i;
			}
		}
	}

}
