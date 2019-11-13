package net.coderbee.leetcode.algorithm.tree;

public class InvertBinaryTree {

	public static TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return null;
		}

		TreeNode tn = root.left;
		root.left = invertTree(root.right);
		root.right = invertTree(tn);

		return root;
	}

}
