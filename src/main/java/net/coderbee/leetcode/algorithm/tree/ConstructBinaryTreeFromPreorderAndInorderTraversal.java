package net.coderbee.leetcode.algorithm.tree;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

	public static TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder == null || preorder.length < 1) {
			return null;
		}
		return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
	}

	// 前序遍历 preorder = [3, 9, 20, 15, 7]
	// 中序遍历 inorder = [9, 3, 15, 20, 7]
	private static TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
		TreeNode root = new TreeNode(preorder[preStart]); // 前序遍历的第一个结点是根

		// 找出根在中序遍历的数组里的位置，划分出左右子树
		int rootIndex = inStart;
		for (; rootIndex <= inEnd; rootIndex++) {
			if (inorder[rootIndex] == root.val) {
				break;
			}
		}

		// 二叉树不一定有序，根据元素数量来构建左右子树
		int leftCnt = rootIndex - inStart;
		if (leftCnt > 0) {
			root.left = build(preorder, preStart + 1, preStart + leftCnt, inorder, inStart, inStart + leftCnt - 1);
		}

		int rightCnt = inEnd - rootIndex;
		if (rightCnt > 0) {
			root.right = build(preorder, preStart + leftCnt + 1, preEnd, inorder, inStart + 1 + leftCnt, inEnd);
		}

		return root;
	}

}
