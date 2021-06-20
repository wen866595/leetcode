package net.coderbee.leetcode.algorithm.tree;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {

	public static void main(String[] args) {
		// [[3], [20,9], [15,7]]
		System.out.println(zigzagLevelOrder(Codec.deserialize("[3,9,20,null,null,15,7]")));

		System.out.println("\n\n");

		// [[1], [3,2], [4,5]]
		System.out.println(zigzagLevelOrder(Codec.deserialize("[1,2,3,4,null,null,5]")));
	}

	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		if (root == null) {
			return Collections.emptyList();
		}
		Deque<TreeNode> roots = new LinkedList<>();
		roots.add(root);

		List<List<Integer>> rs = new LinkedList<>();
		zigzagLevelOrder(rs, roots, true);
		return rs;
	}

	public static void zigzagLevelOrder(List<List<Integer>> rs, Deque<TreeNode> roots, boolean inOrder) {
		if (roots.isEmpty()) {
			return;
		}
		LinkedList<Integer> level = new LinkedList<>();
		Deque<TreeNode> nextLevel = new LinkedList<TreeNode>();

		while (!roots.isEmpty()) {
			TreeNode node = roots.removeFirst();
			if (inOrder) {
				level.add(node.val);
			} else {
				level.addFirst(node.val);
			}

			if (node.left != null) {
				nextLevel.add(node.left);
			}
			if (node.right != null) {
				nextLevel.add(node.right);
			}
		}

		rs.add(level);
		zigzagLevelOrder(rs, nextLevel, !inOrder);
	}
}
