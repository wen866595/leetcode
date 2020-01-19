package net.coderbee.leetcode.algorithm.strings;

/**
 * 395. 至少有K个重复字符的最长子串
 * 
 * 找到给定字符串（由小写字符组成）中的最长子串 T ， 要求 T 中的每一字符出现次数都不少于 k 。输出 T 的长度。
 *
 */
public class LongestSubstring {

	public static int longestSubstring(String str, int k) {
		if (str == null || str.length() < 1 || k > str.length()) {
			return 0;
		}
		if (k == 1) {
			return str.length();
		}

		return longestSubstring(str.toCharArray(), 0, str.length() - 1, k);
	}

	static int longestSubstring(char[] chArr, int start, int end, int k) {
		if (end - start + 1 < k) {
			return 0;
		}
		int[] counts = new int[26];
		for (int i = start; i <= end; i++) {
			counts[chArr[i] - 'a']++;
		}

		while (start <= end && counts[chArr[start] - 'a'] < k) {
			start++;
		}
		while (start <= end && counts[chArr[end] - 'a'] < k) {
			end--;
		}

		if (end - start + 1 < k) {
			return 0;
		}

		for (int i = start; i <= end; i++) {
			if (counts[chArr[i] - 'a'] < k) {
				int subLen = longestSubstring(chArr, start, i - 1, k);
				if (subLen > end - i) {
					return subLen;
				}
				return Math.max(subLen, longestSubstring(chArr, i + 1, end, k));
			}
		}

		return end - start + 1;
	}

	public static int longestSubstringNNN(String str, int k) {
		if (str == null || str.length() < 1) {
			return 0;
		}
		if (k == 1) {
			return str.length();
		}

		int len = 0;
		for (int left = 0; left < str.length(); left++) {
			int[] ct = new int[26];
			for (int right = left; right < str.length(); right++) {
				ct[str.charAt(right) - 'a']++;

				if (right - left + 1 > len && isValid(ct, k)) {
					len = right - left + 1;
				}
			}
		}

		return len;
	}

	static boolean isValid(int[] ct, int k) {
		for (int i : ct) {
			if (i > 0 && i < k) {
				return false;
			}
		}
		return true;
	}

}
