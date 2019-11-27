package net.coderbee.leetcode.algorithm.tree;

/**
 * 路径总和 III
 * 
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
