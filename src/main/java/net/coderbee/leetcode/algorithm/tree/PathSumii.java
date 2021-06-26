package net.coderbee.leetcode.algorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 113. 路径总和 II
 * <p>
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * <p>
 * 叶子节点 是指没有子节点的节点。
 */
public class PathSumii {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> rs = new LinkedList<>();
        dfs(root, targetSum, rs, new ArrayList<>(), 0);
        return rs;
    }

    private static void dfs(TreeNode root, int targetSum, List<List<Integer>> rs, List<Integer> curAdd, int curSum) {
        if (root == null) {
            return;
        }

        int index = curAdd.size();
        curAdd.add(root.val);
        int nextSum = root.val + curSum;

        if (root.left == null && root.right == null && nextSum == targetSum) {
            rs.add(new ArrayList<>(curAdd));
            curAdd.remove(index);
            return;
        }

        dfs(root.left, targetSum, rs, curAdd, nextSum);
        dfs(root.right, targetSum, rs, curAdd, nextSum);

        curAdd.remove(index);
    }

}
