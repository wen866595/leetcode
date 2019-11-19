package net.coderbee.leetcode.algorithm.nums;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {

	/**
	 * 滑动窗口最大值
	 * 
	 * 
	 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
	 * 
	 * 返回滑动窗口中的最大值。
	 * 
	 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/sliding-window-maximum
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 * 
	 * @param nums
	 * @param k
	 * @return
	 */
	public static int[] maxSlidingWindow(int[] nums, int k) {
		if (nums == null || nums.length < 1) {
			return new int[] {};
		}

		if (k == 0) {
			return new int[] { 0 };
		}
		if (k == 1) {
			return nums;
		}

		int[] rs = new int[nums.length - k + 1];
		Deque<Integer> deque = new LinkedList<>();

		for (int i = 0; i < k - 1; i++) {
			cleanDeque(deque, i, k, nums);

		}

		for (int i = k - 1; i < nums.length; i++) {
			cleanDeque(deque, i, k, nums);
			rs[i - k + 1] = nums[deque.getFirst()];
		}

		return rs;
	}

	private static void cleanDeque(Deque<Integer> deque, int i, int k, int[] nums) {
		// 如果两端队列里的元素数量大于等于 K 个，则移除队首的。
		// 确保了队列里最多有 k 个元素
		if (!deque.isEmpty() && i - deque.getFirst() >= k) {
			// 只移除队首元素是利用了窗口只会消除队首元素，在队列加入新的元素。
			deque.removeFirst();
		}

		// 极端情况下，队列里的元素是有序的。
		// 如果是升序，执行完下面的循环后，队列里都是空的，
		// 如果是降序，队列里最多有 k 个元素。
		while (!deque.isEmpty() && nums[i] > nums[deque.getLast()]) {
			deque.removeLast();
		}

		deque.addLast(i);
	}

}
