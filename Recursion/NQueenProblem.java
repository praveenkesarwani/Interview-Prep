
/*
Arrange N Queens on a chess board:
Print all ways of arranging n queens on an n x n chess board so that none of them 
share the same row, column or diagonal. In this case, 'diagonal' means all diagonals,
not just the two that bisect the board.
*/
import java.util.*;

public class NQueens {
    String answer = "";

    String nQueens(int n) {
        answer = new String(); // answer is a global variable
        int queen_columns[] = new int[n];
        getQueenPositions(0, queen_columns, n); // main method
        boolean is_answer = false;
        for (int i = 0; i < answer.length(); i++) {
            if (answer.charAt(i) == '1') {
                is_answer = true;
                break;
            }
        }
        if (is_answer == false) {
            return "No Solution Exists";
        }
        return answer;
    }

    void getQueenPositions(int current_row, int[] queen_columns, int n) {
        if (current_row == n) { // A solution has been found
            appendToAnswerString(queen_columns, n);
            return;
        }
        // Try out each column as a possible position for the current_row
        for (int column = 0; column < n; column++) {
            if (isValidPosition(column, current_row, queen_columns, n)) {
                queen_columns[current_row] = column;
                // Good so far, check if next queen can find a position
                getQueenPositions(current_row + 1, queen_columns, n);
            }
        }
    }

    boolean isValidPosition(int current_column, int current_row, int[] queen_columns, int n) {
        boolean is_valid = true;
        for (int j = 0; j < current_row; j++) {
            // check for column being taken in previous rows
            if (queen_columns[j] == current_column) {
                is_valid = false;
                break;
            }
            // check for diagonal conflict with previous rows
            if (Math.abs(queen_columns[j] - current_column) == Math.abs(current_row - j)) {
                is_valid = false;
                break;
            }
        }
        return is_valid;
    }

    void appendToAnswerString(int[] queen_columns, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (queen_columns[j] == i) {
                    answer += '1';
                } else {
                    answer += '0';
                }
            }
            answer += '\n';
        }
        answer += '\n';
    }
}