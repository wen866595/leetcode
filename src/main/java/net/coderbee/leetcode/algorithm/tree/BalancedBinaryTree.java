package net.coderbee.leetcode.algorithm.tree;

/**
 * 110. 平衡二叉树
 * <p>
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * <p>
 * 本题中，一棵高度平衡二叉树定义为：
 * <p>
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 */
public class BalancedBinaryTree {

    // 题解，执行时间 1ms，
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int l = getDepth(root.left);
        int r = getDepth(root.right);
        return Math.abs(l - r) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }

    // 我的，执行时间 3ms。
    // 理论上当发现不满足时进行了剪枝，但耗时更长，是因为比较太多、非尾递归？
    public static boolean mine(TreeNode root) {
        int depth = dfs(root);
        return depth != -1;
    }

    private static int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        System.out.println(root.val);

        int leftDepth = dfs(root.left);
        if (leftDepth == -1) {
            return -1;
        }
        int rightDepth = dfs(root.right);
        if (rightDepth == -1) {
            return -1;
        }

        if (Math.abs(leftDepth - rightDepth) > 1) {
            return -1;
        }

        return Math.max(leftDepth, rightDepth) + 1;
    }

}
