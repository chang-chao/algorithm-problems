package chao.algorithm.leetcode.n48;

import org.junit.Test;

public class RotateImageTests {
  RotateImage sut = new RotateImage();

  @Test
  public void tests() {
//    sut.rotate(new int[][] { { 2, 29, 20, 26, 16, 28 }, { 12, 27, 9, 25, 13, 21 }, { 32, 33, 32, 2, 28, 14 },
//        { 13, 14, 32, 27, 22, 26 }, { 33, 1, 20, 7, 21, 7 }, { 4, 24, 1, 6, 32, 34 } });

    sut.rotate(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } });

  }
}
