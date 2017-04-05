package chao.algorithm.leetcode.n37;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class SudokuSolver {

  static Set<Character> allCharctors = new HashSet<>();
  static {
    for (char c = '1'; c <= '9'; c++) {
      allCharctors.add(c);
    }

  }

  public static class Coordinate {
    int x;
    int y;

    public Coordinate(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  public void solveSudoku(char[][] board) {

    List<Coordinate> emptyCells = new LinkedList<>();
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (board[i][j] == '.') {
          emptyCells.add(new Coordinate(i, j));
        }
      }
    }
    solveSudoku(board, emptyCells);
  }

  private boolean solveSudoku(char[][] board, List<Coordinate> emptyCells) {
    if (emptyCells.isEmpty()) {
      return true;
    }

    Coordinate emptyCell = emptyCells.get(0);
    Set<Character> candidatesChars = findCandidateChars(board, emptyCell);
    if (candidatesChars.isEmpty()) {
      return false;
    }

    emptyCells.remove(0);
    for (Character c : candidatesChars) {
      board[emptyCell.x][emptyCell.y] = c;

      if (solveSudoku(board, emptyCells)) {
        return true;
      }
    }

    board[emptyCell.x][emptyCell.y] = '.';
    emptyCells.add(0, emptyCell);
    return false;
  }

  private Set<Character> findCandidateChars(char[][] board, Coordinate emptyCell) {
    Set<Character> candidates = new HashSet<>(allCharctors);

    for (int i = 0; i < 9; i++) {
      candidates.remove(board[i][emptyCell.y]);
    }

    for (int i = 0; i < 9; i++) {
      candidates.remove(board[emptyCell.x][i]);
    }

    for (int i = emptyCell.x / 3 * 3; i < emptyCell.x / 3 * 3 + 3; i++) {
      for (int j = emptyCell.y / 3 * 3; j < emptyCell.y / 3 * 3 + 3; j++) {
        candidates.remove(board[i][j]);
      }
    }

    return candidates;
  }
}
