package net.coderbee.leetcode.algorithm.array;

public class MountainArray {
	int[] arr;

	public MountainArray(int[] arr) {
		this.arr = arr;
	}

	public int get(int index) {
		return arr[index];
	}

	public int length() {
		return arr.length;
	}
}
