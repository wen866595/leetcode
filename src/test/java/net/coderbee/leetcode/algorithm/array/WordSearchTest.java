package net.coderbee.leetcode.algorithm.array;

import static org.junit.Assert.*;

import org.junit.Test;

public class WordSearchTest {

	@Test
	public void test() throws Exception {
		char[][] board = new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		assertTrue(WordSearch.exist(board, "ABCCED"));
		assertTrue(WordSearch.exist(board, "SEE"));
		assertFalse(WordSearch.exist(board, "ABCB"));

		assertTrue(WordSearch.exist(new char[][] { { 'a' } }, "a"));

		char[][] board2 = new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'E', 'S' }, { 'A', 'D', 'E', 'E' } };
		assertTrue(WordSearch.exist(board2, "ABCESEEEFS"));
	}

}
