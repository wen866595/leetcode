package net.coderbee.leetcode.algorithm.strings;

public class RegularExpressionMatching {

	// 分情况处理
	// 从模式串出发
	public static boolean isMatch(String s, String p) {
		if (s == null) {
			s = "";
		}
		if (p == null) {
			p = "";
		}

		return isMatch0(s, p);
	}

	static boolean isMatch0(String s, String p) {
		if (p.isEmpty()) {
			return s.isEmpty();
		}

		boolean firstMatch = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');

		if (p.length() >= 2 && p.charAt(1) == '*') {
			return isMatch0(s, p.substring(2)) || (firstMatch && isMatch0(s.substring(1), p));
		} else {
			return firstMatch && isMatch0(s.substring(1), p.substring(1));
		}
	}

}
