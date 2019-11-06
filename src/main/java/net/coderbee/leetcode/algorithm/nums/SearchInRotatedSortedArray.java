package net.coderbee.leetcode.algorithm.nums;

import java.util.Arrays;

/**
 * 搜索旋转排序数组<br/>
 * <br/>
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。<br/>
 * <br/>
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。<br/>
 * <br/>
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。<br/>
 * <br/>
 * 你可以假设数组中不存在重复的元素。<br/>
 * <br/>
 * 你的算法时间复杂度必须是 O(log n) 级别。<br/>
 * 
 * 示例 1:<br/>
 * 输入: nums = [4,5,6,7,0,1,2], target = 0 输出: 4<br/>
 * 
 * 示例 2:<br/>
 * 输入: nums = [4,5,6,7,0,1,2], target = 3 输出: -1<br/>
 * <br/>
 * 来源：力扣（LeetCode）<br/>
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array<br/>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class SearchInRotatedSortedArray {

	// 对于旋转的排序数组，任意一个中间的元素都可能把数组划分为两部分：有序、旋转的
	// 对于有序部分可以采用折半查找，找不到再递归搜索旋转的部分
	public static int search(int[] nums, int target) {
		if (nums == null || nums.length < 1) {
			return -1;
		}

		int low = 0, high = nums.length - 1;
		return search(nums, target, low, high);
	}

	private static int search(int[] nums, int target, int low, int high) {
		if (low > high) {
			return -1;
		}
		int mid = low + (high - low) / 2;
		if (nums[mid] == target) {
			return mid;
		}

		if (nums[low] < nums[mid]) {
			int i = Arrays.binarySearch(nums, low, mid, target);
			if (i >= 0) {
				return i;
			}
			return search(nums, target, mid + 1, high);
		} else {
			int i = Arrays.binarySearch(nums, mid + 1, high + 1, target);
			if (i >= 0) {
				return i;
			}
			return search(nums, target, low, mid - 1);
		}
	}

}
