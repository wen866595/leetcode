package net.coderbee.leetcode.algorithm.array;

/**
 * 1095. 山脉数组中查找目标值
 * 
 * https://leetcode-cn.com/problems/find-in-mountain-array/
 *
 */
public class FindInMountainArray {

	public static int findInMountainArray(int target, MountainArray arr) {
		int topIndex = findInMountainTop(arr, 0, arr.length() - 1);

		int pi = findInSortArr(target, arr, 0, topIndex, true);
		if (pi != -1) {
			return pi;
		}
		return findInSortArr(target, arr, topIndex + 1, arr.length() - 1, false);
	}

	static int findInMountainTop(MountainArray arr, int start, int end) {
		while (start < end) {
			int mid = start + (end - start) / 2;
			if (arr.get(mid) < arr.get(mid + 1)) {
				start = mid + 1;
			} else {
				end = mid;
			}
		}

		return start;
	}

	static int findInSortArr(int target, MountainArray arr, int start, int end, boolean asc) {
		while (start <= end) {
			int mid = start + (end - start) / 2;
			int midv = arr.get(mid);
			if (midv == target) {
				return mid;
			}
			if (midv < target) {
				start = asc ? mid + 1 : start;
				end = asc ? end : mid - 1;
			} else {
				start = asc ? start : mid + 1;
				end = asc ? mid - 1 : end;
			}
		}
		return -1;
	}

}
