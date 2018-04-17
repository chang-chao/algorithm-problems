package chao.algorithm.leetcode.n48;

public class RotateImage {
  public void rotate(int[][] matrix) {
    for (int circleIndex = 0; circleIndex < matrix.length / 2; circleIndex++) {
      copySingleCircle(matrix, circleIndex);
    }
  }

  private void copySingleCircle(int[][] matrix, int circleIndex) {
    int indexN = matrix.length - 1;
    for (int loopIndexInCircle = 0; loopIndexInCircle < indexN - 2 * circleIndex; loopIndexInCircle++) {
      int i = circleIndex;
      int j = circleIndex + loopIndexInCircle;
      int ijCopy = matrix[i][j];
      matrix[i][j] = matrix[indexN - j][i];
      matrix[indexN - j][i] = matrix[indexN - i][indexN - j];
      matrix[indexN - i][indexN - j] = matrix[j][indexN - i];
      matrix[j][indexN - i] = ijCopy;
    }
  }
}
