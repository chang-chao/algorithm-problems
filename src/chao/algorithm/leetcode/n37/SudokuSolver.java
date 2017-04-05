package chao.algorithm.leetcode.n37;

public class SudokuSolver {
  public void solveSudoku(char[][] board) {

    int[] emptyXs = new int[81];
    int[] emptyYs = new int[81];
    int emptyCount = 0;
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (board[i][j] == '.') {
          emptyXs[emptyCount] = i;
          emptyYs[emptyCount] = j;
          emptyCount++;

        }
      }
    }
    solveSudoku(board, emptyXs, emptyYs, 0, emptyCount);
  }

  private boolean solveSudoku(char[][] board, int[] emptyXs, int[] emptyYs, int offset, int maxIndexExclusive) {
    if (offset == maxIndexExclusive) {
      return true;
    }

    int candidatesChars = findCandidateChars(board, emptyXs[offset], emptyYs[offset]);
    if (candidatesChars == 0) {
      return false;
    }

    char c = '1';
    while (candidatesChars != 0) {
      if ((candidatesChars & 1) == 1) {
        board[emptyXs[offset]][emptyYs[offset]] = c;

        if (solveSudoku(board, emptyXs, emptyYs, offset + 1, maxIndexExclusive)) {
          return true;
        }
      }

      c++;
      candidatesChars = (candidatesChars >> 1);
    }

    board[emptyXs[offset]][emptyYs[offset]] = '.';
    return false;
  }

  private int findCandidateChars(char[][] board, int x, int y) {
    int candidate = 0b111111111;

    int used = 0;
    for (int i = 0; i < 9; i++) {
      char c = board[i][y];
      if (c != '.') {
        used |= 1 << (c - '1');
      }
    }

    for (int i = 0; i < 9; i++) {
      char c = board[x][i];
      if (c != '.') {
        used |= 1 << (c - '1');
      }
    }

    for (int i = x / 3 * 3; i < x / 3 * 3 + 3; i++) {
      for (int j = y / 3 * 3; j < y / 3 * 3 + 3; j++) {
        char c = board[i][j];
        if (c != '.') {
          used |= 1 << (c - '1');
        }
      }
    }

    return candidate ^ used;
  }
}
