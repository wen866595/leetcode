package net.coderbee.leetcode.algorithm.combination;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 电话号码的字母组合
 * 
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 
 * 示例:
 * 
 * 输入："23" 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * 说明: 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LetterCombinationsPhoneNumber {

	private static char[][] map = new char[][] { { 'a', 'b', 'c' }, { 'd', 'e', 'f' }, { 'g', 'h', 'i' },
			{ 'j', 'k', 'l' }, { 'm', 'n', 'o' }, { 'p', 'q', 'r', 's' }, { 't', 'u', 'v' }, { 'w', 'x', 'y', 'z' } };

	public static List<String> letterCombinations(String digits) {
		if (digits.length() < 1) {
			return Collections.emptyList();
		}

		List<String> trs = new ArrayList<>();
		for (char ch : map[digits.charAt(0) - '2']) {
			trs.add("" + ch);
		}

		for (int index = 1; index < digits.length(); index++) {
			char[] chArr = map[digits.charAt(index) - '2'];

			List<String> rs = trs;
			trs = new ArrayList<>();

			for (char ch : chArr) {
				for (String s : rs) {
					trs.add(s + ch);
				}
			}
		}

		return trs;
	}

}
