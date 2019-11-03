package net.coderbee.leetcode.algorithm.strings;

import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。<br/>
 * <br/>
 * 示例 1:<br/>
 * <br/>
 * 输入: "abcabcbb" 输出: 3 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。<br/>
 * <br/>
 * 示例 2:<br/>
 * <br/>
 * 输入: "bbbbb" 输出: 1 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。<br/>
 * <br/>
 * 示例 3:<br/>
 * <br/>
 * 输入: "pwwkew" 输出: 3 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。 请注意，你的答案必须是 子串
 * 的长度，"pwke" 是一个子序列，不是子串。<br/>
 * <br/>
 * 来源：力扣（LeetCode）<br/>
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters<br/>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。<br/>
 * <br/>
 */
public class LongestSubstringWithoutRepeatingCharacters {

	public static int lengthOfLongestSubstring(String s) {
		int len = 0;
		LinkedHashSet<Character> set = new LinkedHashSet<Character>();
		for (char ch : s.toCharArray()) {
			if (set.contains(ch)) {
				if (set.size() > len) {
					len = set.size();
				}
				Iterator<Character> iter = set.iterator();
				Character c;
				while ((c = iter.next()) != null) {
					iter.remove();
					if (ch == c) {
						break;
					}
				}
			}

			set.add(ch);
		}
		if (set.size() > len) {
			len = set.size();
		}

		return len;
	}

}
