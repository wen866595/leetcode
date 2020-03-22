package net.coderbee.leetcode.algorithm.array;

import java.util.Arrays;

public class MinIncrementForUnique {

	public static int minIncrementForUnique(int[] A) {
		if (A.length == 0) {
			return 0;
		}

		Arrays.sort(A);

		int cnt = 0, pivot = A[0];
		for (int i = 1; i < A.length; i++) {
			if (A[i] > pivot) {
				pivot = A[i];
				continue;
			}
			cnt += pivot - A[i] + 1;
			pivot += 1;
		}

		return cnt;
	}

}
