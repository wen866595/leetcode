package net.coderbee.leetcode.algorithm.combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class TaskScheduler {

	/*
	 * 任务调度器
	 * 
	 * https://leetcode-cn.com/problems/task-scheduler/
	 */

	public static int leastInterval(char[] tasks, int n) {
		if (tasks == null || tasks.length < 1) {
			return 0;
		}
		if (n == 0) {
			return tasks.length;
		}

		int[] group = new int[26];
		for (char ch : tasks) {
			group[ch - 'A']++;
		}
		Arrays.sort(group);

		int max = group[25] - 1, idealNums = max * n;
		for (int i = 24; i >= 0 && group[i] > 0; i++) {
			idealNums -= Math.min(group[i], max);
		}

		return idealNums > 0 ? idealNums + tasks.length : idealNums;
	}

	// 次数多的优先执行
	// 具体的任务不关心，用数字代替，只要组成一组就行
	// 一组任务的个数是 n+1
	public static int leastIntervalByPriorityQueue(char[] tasks, int n) {
		if (tasks == null || tasks.length < 1) {
			return 0;
		}
		if (n == 0) {
			return tasks.length;
		}

		PriorityQueue<Integer> queue = buildQueue(tasks);

		int cnt = 0, groupNum = n + 1;
		do {
			List<Integer> slots = new ArrayList<Integer>(n + 1);
			for (int i = 0; i < groupNum && !queue.isEmpty(); i++) {
				slots.add(queue.poll());
			}

			int len = slots.size();

			slots.stream().filter(i -> i > 1).forEach(i -> queue.add(i - 1));

			cnt += queue.isEmpty() ? len : groupNum;

		} while (!queue.isEmpty());

		return cnt;
	}

	private static PriorityQueue<Integer> buildQueue(char[] tasks) {
		int[] group = new int[26];
		for (char ch : tasks) {
			group[ch - 'A']++;
		}

		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Collections.reverseOrder());
		IntStream.of(group).filter(i -> i > 0).forEach(i -> queue.add(i));
		return queue;
	}

}
