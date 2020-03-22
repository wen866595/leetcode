package net.coderbee.leetcode.algorithm.array;

import java.util.LinkedList;
import java.util.Queue;

public class CourseScheduleii {

	/**
	 * 现在你总共有 n 门课需要选，记为 0 到 n-1。
	 * 
	 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
	 * 
	 * 给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。
	 * 
	 * 可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。
	 * 
	 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/course-schedule-ii
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		// 统计入度、出度
		LinkedList<Integer>[] childs = new LinkedList[numCourses];
		int[] inDegree = new int[numCourses];
		for (int[] is : prerequisites) {
			inDegree[is[0]]++;
			if (childs[is[1]] == null) {
				childs[is[1]] = new LinkedList<Integer>();
			}
			childs[is[1]].add(is[0]);
		}

		// 找出 入度为 0 的结点
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < numCourses; i++) {
			if (inDegree[i] == 0) {
				queue.add(i);
			}
		}

		int[] sorted = new int[numCourses];
		int idx = 0;
		while (!queue.isEmpty()) {
			int id = queue.poll();
			sorted[idx++] = id;
			if (childs[id] != null) {
				for (int child : childs[id]) {
					inDegree[child]--;
					if (inDegree[child] == 0) {
						queue.add(child);
					}
				}
			}
		}

		if (idx == numCourses) {
			return sorted;
		}

		return new int[0];
	}

}
