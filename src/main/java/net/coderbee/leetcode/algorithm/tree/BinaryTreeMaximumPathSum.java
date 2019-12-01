package net.coderbee.leetcode.algorithm.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 124. 二叉树中的最大路径和
 * 
 * 给定一个非空二叉树，返回其最大路径和。
 * 
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 * 
 * https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
 *
 */
public class BinaryTreeMaximumPathSum {
	int max = Integer.MIN_VALUE;
	int max_sum = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {
		max_sum = Integer.MIN_VALUE;
		max_gain(root);
		return max_sum;
	}

	public int max_gain(TreeNode node) {
		if (node == null)
			return 0;

		// max sum on the left and right sub-trees of node
		int left_gain = Math.max(max_gain(node.left), 0);
		int right_gain = Math.max(max_gain(node.right), 0);

		// the price to start a new path where `node` is a highest node
		int price_newpath = node.val + left_gain + right_gain;

		// update max_sum if it's better to start a new path
		max_sum = Math.max(max_sum, price_newpath);

		// for recursion :
		// return the max gain if continue the same path
		return node.val + Math.max(left_gain, right_gain);
	}

	public int maxPathSum0(TreeNode root) {
		max = Integer.MIN_VALUE;
		Map<TreeNode, Integer> cache = new HashMap<>();
		recursive(root, cache);
		return max;
	}

	private int recursive(TreeNode root, Map<TreeNode, Integer> cache) {
		if (root == null) {
			return 0;
		}

		return Math.max(throughRoot(root, cache), Math.max(recursive(root.left, cache), recursive(root.right, cache)));
	}

	private int throughRoot(TreeNode root, Map<TreeNode, Integer> cache) {
		if (root == null) {
			return 0;
		}

		if (cache.containsKey(root)) {
			return cache.get(root);
		}

		if (root.val > max) {
			max = root.val;
		}

		int lsum = dfs(root.left);
		int rsum = dfs(root.right);
		if (lsum + rsum + root.val < 0) {
			cache.put(root, 0);
			return 0;
		}
		int sum = root.val;
		if (lsum > 0) {
			sum += lsum;
		}
		if (rsum > 0) {
			sum += rsum;
		}

		if (sum > max) {
			max = sum;
		}
		cache.put(root, sum);
		return sum;
	}

	private int dfs(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int ldfs = 0;
		if (root.left != null) {
			ldfs = dfs(root.left);
		}
		int rdfs = 0;
		if (root.right != null) {
			rdfs = dfs(root.right);
		}
		int maxChild = Math.max(ldfs, rdfs);
		if (maxChild > 0) {
			return root.val + maxChild;
		} else {
			return root.val;
		}
	}

}
