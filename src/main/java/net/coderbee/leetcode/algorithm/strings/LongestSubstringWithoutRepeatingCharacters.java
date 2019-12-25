package net.coderbee.leetcode.algorithm.strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

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

	// 该算法的复杂度看起来是 (N*N) 的，但消除了基本类型与包装类型之间的转换，也没有Set/Map 的集合操作，执行速度反而比其他的要快
	public static int lengthOfLongestSubstringBetter(String s) {
		if (s == null) {
			return 0;
		}
		int len = 0, left = 0;
		char[] ch = s.toCharArray();
		for (int right = 0; right < ch.length; right++) {
			for (int i = left; i < right; i++) {
				if (ch[i] == ch[right]) {
					len = Math.max(len, right - left);
					left = i + 1;
					break;
				}
			}
		}
		return Math.max(len, ch.length - left);
	}

	public static int lengthOfLongestSubstringLine(String s) {
		if (s == null) {
			return 0;
		}
		int len = 0;
		Map<Character, Integer> set = new HashMap<Character, Integer>();
		for (int left = 0, right = 0; right < s.length(); right++) {
			if (set.containsKey(s.charAt(right))) {
				// tcabacefgt 删除第二个 c 时 left 已经在 第二个 a 的位置
				left = Math.max(left, set.get(s.charAt(right)));
			}
			// 不能放到上面的 if 语句的 else 块，因为最后一个 t 对应的第一个 t 已经被排除了。
			len = Math.max(len, right - left + 1);
			set.put(s.charAt(right), right + 1);
		}
		return len;
	}

	public static int lengthOfLongestSubstringSlide(String s) {
		if (s == null) {
			s = "";
		}
		int len = 0;
		Set<Character> set = new HashSet<Character>();
		for (int left = 0, right = 0; right < s.length();) {
			if (set.contains(s.charAt(right))) {
				set.remove(s.charAt(left));
				left++;
			} else {
				set.add(s.charAt(right));
				len = Math.max(len, set.size());
				right++;
			}
		}
		return len;
	}

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
