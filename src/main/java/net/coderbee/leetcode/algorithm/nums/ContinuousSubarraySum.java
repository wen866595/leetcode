package net.coderbee.leetcode.algorithm.nums;

import java.util.HashMap;
import java.util.Map;

/**
 * 523. 连续的子数组和
 * 
 * 给定一个包含非负数的数组和一个目标整数 k，编写一个函数来判断该数组是否含有连续的子数组，其大小至少为 2，总和为 k 的倍数，即总和为 n*k，其中 n
 * 也是一个整数。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/continuous-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class ContinuousSubarraySum {

	// n % k == (n + k) % k
	public static boolean checkSubarraySum(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, -1);
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (k != 0) {
				sum = sum % k;
			}
			if (map.containsKey(sum)) {
				if (i - map.get(sum) > 1) {
					return true;
				}
			} else {
				map.put(sum, i);
			}

		}
		return false;
	}

	public static boolean checkSubarraySum0(int[] nums, int k) {
		for (int i = 0; i < nums.length - 1; i++) {
			if (checkSubarraySum(nums, i, k)) {
				return true;
			}
		}
		return false;
	}

	static boolean checkSubarraySum(int[] nums, int index, int k) {
		int sum = 0;
		for (int i = index; i < nums.length; i++) {
			sum += nums[i];
			if (i - index >= 1 && isValidK(sum, k)) {
				System.out.println("index:" + index + ", i:" + i);
				return true;
			}
		}

		return false;
	}

	static boolean isValidK(int sum, int k) {
		if (k == 0) {
			return sum == 0;
		}
		if (sum == 0) {
			return true;
		}
		return (sum / k) * k == sum;
	}

}
