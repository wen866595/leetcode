package net.coderbee.leetcode.algorithm.tree;

import org.junit.Test;

public class ConstructBinaryTreeFromPreorderAndInorderTraversalTest {

	@Test
	public void test() throws Exception {
		int[] preorder = new int[] { 3, 9, 20, 15, 7 };
		int[] inorder = new int[] { 9, 3, 15, 20, 7 };
		ConstructBinaryTreeFromPreorderAndInorderTraversal.buildTree(preorder, inorder);

		ConstructBinaryTreeFromPreorderAndInorderTraversal.buildTree(new int[] { 1, 2, 3 }, new int[] { 3, 2, 1 });
	}

}
