package chao.algorithm.leetcode.n48;

public class RotateImage {
  public void rotate(int[][] matrix) {
    int n = matrix.length;
    for (int circleIndex = 0; circleIndex < n / 2; circleIndex++) {
      int nInThisCircle = n - 2 * circleIndex;
      int loopCountInCircle = nInThisCircle - 1;

      for (int loopIndexInCircle = 0; loopIndexInCircle < loopCountInCircle; loopIndexInCircle++) {

        int[] from = { circleIndex, circleIndex + loopIndexInCircle };
        int startPixelBackup = matrix[from[0]][from[1]];
        int[] to = { n - 1 - from[1], from[0] };

        matrix[from[0]][from[1]] = matrix[to[0]][to[1]];

        from[0] = to[0];
        from[1] = to[1];
        to[0] = n - 1 - from[1];
        to[1] = from[0];
        matrix[from[0]][from[1]] = matrix[to[0]][to[1]];

        from[0] = to[0];
        from[1] = to[1];
        to[0] = n - 1 - from[1];
        to[1] = from[0];
        matrix[from[0]][from[1]] = matrix[to[0]][to[1]];

        matrix[to[0]][to[1]] = startPixelBackup;
      }

    }
  }
}
