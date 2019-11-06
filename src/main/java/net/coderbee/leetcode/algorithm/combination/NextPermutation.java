package net.coderbee.leetcode.algorithm.combination;

import net.coderbee.util.ArrayUtils;

/**
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。<br/>
 * <br/>
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。<br/>
 * 
 * 必须原地修改，只允许使用额外常数空间。<br/>
 * <br/>
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。<br/>
 * 1,2,3 → 1,3,2<br/>
 * 3,2,1 → 1,2,3<br/>
 * 1,1,5 → 1,5,1<br/>
 * <br/>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/next-permutation<br/>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class NextPermutation {

	// 整个数组可以认为是一个高位在前、低位在后的数，
	public static void nextPermutation(int[] nums) {
		// 从后往前找到第一个升序的数字 a[i] < a[i+1]
		int i = nums.length - 2;
		for (; i >= 0; i--) {
			if (nums[i] < nums[i + 1]) {
				break;
			}
		}
		if (i == -1) {
			// 找不到说明是个降序数组，进行反转。
			ArrayUtils.reverse(nums, 0, nums.length - 1);
			return;
		}

		// 此时，a[i, N) 可以认为是一个降序数组
		// 从后往前找到一个 a[j] > a[i]
		int j = nums.length - 1;
		for (; j > i; j--) {
			if (nums[j] > nums[i]) {
				break;
			}
		}

		// 交换 a[i], a[j]
		ArrayUtils.swap(nums, i, j);

		// a[i, N) 是一个降序数组，更小的排列应该是把这个降序数组转换为升序数组。
		// 比如 [3,2,1] 是大于 [1,2,3] 的，因此要对 a[i+1, N)进行逆序
		ArrayUtils.reverse(nums, i + 1, nums.length - 1);
	}

}
