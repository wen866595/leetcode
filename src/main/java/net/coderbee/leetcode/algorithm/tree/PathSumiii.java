package net.coderbee.leetcode.algorithm.tree;

/**
 * 113. 路径总和 III
 * <p>
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 * <p>
 * 找出路径和等于给定数值的路径总数。
 * <p>
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * <p>
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 * <p>
 * https://leetcode-cn.com/problems/path-sum-iii/
 */
public class PathSumiii {

    public static int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return depth(root, sum, 0) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private static int depth(TreeNode root, int sum, int tmpSum) {
        if (root == null) {
            return 0;
        }
        int sum0 = root.val + tmpSum;
        return (sum == sum0 ? 1 : 0) + depth(root.left, sum, sum0) + depth(root.right, sum, sum0);
    }

}
