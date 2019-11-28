package net.coderbee.leetcode.algorithm.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 二叉树的最近公共祖先
 * 
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 *
 */
public class LowestCommonAncestor {

	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		Map<TreeNode, Integer> counts = new HashMap<TreeNode, Integer>();
		dfs(counts, root, p, q);
		return lowestCommonAncestor(counts, root, p, q);
	}

	public static TreeNode lowestCommonAncestor(Map<TreeNode, Integer> counts, TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return null;
		}

		if (root == p || root == q) {
			return root;
		}

		int lc = dfs(counts, root.left, p, q);
		if (lc == 1 && dfs(counts, root.right, p, q) == 1) {
			return root;
		}

		if (lc > 1) {
			return lowestCommonAncestor(counts, root.left, p, q);
		} else {
			return lowestCommonAncestor(counts, root.right, p, q);
		}
	}

	private static int dfs(Map<TreeNode, Integer> counts, TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return 0;
		}

		if (counts.get(root) != null) {
			return counts.get(root);
		}
		int cnt = (root == p || root == q ? 1 : 0) + dfs(counts, root.left, p, q) + dfs(counts, root.right, p, q);
		counts.put(root, cnt);
		return cnt;
	}

}
