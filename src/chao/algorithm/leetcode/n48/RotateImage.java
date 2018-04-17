package chao.algorithm.leetcode.n48;

public class RotateImage {
  public void rotate(int[][] matrix) {
    int n = matrix.length;
    for (int circleIndex = 0; circleIndex < n / 2; circleIndex++) {
      int nInThisCircle = n - 2 * circleIndex;
      int loopCountInCircle = nInThisCircle - 1;

      for (int loopIndexInCircle = 0; loopIndexInCircle < loopCountInCircle; loopIndexInCircle++) {

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
}
