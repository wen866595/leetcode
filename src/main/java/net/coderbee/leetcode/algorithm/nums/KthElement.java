package net.coderbee.leetcode.algorithm.nums;

/**
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 * 
 * @author coderbee
 *
 */
public class KthElement {

	public static void main(String[] args) {
		System.out.println(findKthLargest(new int[] { 3, 2, 1, 5, 6, 4 }, 2));
		System.out.println(findKthLargest(new int[] { 3, 2, 3, 1, 2, 4, 5, 5, 6 }, 4));
		System.out.println(findKthLargest(new int[] { 0, 1, 2, 3 }, 1));
	}

	public static int findKthLargest(int[] nums, int k) {
		int start = 0, end = nums.length - 1, targetIndex = nums.length - k;
		do {
			int pi = partition(nums, start, end);
			if (pi == targetIndex) {
				break;
			} else if (pi < targetIndex) {
				start = pi + 1;
			} else {
				end = pi - 1;
			}
		} while (start < end);

		return nums[targetIndex];
	}

	private static int partition(int[] nums, int start, int end) {
		int pivot = nums[start];
		int j = start; // 指向第一个小于等于 pivot 的元素的下标

		for (int i = start + 1; i <= end; i++) {
			if (nums[i] <= pivot) {
				j++;
				swap(nums, j, i);
			}
		}

		swap(nums, start, j); // j 下标的元素可能是小于 pivot 的，需要进行一次交换 

		return j;
	}

	private static void swap(int[] nums, int start, int end) {
		int tmp = nums[start];
		nums[start] = nums[end];
		nums[end] = tmp;
	}

}
