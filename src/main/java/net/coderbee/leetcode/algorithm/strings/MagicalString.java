package net.coderbee.leetcode.algorithm.strings;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 481. 神奇字符串
 * 
 * https://leetcode-cn.com/problems/magical-string/
 */
public class MagicalString {

	public static int magicalStringQueue(int n) {
		if (n <= 0) {
			return 0;
		}
		if (n <= 3) {
			return 1;
		}

		Queue<Integer> queue = new LinkedList<>();
		queue.add(2);
		int magicIndex = 3;
		int cnt = 1;
		int prev = 2;
		while (magicIndex < n) {
			int next = prev == 2 ? 1 : 2;
			int nextCnt = queue.poll();
			for (int i = 0; magicIndex < n && i < nextCnt; i++) {
				queue.add(next);
				if (next == 1) {
					cnt++;
				}
				magicIndex++;
			}
			prev = next;
		}

		// System.out.println(queue);
		return cnt;
	}

	// 1 22 11 2 1 22 1 22 11 2 11 22 ......
	public static int magicalString(int n) {
		if (n <= 0) {
			return 0;
		}
		if (n <= 3) {
			return 1;
		}

		int[] magic = new int[n];
		magic[0] = 1;
		magic[1] = 2;
		magic[2] = 2;
		int magicIndex = 3;
		int groupIndex = 2;
		int cnt = 1;
		while (magicIndex < n) {
			int next = magic[magicIndex - 1] == 2 ? 1 : 2;
			for (int i = 0; magicIndex < n && i < magic[groupIndex]; i++) {
				magic[magicIndex++] = next;
				if (next == 1) {
					cnt++;
				}
			}

			groupIndex++;
		}

		System.out.println(Arrays.toString(magic));
		return cnt;
	}

}
