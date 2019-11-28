package net.coderbee.leetcode.algorithm.tree;

public class LowestCommonAncestor2 {
	TreeNode target;

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		target = null;
		dfs(root, p, q);
		return target;
	}

	int dfs(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return 0;
		}

		int lc = dfs(root.left, p, q);
		if (lc == -1) {
			return -1;
		}
		int rc = dfs(root.right, p, q);
		if (rc == -1) {
			return -1;
		}

		int cnt = (root == p || root == q ? 1 : 0) + lc + rc;
		if (cnt == 2) {
			target = root;
			return -1;
		}
		return cnt;
	}

}
