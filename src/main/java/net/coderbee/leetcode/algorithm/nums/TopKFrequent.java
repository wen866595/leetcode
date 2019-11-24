package net.coderbee.leetcode.algorithm.nums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class TopKFrequent {

	public static List<Integer> topKFrequent(int[] nums, int k) {
		Arrays.sort(nums);

		PriorityQueue<Node> set = new PriorityQueue<>();

		Node prev = new Node(nums[0]);
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == prev.key) {
				prev.inc();
			} else {
				set.add(prev);
				prev = new Node(nums[i]);
			}
		}
		set.add(prev);

		List<Integer> rs = new ArrayList<>(k);
		for (int i = 0; i < k; i++) {
			rs.add(set.poll().key);
		}

		return rs;
	}

	static class Node implements Comparable<Node> {
		int key;
		int cnt;

		Node(int key) {
			this.key = key;
			this.cnt = 1;
		}

		void inc() {
			cnt++;
		}

		public int compareTo(Node o) {
			if (o.cnt == this.cnt) {
				return this.key - o.key;
			}
			return o.cnt - this.cnt;
		}

		@Override
		public String toString() {
			return cnt + ":" + key;
		}
	}

}
