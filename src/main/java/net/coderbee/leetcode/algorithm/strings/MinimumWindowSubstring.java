package net.coderbee.leetcode.algorithm.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * 76. 最小覆盖子串
 * 
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
 * 
 * 示例：
 * 
 * 输入: S = "ADOBECODEBANC", T = "ABC" 输出: "BANC"
 * 
 * 说明：
 * 
 * 如果 S 中不存这样的子串，则返回空字符串 ""。 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/minimum-window-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class MinimumWindowSubstring {

	public static String minWindow(String s, String t) {
		if (s == null || s.isEmpty() || t == null || t.isEmpty()) {
			return "";
		}

		Map<Character, Integer> group = new HashMap<>();
		for (int i = 0; i < t.length(); i++) {
			Character ch = t.charAt(i);
			group.put(ch, group.getOrDefault(ch, 0) + 1);
		}

		if (s.length() < group.size()) {
			return "";
		}

		String target = "";
		Map<Character, Integer> window = new HashMap<>();
		for (int left = 0, right = 0; right < s.length(); right++) {
			Character ch = s.charAt(right);
			Integer groupCnt = group.get(ch);
			if (groupCnt == null) {
				continue;
			}

			window.put(ch, window.getOrDefault(ch, 0) + 1);
			if (!isAllMatch(group, window)) {
				continue;
			}
			do {
				Character cc = s.charAt(left);
				Integer cnt = window.get(cc);
				if (cnt != null) {
					Integer gcnt = group.get(cc);
					if (cnt.intValue() <= gcnt) {
						break;
					} else {
						// 多余元素
						window.put(cc, cnt - 1);
						left++;
					}
				} else {
					// 不存在元素
					left++;
				}
			} while (isAllMatch(group, window));

			if (target.length() == 0 || right - left + 1 < target.length()) {
				target = s.substring(left, right + 1);
			}
		}

		return target;
	}

	private static boolean isAllMatch(Map<Character, Integer> group, Map<Character, Integer> window) {
		if (group.size() != window.size()) {
			return false;
		}

		for (Map.Entry<Character, Integer> entry : group.entrySet()) {
			Integer cnt = window.get(entry.getKey());
			if (cnt == null || cnt.intValue() < entry.getValue()) {
				return false;
			}
		}

		return true;
	}

}
