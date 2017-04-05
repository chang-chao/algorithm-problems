package chao.algorithm.leetcode.n502;

import org.junit.Assert;
import org.junit.Test;

public class IpoTests {
  private Ipo sut = new Ipo();

  @Test
  public void tests() {
    Assert.assertEquals(4, sut.findMaximizedCapital(2, 0, new int[] { 1, 2, 3 }, new int[] { 0, 1, 1 }));
  }
}
