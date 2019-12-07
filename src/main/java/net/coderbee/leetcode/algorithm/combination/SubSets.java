package net.coderbee.leetcode.algorithm.combination;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SubSets {

	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> rs = new LinkedList<List<Integer>>();

		recursive(rs, new ArrayList<Integer>(), nums, 0);
		return rs;
	}

	private static void recursive(List<List<Integer>> rs, List<Integer> list, int[] nums, int index) {
		if (index >= nums.length) {
			rs.add(list);
			return;
		}

		List<Integer> newList = new ArrayList<Integer>(list);
		newList.add(nums[index]);
		recursive(rs, newList, nums, index + 1);

		recursive(rs, list, nums, index + 1);
	}

}
