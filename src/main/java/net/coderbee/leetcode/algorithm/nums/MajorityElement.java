package net.coderbee.leetcode.algorithm.nums;

public class MajorityElement {

	/**
	 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。 <br/>
	 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
	 */
	public static int majorityElement(int[] nums) {
		int target = 0, cnt = 0;
		for (int i : nums) {
			if (cnt == 0) {
				target = i;
				cnt++;
			} else {
				if (target == i) {
					cnt++;
				} else {
					cnt--;
				}
			}
		}

		return target;
	}

}
