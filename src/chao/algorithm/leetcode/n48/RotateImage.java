package chao.algorithm.leetcode.n48;

public class RotateImage {
  public void rotate(int[][] matrix) {
    int indexN = matrix.length - 1;
    int temp;
    for (int i = 0; i < matrix.length / 2; i++) {
      int ii = indexN - i;
      for (int j = i; j < ii; j++) {
        temp = matrix[i][j];
        int jj = indexN - j;
        matrix[i][j] = matrix[jj][i];
        matrix[jj][i] = matrix[ii][jj];
        matrix[ii][jj] = matrix[j][ii];
        matrix[j][ii] = temp;
      }
    }
  }
}
