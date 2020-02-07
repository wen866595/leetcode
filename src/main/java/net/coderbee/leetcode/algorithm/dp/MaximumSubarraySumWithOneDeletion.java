package net.coderbee.leetcode.algorithm.dp;

/**
 * 1186. 删除一次得到子数组最大和
 * 
 * 给你一个整数数组，返回它的某个 非空 子数组（连续元素）在执行一次可选的删除操作后，所能得到的最大元素总和。
 * 
 * 换句话说，你可以从原数组中选出一个子数组，并可以决定要不要从中删除一个元素（只能删一次哦），（删除后）子数组中至少应当有一个元素，然后该子数组（剩下）的元素总和是所有子数组之中最大的。
 * 
 * 注意，删除一个元素后，子数组 不能为空。
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray-sum-with-one-deletion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class MaximumSubarraySumWithOneDeletion {

	public static int maximumSum(int[] arr) {
		int len = arr.length;

		int[] leftRight = new int[len];
		leftRight[0] = arr[0];
		for (int i = 1; i < len; i++) {
			leftRight[i] = arr[i] + Math.max(0, leftRight[i - 1]);
		}

		int[] rightLeft = new int[len];
		rightLeft[len - 1] = arr[len - 1];
		for (int i = arr.length - 2; i >= 0; i--) {
			rightLeft[i] = arr[i] + Math.max(0, rightLeft[i + 1]);
		}

		int maxSum = Math.max(arr[0], arr[len - 1]);
		for (int i = 1; i < len - 1; i++) {
			int tmp = Math.max(0, arr[i]);
			if (leftRight[i - 1] < 0 || rightLeft[i + 1] < 0) {
				tmp += Math.max(leftRight[i - 1], rightLeft[i + 1]);
			} else {
				tmp += leftRight[i - 1] + rightLeft[i + 1];
			}
			maxSum = Math.max(maxSum, tmp);
		}

		return maxSum;
	}

}
