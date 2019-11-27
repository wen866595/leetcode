package net.coderbee.leetcode.algorithm.tree;

public class DiameterOfBinaryTree {
	int anx;

	public int diameterOfBinaryTree(TreeNode root) {
		anx = 1;
		depth(root);
		return anx - 1;
	}

	private int depth(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int le = depth(root.left);
		int r = depth(root.right);

		if (le + r + 1 > anx) {
			anx = le + r + 1;
		}

		return Math.max(le, r) + 1;
	}

}
