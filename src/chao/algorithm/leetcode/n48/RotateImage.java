package chao.algorithm.leetcode.n48;

public class RotateImage {
  public void rotate(int[][] matrix) {
    int indexN = matrix.length - 1;
    int temp;
    for (int i = 0; i < matrix.length / 2; i++) {
      for (int j = i; j < indexN - i; j++) {
        temp = matrix[i][j];
        matrix[i][j] = matrix[indexN - j][i];
        matrix[indexN - j][i] = matrix[indexN - i][indexN - j];
        matrix[indexN - i][indexN - j] = matrix[j][indexN - i];
        matrix[j][indexN - i] = temp;
      }
    }
  }
}
