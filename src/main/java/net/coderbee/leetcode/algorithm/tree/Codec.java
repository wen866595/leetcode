package net.coderbee.leetcode.algorithm.tree;

import java.util.LinkedList;
import java.util.List;

public class Codec {
	public static String serialize(TreeNode root) {
		if (root == null) {
			return "[]";
		}
		List<Integer> nvals = new LinkedList<>();
		List<TreeNode> level = new LinkedList<>();
		level.add(root);

		do {
			LinkedList<TreeNode> nextLevel = new LinkedList<>();
			for (TreeNode treeNode : level) {
				if (treeNode == null) {
					nvals.add(null);
				} else {
					nvals.add(treeNode.val);
					nextLevel.add(treeNode.left);
					nextLevel.add(treeNode.right);
				}
			}

			if (!hasNext(nextLevel)) {
				while (!nextLevel.isEmpty() && nextLevel.getLast() == null) {
					nextLevel.removeLast();
				}
			}

			if (nextLevel.isEmpty()) {
				break;
			}

			level = nextLevel;
		} while (true);

		return convertToString(nvals);
	}

	private static boolean hasNext(LinkedList<TreeNode> nextLevel) {
		boolean isHas = false;
		for (TreeNode treeNode : nextLevel) {
			if (treeNode != null && (treeNode.left != null || treeNode.right != null)) {
				isHas = true;
				break;
			}
		}
		return isHas;
	}

	private static String convertToString(List<Integer> nvals) {
		StringBuilder sb = new StringBuilder(128);
		sb.append('[');
		for (Integer i : nvals) {
			if (i == null) {
				sb.append(i).append(',');
			} else {
				sb.append(i.intValue()).append(',');
			}
		}
		sb.setCharAt(sb.length() - 1, ']');
		System.out.println(sb);
		return sb.toString();
	}

	public static TreeNode deserialize(String data) {
		if (data == null || data.length() < 3) {
			return null;
		}
		String[] nodeVal = data.substring(1, data.length() - 1).split(",");

		TreeNode root = new TreeNode(Integer.parseInt(nodeVal[0]));
		List<TreeNode> preLevel = new LinkedList<>();
		preLevel.add(root);

		int index = 1;
		while (index < nodeVal.length) {
			List<TreeNode> level = new LinkedList<>();
			for (TreeNode treeNode : preLevel) {
				if (treeNode == null) {
					continue;
				}

				if (index < nodeVal.length) {
					if ("null".equals(nodeVal[index])) {
						treeNode.left = null;
					} else {
						treeNode.left = new TreeNode(Integer.parseInt(nodeVal[index]));
						level.add(treeNode.left);
					}
				} else {
					break;
				}
				index++;

				if (index < nodeVal.length) {
					if ("null".equals(nodeVal[index])) {
						treeNode.right = null;
					} else {
						treeNode.right = new TreeNode(Integer.parseInt(nodeVal[index]));
						level.add(treeNode.right);
					}
				} else {
					break;
				}
				index++;
			}

			preLevel = level;
		}

		return root;
	}

}
