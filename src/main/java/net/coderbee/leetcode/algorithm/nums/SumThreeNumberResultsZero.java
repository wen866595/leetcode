package net.coderbee.leetcode.algorithm.nums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 三数之和<br/>
 * <br/>
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0<br/>
 * ？找出所有满足条件且不重复的三元组。<br/>
 * <br/>
 * 注意：答案中不可以包含重复的三元组。<br/>
 * <br/>
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，<br/>
 * 
 * 满足要求的三元组集合为：<br/>
 * [<br/>
 * [-1, 0, 1],<br/>
 * [-1, -1, 2]<br/>
 * ]<br/>
 * <br/>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/3sum<br/>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。<br/>
 * 
 * @author coderbee
 */
public class SumThreeNumberResultsZero {

	// a + b + c = 0 转换为 a + b = -c
	// 这样可以求出两数之和再在后续的元素中查找 反数，把复杂度从 N*N*N 降低为 N*N*lg(N)
	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);

		List<List<Integer>> rs = new ArrayList<>();
		for (int i = 0; i < nums.length - 2; i++) {
			for (int j = i + 1; j < nums.length - 1; j++) {
				int sum = -(nums[i] + nums[j]);
				int k = Arrays.binarySearch(nums, j + 1, nums.length, sum);
				if (k < 0) {
					continue;
				}

				List<Integer> ints = Arrays.asList(nums[i], nums[j], nums[k]);
				Collections.sort(ints);

				boolean exists = isExists(rs, ints);
				if (!exists) {
					rs.add(ints);
				}
			}
		}

		return rs;
	}

	private boolean isExists(List<List<Integer>> rs, List<Integer> ints) {
		boolean exists = false;
		for (List<Integer> other : rs) {
			if (other.get(0).intValue() == ints.get(0).intValue() && other.get(1).intValue() == ints.get(1).intValue()
					&& other.get(2).intValue() == ints.get(2).intValue()) {
				exists = true;
				break;
			}
		}
		return exists;
	}

}
