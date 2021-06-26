package net.coderbee.leetcode.algorithm.combination;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. 全排列
 * <p>
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 */
public class Permutations {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> rs = new ArrayList<>();
        backtrace(nums, rs, 0);
        return rs;
    }

    private static void backtrace(int[] nums, List<List<Integer>> rs, int index) {
        if (index == nums.length) {
            rs.add(array2list(nums));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            swap(nums, i, index);
            backtrace(nums, rs, index + 1);
            swap(nums, i, index);
        }

    }

    private static void swap(int[] nums, int i, int j) {
        int n = nums[i];
        nums[i] = nums[j];
        nums[j] = n;
    }

    private static List<Integer> array2list(int[] nums) {
        List<Integer> list = new ArrayList<>(nums.length);
        for (int n : nums) {
            list.add(n);
        }
        return list;
    }

}
