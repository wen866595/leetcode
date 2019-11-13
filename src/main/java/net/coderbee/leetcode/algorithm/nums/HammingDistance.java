package net.coderbee.leetcode.algorithm.nums;

/**
 * 汉明距离
 * 
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 * 
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 *
 */
public class HammingDistance {

	public static int hammingDistance(int x, int y) {
		int xor = x ^ y;
		int cnt = 0;

		while (xor != 0) {
			cnt++;
			xor = xor & (xor - 1);
		}

		return cnt;
	}

}
