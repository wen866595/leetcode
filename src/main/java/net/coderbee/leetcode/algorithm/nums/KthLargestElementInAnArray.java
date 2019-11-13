package net.coderbee.leetcode.algorithm.nums;

public class KthLargestElementInAnArray {

	public static int findKthLargest(int[] nums, int k) {
		int start = 0, end = nums.length - 1;
		int targetIndex = nums.length - k;
		do {
			int pi = partition(nums, start, end);
			if (targetIndex == pi) {
				return nums[pi];
			} else if (pi > targetIndex) {
				end = pi - 1;
			} else {
				start = pi + 1;
			}
		} while (true);
	}

	private static int partition(int[] nums, int start, int end) {
		int lstart = start;
		int pivot = nums[start];

		do {
			while (start <= end && nums[start] <= pivot)
				start++;

			while (start <= end && nums[end] > pivot)
				end--;

			if (start < end) {
				swap(nums, start, end);
			}

		} while (start <= end);

		swap(nums, lstart, end);

		return end;
	}

	private static void swap(int[] nums, int start, int end) {
		int t = nums[start];
		nums[start] = nums[end];
		nums[end] = t;
	}

}
