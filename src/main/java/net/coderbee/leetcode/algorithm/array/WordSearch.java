package net.coderbee.leetcode.algorithm.array;

import java.util.HashSet;
import java.util.Set;

public class WordSearch {

	public static boolean exist(char[][] board, String word) {
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				if (board[row][col] == word.charAt(0)) {
					Set<Long> posSet = new HashSet<Long>();
					if (isMatch(board, word, 0, row, col, posSet)) {
						return true;
					}
				}
			}
		}

		return false;
	}

	private static boolean isMatch(char[][] board, String word, int charPos, int row, int col, Set<Long> posSet) {
		long comb = (long) row << 32 | (long) col;
		if (posSet.contains(comb)) {
			return false;
		}

		if (board[row][col] != word.charAt(charPos)) {
			return false;
		}

		int nextPos = charPos + 1;
		if (nextPos == word.length()) {
			return true;
		}

		posSet.add(comb);
		if (col + 1 < board[row].length && isMatch(board, word, nextPos, row, col + 1, posSet)) {
			return true;
		}
		if (col - 1 >= 0 && isMatch(board, word, nextPos, row, col - 1, posSet)) {
			return true;
		}
		if (row + 1 < board.length && isMatch(board, word, nextPos, row + 1, col, posSet)) {
			return true;
		}
		if (row - 1 >= 0 && isMatch(board, word, nextPos, row - 1, col, posSet)) {
			return true;
		}

		posSet.remove(comb);
		return false;
	}

}
