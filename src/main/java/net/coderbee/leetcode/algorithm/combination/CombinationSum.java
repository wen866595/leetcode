package net.coderbee.leetcode.algorithm.combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 39. 组合总和
 * 
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * 
 * candidates 中的数字可以无限制重复被选取。
 * 
 * 说明：
 * 
 * 所有数字（包括 target）都是正整数。 解集不能包含重复的组合。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CombinationSum {

	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> rs = new LinkedList<List<Integer>>();
		Arrays.sort(candidates);
		recursive(rs, new ArrayList<Integer>(), 0, candidates, target, 0);
		return rs;
	}

	private static void recursive(List<List<Integer>> rs, List<Integer> tmp, int tmpSum, int[] candidates, int target,
			int start) {
		if (tmpSum == target) {
			rs.add(tmp);
			return;
		}

		if (tmpSum > target) {
			return;
		}

		for (int i = start; i < candidates.length && tmpSum + candidates[i] <= target; i++) {
			List<Integer> list = new ArrayList<>(tmp);
			list.add(candidates[i]);
			recursive(rs, list, tmpSum + candidates[i], candidates, target, i);
		}
	}

}
