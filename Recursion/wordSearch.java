/*
Search for a word on a board:
Given a 2D board and a word, find if the word exists on the board.
The word can be constructed from letters of sequentially adjacent cells, 
where 'adjacent' cells are those horizontally or vertically neighboring. 
The same letter cell may not be used more than once
*/

import java.io.*;
import java.util.*;

public class WordSearch {
    int num_rows;
    int num_columns;

    public boolean exist(char[][] board, String word) {
        num_rows = board.length;
        num_columns = board[0].length;
        // start the search with every letter on the board
        for (int row = 0; row < num_rows; row++) {
            for (int col = 0; col < num_columns; col++) {
                if (findWord(board, row, col, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean findWord(char[][] board, int row, int col, String word, int index) {
        if (index >= word.length()) { // Successful termination condition
            return true;
        }
        // Failure condition- mismatch or out of bounds condition
        if (row < 0 || row >= num_rows || col < 0 || col >= num_columns || board[row][col] != word.charAt(index)) {
            return false;
        }
        boolean found = false;
        board[row][col] = '#'; // mark position as visited
        int[] rowChangeForNextDir = { 0, 1, 0, -1 };
        int[] colChangeForNextDir = { 1, 0, -1, 0 };
        for (int dir = 0; dir < 4; dir++) {
            found = findWord(board, row + rowChangeForNextDir[dir], col + colChangeForNextDir[dir], word, index + 1);
            if (found) { // Success
                break;
            }
        }
        // optionally Restore
        board[row][col] = word.charAt(index);
        return found;
    }

}
