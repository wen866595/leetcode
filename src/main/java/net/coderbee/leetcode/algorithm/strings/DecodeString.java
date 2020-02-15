package net.coderbee.leetcode.algorithm.strings;

import java.util.Stack;

/**
 * 394. 字符串解码
 *
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * 
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * 
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * 
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 * 
 * 示例:
 * 
 * s = "3[a]2[bc]", 返回 "aaabcbc". s = "3[a2[c]]", 返回 "accaccacc". s =
 * "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/decode-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DecodeString {

	// s = "3[a]2[bc]", 返回 "aaabcbc".
	// s = "3[a2[c]]", 返回 "accaccacc".
	// s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".

	public static String decodeString0(String s) {
		if (s.isEmpty()) {
			return s;
		}

		Stack<String> strStack = new Stack<String>();
		Stack<Integer> multis = new Stack<Integer>();
		int multi = 0;
		String res = "";
		for (char c : s.toCharArray()) {
			if (Character.isDigit(c)) {
				multi = multi * 10 + (c - '0');
			} else if (c == '[') {
				strStack.push(res);
				res = "";
				multis.push(multi);
				multi = 0;
			} else if (c == ']') {
				Integer cnt = multis.pop();
				StringBuilder sb = new StringBuilder(res.length() * cnt);
				for (int i = 0; i < cnt; i++) {
					sb.append(res);
				}
				res = strStack.pop() + sb.toString();
			} else {
				res += c;
			}
		}

		return res;
	}

	public static String decodeString(String s) {
		if (s.isEmpty()) {
			return s;
		}
		Stack<String> stack = new Stack<>();

		char[] cs = s.toCharArray();
		String current = "";
		for (int i = 0; i < cs.length;) {
			if (Character.isDigit(cs[i])) {
				if (!current.isEmpty()) {
					stack.push(current);
					current = "";
				}
				while (Character.isDigit(cs[i])) {
					current += cs[i];
					i++;
				}
				stack.push(current);
				current = "";
			}

			if (i < cs.length && cs[i] == '[') {
				stack.push("[");
				i++;
			}

			if (i < cs.length && Character.isLetter(cs[i])) {
				while (i < cs.length && Character.isLetter(cs[i])) {
					current += cs[i];
					i++;
				}
				while (!stack.isEmpty() && Character.isLetter(stack.peek().charAt(0))) {
					current = stack.pop() + current;
				}
				stack.push(current);
				current = "";
			}

			if (i < cs.length && cs[i] == ']') {
				current = stack.pop();
				stack.pop(); // op:[
				String numStr = stack.pop();
				current = repeat(current, numStr);

				if (!stack.isEmpty() && Character.isLetter(stack.peek().charAt(0))) {
					stack.push(stack.pop() + current);
				} else {
					stack.push(current);
				}
				current = "";
				i++;
			}
		}

		while (stack.size() > 1) {
			String top = stack.pop();
			stack.push(stack.pop() + top);
		}

		return stack.pop();
	}

	static String repeat(String str, String count) {
		int cnt = Integer.parseInt(count);
		StringBuilder sb = new StringBuilder(str.length() * cnt);
		for (int i = 0; i < cnt; i++) {
			sb.append(str);
		}
		return sb.toString();
	}

}
