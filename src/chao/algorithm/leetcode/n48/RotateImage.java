package chao.algorithm.leetcode.n48;

public class RotateImage {
  public void rotate(int[][] matrix) {
    int n = matrix.length;
    for (int circleIndex = 0; circleIndex < n / 2; circleIndex++) {
      int nInThisCircle = n - 2 * circleIndex;
      int loopCountInCircle = nInThisCircle - 1;

      for (int loopIndexInCircle = 0; loopIndexInCircle < loopCountInCircle; loopIndexInCircle++) {

        int[] prevPixel = { circleIndex, circleIndex + loopIndexInCircle };
        int startPixelBackup = matrix[prevPixel[0]][prevPixel[1]];
        int[] nextPixel = { n - 1 - prevPixel[1], prevPixel[0] };

        matrix[prevPixel[0]][prevPixel[1]] = matrix[nextPixel[0]][nextPixel[1]];

        prevPixel[0] = nextPixel[0];
        prevPixel[1] = nextPixel[1];
        nextPixel[0] = n - 1 - prevPixel[1];
        nextPixel[1] = prevPixel[0];
        matrix[prevPixel[0]][prevPixel[1]] = matrix[nextPixel[0]][nextPixel[1]];

        prevPixel[0] = nextPixel[0];
        prevPixel[1] = nextPixel[1];
        nextPixel[0] = n - 1 - prevPixel[1];
        nextPixel[1] = prevPixel[0];
        matrix[prevPixel[0]][prevPixel[1]] = matrix[nextPixel[0]][nextPixel[1]];

        matrix[nextPixel[0]][nextPixel[1]] = startPixelBackup;
      }

    }
  }
}
