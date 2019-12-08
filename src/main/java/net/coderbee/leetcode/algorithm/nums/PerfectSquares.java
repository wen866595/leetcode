package net.coderbee.leetcode.algorithm.nums;

import java.util.ArrayList;
import java.util.Collections;

public class PerfectSquares {
	int min = -1;

	public int numSquares(int n) {
		ArrayList<Integer> nums = initFactors(n);
		Collections.sort(nums, (f, s) -> s - f);
		System.out.println("nums:" + nums);

		min = n;
		numSquares(nums, 0, 0, n);
		return min;
	}

	private void numSquares(ArrayList<Integer> nums, int currentSize, int sum, int n) {
		if (sum == n) {
			if (currentSize < min) {
				min = currentSize;
			}
			System.out.println("currentSize:" + currentSize);
			return;
		}

		if (currentSize + 1 >= min) {
			return;
		}

		for (Integer i : nums) {
			if (sum + i > n) {
				continue;
			}
			numSquares(nums, currentSize + 1, sum + i, n);
		}
	}

	private ArrayList<Integer> initFactors(int n) {
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for (int i = 1; i < n; i++) {
			int sq = i * i;
			if (sq <= n) {
				nums.add(sq);
			} else {
				break;
			}
		}
		return nums;
	}

}
