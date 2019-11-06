package net.coderbee.util;

public class ArrayUtils {

	public static void reverse(int[] nums, int fromIndex, int toIndex) {
		while (fromIndex < toIndex) {
			swap(nums, fromIndex, toIndex);
			fromIndex++;
			toIndex--;
		}
	}

	public static void swap(int[] nums, int i, int j) {
		int t = nums[i];
		nums[i] = nums[j];
		nums[j] = t;
	}

}
