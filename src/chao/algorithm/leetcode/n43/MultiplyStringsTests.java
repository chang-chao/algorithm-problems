package chao.algorithm.leetcode.n43;

import org.junit.Assert;
import org.junit.Test;

public class MultiplyStringsTests {
  private MultiplyStrings sut = new MultiplyStrings();

  @Test
  public void tests() {
    Assert.assertEquals("56088", sut.multiply("123", "456"));
    Assert.assertEquals("0", sut.multiply("0", "0"));
  }
}
