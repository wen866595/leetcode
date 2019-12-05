package net.coderbee.leetcode.algorithm.nums;

/**
 * 48. 旋转图像
 * 
 * 给定一个 n × n 的二维矩阵表示一个图像。
 * 
 * 将图像顺时针旋转 90 度。
 * 
 * 说明：
 * 
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/rotate-image
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class RotateImage {

	public static void rotate(int[][] matrix) {
		ratate(matrix, 0, matrix.length - 1);
	}

	private static void ratate(int[][] matrix, int start, int end) {
		if (end <= start) {
			return;
		}

		// 旋转最外层
		// 最后一列不需要
		for (int i = start, j = 0; i < end; i++, j++) {
			int buf = matrix[start][i];
			// 上 = 左
			matrix[start][i] = matrix[end - j][start];
			// 左 = 底
			matrix[end - j][start] = matrix[end][end - j];
			// 底 = 右
			matrix[end][end - j] = matrix[i][end];
			// 右 = 上
			matrix[i][end] = buf;
		}

		ratate(matrix, start + 1, end - 1);
	}

}
