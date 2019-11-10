package net.coderbee.leetcode.algorithm.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class SymmetricTree {

	public static boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}

		List<TreeNode> q = new LinkedList<>();
		q.add(root);

		do {
			LinkedList<TreeNode> qnext = new LinkedList<>();

			for (TreeNode treeNode : q) {
				qnext.add(treeNode.left);
				qnext.add(treeNode.right);
			}

			List<TreeNode> backup = qnext.stream().collect(Collectors.toList());
			if (!isSymmetric(qnext)) {
				return false;
			}

			q = backup.stream().filter(n -> n != null).collect(Collectors.toList());

		} while (!q.isEmpty());

		return true;
	}

	private static boolean isSymmetric(LinkedList<TreeNode> q) {
		while (!q.isEmpty()) {
			TreeNode first = q.pollFirst();
			TreeNode last = q.pollLast();
			if (first == null && last == null) {
				continue;
			}
			if (first == null && last != null || first != null && last == null || first.val != last.val) {
				return false;
			}
		}

		return true;
	}

}
