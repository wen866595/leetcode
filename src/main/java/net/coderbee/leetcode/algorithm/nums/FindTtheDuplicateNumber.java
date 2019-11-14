package net.coderbee.leetcode.algorithm.nums;

public class FindTtheDuplicateNumber {

	public static int findDuplicate(int[] nums) {
		int n = nums.length - 1;

		int start = 1, end = n;
		do {
			int mid = start + (end - start) / 2;
			int cnt = 0;
			for (int i : nums) {
				if (i <= mid) {
					cnt++;
				}
			}
			if (cnt > mid) {
				end = mid;
			} else {
				start = mid + 1;
			}
		} while (start < end);

		return start;
	}

}
