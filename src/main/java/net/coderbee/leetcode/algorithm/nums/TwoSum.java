package net.coderbee.leetcode.algorithm.nums;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * 
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 
 * 示例:
 * 
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 
 * 因为 nums[0] + nums[1] = 2 + 7 = 9 所以返回 [0, 1]
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class TwoSum {
	// a + b = target

	// 除了 map 外另一种思路是用索引数组。
	
	public static int[] twoSum(int[] nums, int target) {
		// a + b = target
		// 因为只会产生唯一输出，可以认为 a+b 是唯一的组合，即数字是不重复的，重复的在 map 构建时处理。
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				// 处理重复的数字
				if (nums[i] + nums[i] == target) {
					return new int[] { map.get(nums[i]), i };
				}
			} else {
				int other = target - nums[i];
				if (map.containsKey(other)) {
					return new int[] { map.get(other), i };
				}
				map.put(nums[i], i);
			}
		}

		return new int[2];
	}

	public static int[] bruteForce(int[] nums, int target) {
		int i, j = -1;

		out: for (i = 0; i < nums.length - 1; i++) {
			int other = target - nums[i];
			for (j = i + 1; j < nums.length; j++) {
				if (nums[j] == other) {
					break out;
				}
			}
		}

		return new int[] { i, j };
	}
}
