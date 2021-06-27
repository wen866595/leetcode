package net.coderbee.leetcode.algorithm.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 剑指 Offer 54. 二叉搜索树的第k大节点
 * <p>
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 */
public class KthLargestBST {

    public static void main(String[] args) {
        System.out.println(kthLargest(Codec.deserialize("[3,1,4,null,2]"), 1));
        System.out.println(kthLargest(Codec.deserialize("[5,3,6,2,4,null,null,1]"), 3));

        System.out.println(kthLargest0(Codec.deserialize("[3,1,4,null,2]"), 2));
        System.out.println(kthLargest0(Codec.deserialize("[5,3,6,2,4,null,null,1]"), 2));
    }

    public static int kthLargest0(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        int index = k;
        while (p != null || !stack.isEmpty()) {
            if (p == null) {
                p = stack.pop();
                index--;
                if (index == 0) {
                    return p.val;
                }
                p = p.left;
            } else {
                stack.push(p);
                p = p.right;
            }
        }
        return 0;
    }

    public static int kthLargest(TreeNode root, int k) {
        List<Integer> list = new LinkedList<>();
        dfs(root, k, list);
        return list.get(k - 1);
    }

    private static void dfs(TreeNode root, int k, List<Integer> list) {
        if (root == null || list.size() == k) {
            return;
        }

        if (root.right != null) {
            dfs(root.right, k, list);
        }

        list.add(root.val);

        if (list.size() >= k) {
            return;
        }

        if (root.left != null) {
            dfs(root.left, k, list);
        }
    }

}
