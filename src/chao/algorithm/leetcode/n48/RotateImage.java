package chao.algorithm.leetcode.n48;

import java.util.stream.IntStream;

public class RotateImage {
  public void rotate(int[][] matrix) {
    IntStream.range(0, matrix.length / 2).forEach(circleIndex -> copySingleCircle(matrix, circleIndex));
  }

  private void copySingleCircle(int[][] matrix, int circleIndex) {
    int n = matrix.length;
    for (int loopIndexInCircle = 0; loopIndexInCircle < n - 2 * circleIndex - 1; loopIndexInCircle++) {

      int[] pos1 = { circleIndex, circleIndex + loopIndexInCircle };
      int[] pos2 = { n - 1 - pos1[1], pos1[0] };

      int startPixelBackup = matrix[pos1[0]][pos1[1]];
      matrix[pos1[0]][pos1[1]] = matrix[pos2[0]][pos2[1]];

      pos1[0] = n - 1 - pos2[1];
      pos1[1] = pos2[0];
      matrix[pos2[0]][pos2[1]] = matrix[pos1[0]][pos1[1]];

      pos2[0] = n - 1 - pos1[1];
      pos2[1] = pos1[0];
      matrix[pos1[0]][pos1[1]] = matrix[pos2[0]][pos2[1]];

      matrix[pos2[0]][pos2[1]] = startPixelBackup;
    }
  }
}
