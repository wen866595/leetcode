package net.coderbee.leetcode.algorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

	public static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> rs = new LinkedList<List<Integer>>();
		if (root == null) {
			return rs;
		}

		Queue<TreeNode> queue0 = new LinkedList<TreeNode>();
		queue0.add(root);
		Queue<TreeNode> queue1 = new LinkedList<TreeNode>();

		while (!queue0.isEmpty()) {
			List<Integer> level = new ArrayList<Integer>(queue0.size());
			for (TreeNode treeNode : queue0) {
				level.add(treeNode.val);
				if (treeNode.left != null) {
					queue1.add(treeNode.left);
				}

				if (treeNode.right != null) {
					queue1.add(treeNode.right);
				}
			}
			Queue<TreeNode> t = queue0;
			queue0 = queue1;
			t.clear();
			queue1 = t;
			rs.add(level);
		}

		return rs;
	}

}
