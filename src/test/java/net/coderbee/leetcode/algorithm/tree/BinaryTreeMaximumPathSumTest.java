package net.coderbee.leetcode.algorithm.tree;

import static org.junit.Assert.*;

import org.junit.Test;

public class BinaryTreeMaximumPathSumTest {

	@Test
	public void test() throws Exception {
		BinaryTreeMaximumPathSum obj = new BinaryTreeMaximumPathSum();

		assertEquals(-3, obj.maxPathSum(new TreeNode(-3)));
		assertEquals(6, obj.maxPathSum(Codec.deserialize("[1,2,3]")));
		assertEquals(42, obj.maxPathSum(Codec.deserialize("[-10,9,20,null,null,15,7]")));
		assertEquals(16, obj.maxPathSum(Codec.deserialize("[9,6,-3,null,null,-6,2,null,null,2,null,-6,-6,-6]")));

		assertEquals(-3, obj.maxPathSum0(new TreeNode(-3)));
		assertEquals(6, obj.maxPathSum0(Codec.deserialize("[1,2,3]")));
		assertEquals(42, obj.maxPathSum0(Codec.deserialize("[-10,9,20,null,null,15,7]")));
		assertEquals(16, obj.maxPathSum0(Codec.deserialize("[9,6,-3,null,null,-6,2,null,null,2,null,-6,-6,-6]")));
	}

}
