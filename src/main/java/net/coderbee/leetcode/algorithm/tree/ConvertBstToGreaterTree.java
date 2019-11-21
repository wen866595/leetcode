package net.coderbee.leetcode.algorithm.tree;

public class ConvertBstToGreaterTree {

	/**
	 * 把二叉搜索树转换为累加树
	 * 
	 * https://leetcode-cn.com/problems/convert-bst-to-greater-tree/
	 */
	public static TreeNode convertBST(TreeNode root) {
		if (root == null) {
			return null;
		}

		convertBST0(root, null);
		return root;
	}

	private static Integer convertBST0(TreeNode root, Integer max) {
		if (root.right != null) {
			max = convertBST0(root.right, max);
		}

		max = root.val + (max == null ? 0 : max);
		root.val = max;

		if (root.left != null) {
			max = convertBST0(root.left, max);
		}

		return max;
	}

}
