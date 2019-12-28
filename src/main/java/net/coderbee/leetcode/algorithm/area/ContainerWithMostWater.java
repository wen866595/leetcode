package net.coderbee.leetcode.algorithm.area;

/**
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i,
 * ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。<br/>
 * <br/>
 * 说明：你不能倾斜容器，且 n 的值至少为 2。<br/>
 * 
 * 示例:<br/>
 * 输入: [1,8,6,2,5,4,8,3,7] <br/>
 * 输出: 49<br/>
 * <br/>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water<br/>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。<br/>
 * 
 * @author coderbee
 */
public class ContainerWithMostWater {

	// 宽度和高度决定了容器的大小；
	// 两条线段分别在 首尾 的时候，宽度最大；不管移动哪一端都会缩短宽度，
	// 容积还取决于高度，首尾两者中又取决于矮的那个，移动指针的时候优先消除矮的那个。
	public static int maxAreaByTwoPointer(int[] height) {
		int left = 0, right = height.length - 1;
		int maxArea = (right - left) * Math.min(height[left], height[right]);
		while (left < right) {
			// 移动的过程可以忽略小于等于当前较矮的节点，实现连续移动。
			if (height[left] < height[right]) {
				left++;
			} else {
				right--;
			}
			maxArea = Math.max(maxArea, (right - left) * Math.min(height[left], height[right]));
		}
		return maxArea;
	}

	public int maxArea(int[] height) {
		int max = Math.min(height[1], height[0]);
		for (int i = 2; i < height.length; i++) {
			for (int j = i - 1; j >= 0; j--) {
				int t = (i - j) * Math.min(height[i], height[j]);
				if (t > max) {
					max = t;
				}
			}
		}

		return max;
	}
}
