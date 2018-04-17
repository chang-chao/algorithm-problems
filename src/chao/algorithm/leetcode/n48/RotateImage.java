package chao.algorithm.leetcode.n48;

import java.util.Arrays;

public class RotateImage {
  public void rotate(int[][] matrix) {
    int n = matrix.length;
    for (int circleIndex = 0; circleIndex < n / 2; circleIndex++) {
      System.out.println("circleIndex=" + circleIndex);
      int nInThisCircle = n - 2 * circleIndex;
      int loopCountInCircle = nInThisCircle - 1;

      for (int loopIndexInCircle = 0; loopIndexInCircle < loopCountInCircle; loopIndexInCircle++) {
        System.out.println("loopIndexInCircle=" + loopIndexInCircle);
        int[] startPixel = { circleIndex, circleIndex + loopIndexInCircle };

        int[] prevPixel = startPixel;
        int[] nextPixel = { n - 1 - prevPixel[1], prevPixel[0] };

        System.out.println(Arrays.toString(nextPixel) + " --> " + Arrays.toString(prevPixel));
        matrix[prevPixel[0]][prevPixel[1]] = matrix[nextPixel[0]][nextPixel[1]];

        prevPixel = nextPixel;
        nextPixel[0] = n - 1 - prevPixel[1];
        nextPixel[1] = prevPixel[0];
        System.out.println(Arrays.toString(nextPixel) + " --> " + Arrays.toString(prevPixel));
        matrix[prevPixel[0]][prevPixel[1]] = matrix[nextPixel[0]][nextPixel[1]];

        prevPixel = nextPixel;
        nextPixel[0] = n - 1 - prevPixel[1];
        nextPixel[1] = prevPixel[0];
        System.out.println(Arrays.toString(nextPixel) + " --> " + Arrays.toString(prevPixel));
        matrix[prevPixel[0]][prevPixel[1]] = matrix[nextPixel[0]][nextPixel[1]];

        prevPixel = nextPixel;
        System.out.println(Arrays.toString(nextPixel) + " --> " + Arrays.toString(prevPixel));
        matrix[prevPixel[0]][prevPixel[1]] = matrix[startPixel[0]][startPixel[1]];
      }

    }
  }
}
