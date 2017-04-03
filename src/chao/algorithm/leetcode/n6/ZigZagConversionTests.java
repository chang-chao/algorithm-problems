package chao.algorithm.leetcode.n6;

import org.junit.Assert;
import org.junit.Test;

public class ZigZagConversionTests {
  private ZigZagConversion sut = new ZigZagConversion();

  @Test
  public void tests() {
    Assert.assertEquals("PAHNAPLSIIGYIR", sut.convert("PAYPALISHIRING", 3));
    Assert.assertEquals("A", sut.convert("A", 1));
  }
}
