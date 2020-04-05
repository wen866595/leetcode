package net.coderbee.leetcode.algorithm.strings;

public class Atoi {

	static class Automation {
		static int start = 0;
		static int signed = 1;
		static int in_number = 2;
		static int end = 3;

		int[][] dfa = new int[][] { { start, signed, in_number, end }, { end, end, in_number, end },
				{ end, end, in_number, end }, { end, end, end, end } };

		int state = start;
		int sign = 1;
		long result = 0;

		int getCol(char ch) {
			if (ch == ' ') {
				return start;
			} else if (ch >= '0' && ch <= '9') {
				return in_number;
			} else if (ch == '-' || ch == '+') {
				return signed;
			} else {
				return end;
			}
		}

		void get(char ch) {
			state = dfa[state][getCol(ch)];
			if (state == in_number) {
				result = result * 10 + (ch - '0');
				if (sign == 1) {
					result = Math.min(result, Integer.MAX_VALUE);
				} else {
					result = Math.min(result, -(long) Integer.MIN_VALUE);
				}
			} else if (state == signed) {
				sign = ch == '-' ? -1 : 1;
			}
		}

		public int auto(String str) {
			for (char ch : str.toCharArray()) {
				get(ch);
			}
			return sign * (int) result;
		}

	}

	public static int myAtoiAutomation(String str) {
		Automation auto = new Automation();
		return auto.auto(str);
	}

	public static int myAtoi(String str) {
		int i = 0;
		while (i < str.length() && str.charAt(i) == ' ') {
			i++;
		}

		boolean negative = false;
		if (i < str.length()) {
			if (str.charAt(i) == '-') {
				negative = true;
				i++;
			} else if (str.charAt(i) == '+') {
				i++;
			}
		}

		StringBuilder sb = new StringBuilder();
		while (i < str.length() && (str.charAt(i) >= '0' && str.charAt(i) <= '9')) {
			sb.append(str.charAt(i++));
		}

		if (sb.length() > 0) {
			return atoi(negative, sb.toString());
		}

		return 0;
	}

	static int atoi(boolean negative, String numStr) {
		int result = 0, limit = negative ? Integer.MIN_VALUE : -Integer.MAX_VALUE, multiMin = limit / 10;
		for (int i = 0; i < numStr.length(); i++) {
			if (result < multiMin) {
				return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
			}
			result *= 10;
			int digit = numStr.charAt(i) - '0';
			if (result < limit + digit) {
				return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
			}
			result -= digit;
		}
		return negative ? result : -result;
	}

}
