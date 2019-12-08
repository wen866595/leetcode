package net.coderbee.leetcode.algorithm.nums;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class PerfectSquares {
	int min = -1;

	public int numSquares(int n) {
		ArrayList<Integer> nums = initFactors(n);
		Collections.sort(nums, (f, s) -> s - f);
		System.out.println("nums:" + nums);

		min = n;
		LinkedList<Integer> addin = new LinkedList<Integer>();
		numSquares(nums, addin, 0, n);
		return min;
	}

	private void numSquares(ArrayList<Integer> nums, LinkedList<Integer> addin, int sum, int n) {
		if (sum == n) {
			if (addin.size() < min) {
				min = addin.size();
			}
			System.out.println("addin:" + addin);
			return;
		}

		if (addin.size() + 1 >= min) {
			return;
		}

		for (Integer i : nums) {
			if (sum + i > n) {
				continue;
			}
			if (addin.size() < min) {
				addin.addLast(i);
				numSquares(nums, addin, sum + i, n);
				addin.removeLast();
			}
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
