package net.coderbee.leetcode.algorithm.tree;

/**
 * 二叉树的最近公共祖先
 * 
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 *
 */
public class LowestCommonAncestor {
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	    // 如果 root == p, q 在 p 的子树，直接返回也是对的，因为 P 的父节点的另一个子树肯定是返回 null
	    if (root == null || root == p || root == q) {
	        return root;
	    }

	    TreeNode left = lowestCommonAncestor(root.left, p, q);
	    TreeNode right = lowestCommonAncestor(root.right, p, q);

	    // 在某个子树上找不到时，返回另一子树的结果，如果另一子树也没找到，返回的 null。
	    if (left == null) return right;
	    if (right == null) return left;

	    return root; // 左、右 子树均找到节点，p/q 分别在 root 的两侧。
	}

}
