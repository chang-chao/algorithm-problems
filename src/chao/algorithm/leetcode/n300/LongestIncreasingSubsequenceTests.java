package chao.algorithm.leetcode.n300;

import org.junit.Assert;
import org.junit.Test;

public class LongestIncreasingSubsequenceTests {
  private LongestIncreasingSubsequence sut = new LongestIncreasingSubsequence();

  @Test
  public void test() {
    Assert.assertEquals(4, sut.lengthOfLIS(new int[] { 10, 9, 2, 5, 3, 7, 101, 18 }));
  }

}
