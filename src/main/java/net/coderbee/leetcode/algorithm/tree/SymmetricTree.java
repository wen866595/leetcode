package net.coderbee.leetcode.algorithm.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 101. 对称二叉树
 * <p>
 * 给定一个二叉树，检查它是否是镜像对称的。
 */
public class SymmetricTree {

    public static boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null) {
            return false;
        }

        return left.val == right.val && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

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
