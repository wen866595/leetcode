package net.coderbee.leetcode.algorithm.strings;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 找到字符串中所有字母异位词
 * 
 * https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/
 *
 */
public class FindAnagrams {

	public static List<Integer> findAnagrams(String s, String p) {
		Map<Character, Integer> group = init(p);
		System.out.println("p:" + group);

		List<Integer> rs = new LinkedList<Integer>();
		Map<Character, Integer> subMap = new HashMap<>();

		for (int i = 0; i <= s.length() - p.length();) {
			int hasNotExists = -1;
			subMap.clear();

			for (int j = i; j < i + p.length(); j++) {
				Character ch = s.charAt(j);
				Integer cnt = group.get(ch);
				if (cnt == null) {
					hasNotExists = j;
					break;
				}
				Integer subCnt = subMap.get(ch);
				subMap.put(ch, subCnt == null ? 1 : 1 + subCnt);
			}

			if (hasNotExists != -1) {
				i = hasNotExists + 1;
				continue;
			}

			boolean isAllMatch = isAllMatch(group, subMap);
			if (isAllMatch) {
				rs.add(i);
			}

			i++;
		}

		return rs;
	}

	private static boolean isAllMatch(Map<Character, Integer> group, Map<Character, Integer> subMap) {
		if (group.size() != subMap.size()) {
			return false;
		}
		boolean isAllMatch = true;
		for (Map.Entry<Character, Integer> entry : group.entrySet()) {
			int cnt = subMap.get(entry.getKey());
			if (cnt != entry.getValue()) {
				isAllMatch = false;
				break;
			}
		}
		return isAllMatch;
	}

	private static Map<Character, Integer> init(String p) {
		Map<Character, Integer> group = new HashMap<>();
		for (Character c : p.toCharArray()) {
			Integer cnt = group.get(c);
			if (cnt == null) {
				group.put(c, 1);
			} else {
				group.put(c, cnt + 1);
			}
		}
		return group;
	}

}
