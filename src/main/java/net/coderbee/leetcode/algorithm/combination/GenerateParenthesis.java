package net.coderbee.leetcode.algorithm.combination;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

	public static List<String> generateParenthesis(int n) {
		List<String> rs = new ArrayList<String>();
		backtrace(rs, "", n, n, n);
		return rs;
	}

	private static void backtrace(List<String> rs, String current, int open, int close, int n) {
		if (close == 0) {
			rs.add(current);
			return;
		}
		if (open > 0) {
			backtrace(rs, current + "(", open - 1, close, n);
		}
		if (close > open) {
			backtrace(rs, current + ")", open, close - 1, n);
		}

	}

}
