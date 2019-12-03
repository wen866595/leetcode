package net.coderbee.leetcode.algorithm.combination;

import java.util.ArrayList;
import java.util.List;

/**
 * 216. 组合总和 III
 * 
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 * 
 * 说明：
 * 
 * 所有数字都是正整数。 解集不能包含重复的组合。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/combination-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class CombinationSumiii {

	public static List<List<Integer>> combinationSum3(int k, int sum) {
		List<List<Integer>> rs = new ArrayList<List<Integer>>();
		recursive(rs, new ArrayList<Integer>(), 0, 1, sum, k);
		return rs;
	}

	private static void recursive(List<List<Integer>> rs, List<Integer> tmp, int tmpSum, int current, int sum, int k) {
		if (tmpSum == sum && tmp.size() == k) {
			rs.add(new ArrayList<Integer>(tmp));
			return;
		}

		if (current > 9) {
			return;
		}

		if (tmpSum + current <= sum) {
			List<Integer> list = new ArrayList<Integer>(tmp);
			list.add(current);
			recursive(rs, list, tmpSum + current, current + 1, sum, k);
		}

		if (current + 1 <= sum) {
			recursive(rs, tmp, tmpSum, current + 1, sum, k);
		}
	}
}
