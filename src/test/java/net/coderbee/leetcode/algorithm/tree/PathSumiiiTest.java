package net.coderbee.leetcode.algorithm.tree;

import static org.junit.Assert.*;

import org.junit.Test;

public class PathSumiiiTest {

	@Test
	public void test() throws Exception {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.right = new TreeNode(3);
		root.right.right.right = new TreeNode(4);
		assertEquals(2, PathSumiii.pathSum(root, 3));
	}

}
