package net.coderbee.leetcode.algorithm.combination;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 78. 子集
 *
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 */
public class SubSets {

	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> rs = new LinkedList<>();

		backtrace(rs, new ArrayList<>(), nums, 0);
		return rs;
	}

	private static void backtrace(List<List<Integer>> rs, ArrayList<Integer> list, int[] nums, int index) {
		rs.add(new ArrayList<>(list));
		for(int i = index; i < nums.length; i++) {
			list.add(nums[i]);
			backtrace(rs, list, nums, i + 1);
			list.remove(list.size() - 1);
		}
	}

	public static List<List<Integer>> subsets0(int[] nums) {
		List<List<Integer>> rs = new LinkedList<>();

		dfs(rs, new ArrayList<>(), nums, 0);
		return rs;
	}

	private static void dfs(List<List<Integer>> rs, ArrayList<Integer> list, int[] nums, int index) {
		if (index >= nums.length) {
			rs.add(new ArrayList<>(list));
			return;
		}

		dfs(rs, list, nums, index + 1);

		ArrayList<Integer> next = new ArrayList<>(list);
		next.add(nums[index]);
		dfs(rs, next, nums, index + 1);
	}
}
