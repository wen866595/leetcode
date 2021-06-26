package net.coderbee.leetcode.algorithm.combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 47. 全排列 II
 *
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 */
public class Permutationsii {

    public static void main(String[] args) {
        System.out.println(permuteUnique(new int[]{1, 1, 2}));
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> rs = new ArrayList<>(nums.length);
        backtrace(nums, rs, new ArrayList<>(nums.length), 0, new boolean[nums.length]);
        return rs;
    }

    private static void backtrace(int[] nums, List<List<Integer>> rs, List<Integer> curAdded,
                                  int index, boolean[] used) {
        if (index == nums.length) {
            rs.add(new ArrayList<>(curAdded));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
                continue;
            }
            curAdded.add(nums[i]);
            used[i] = true;

            backtrace(nums, rs, curAdded, index + 1, used);

            curAdded.remove(index);
            used[i] = false;
        }
    }

}
