package net.coderbee.leetcode.algorithm.strings;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。<br/>
 * <br/>
 * 示例 1：<br/>
 * 输入: "babad" 输出: "bab" 注意: "aba" 也是一个有效答案。<br/>
 * <br/>
 * 示例 2：<br/>
 * 输入: "cbbd" 输出: "bb"<br/>
 * <br/>
 * 来源：力扣（LeetCode）<br/>
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring<br/>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestPalindrome {

	public String longestPalindrome(String s) {
		int len = s.length();
		int[][] rs = new int[len][len];

		for (int i = 1; i < len; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (s.charAt(j) == s.charAt(i)) {
					// (j, i) 之间的元素个数，不包括 i, j
					int innerElementsNum = i - j - 1;
					if (innerElementsNum > 1) {
						// (j, i) 之间至少有两个元素，判断是否是回文
						if (rs[i - 1][j + 1] > 0) {
							rs[i][j] = 2 + rs[i - 1][j + 1];
						}
					} else {
						// (j, i) 之间 0 或 1 个元素
						rs[i][j] = innerElementsNum + 2;
					}
				}
			}
		}

		return getSubString(s, rs);
	}

	private String getSubString(String s, int[][] rs) {
		int max = 0;
		int start = 0;
		for (int i = 1; i < rs.length; i++) {
			for (int j = 0; j < i; j++) {
				if (rs[i][j] > max) {
					max = rs[i][j];
					start = j;
				}
			}
		}
		if (max == 0 && s.length() > 0) {
			// 没有重复的元素
			return s.substring(0, 1);
		}
		String sub = s.substring(start, start + max);
		return sub;
	}

}
