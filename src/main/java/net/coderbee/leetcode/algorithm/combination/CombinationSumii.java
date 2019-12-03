package net.coderbee.leetcode.algorithm.combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * 
 * candidates 中的每个数字在每个组合中只能使用一次。
 * 
 * 说明：
 * 
 * 所有数字（包括目标数）都是正整数。 解集不能包含重复的组合。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/combination-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 */
public class CombinationSumii {

	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> rs = new ArrayList<>();
		recursive(rs, new ArrayList<Integer>(), 0, candidates, target, 0);
		return rs;
	}

	private static void recursive(List<List<Integer>> rs, List<Integer> tmp, int tmpSum, int[] candidates, int target,
			int start) {
		if (tmpSum == target) {
			if (!rs.contains(tmp)) {
				rs.add(tmp);
			}
			return;
		}
		if (tmpSum > target || start == candidates.length) {
			return;
		}

		if (candidates[start] + tmpSum <= target) {
			List<Integer> list = new ArrayList<>(tmp);
			list.add(candidates[start]);
			recursive(rs, list, tmpSum + candidates[start], candidates, target, start + 1);
		}
		recursive(rs, tmp, tmpSum, candidates, target, start + 1);
	}

}
