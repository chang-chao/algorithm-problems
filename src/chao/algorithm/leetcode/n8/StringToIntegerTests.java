package chao.algorithm.leetcode.n8;

import org.junit.Assert;
import org.junit.Test;

public class StringToIntegerTests {
  private StringToInteger sut = new StringToInteger();

  @Test
  public void tests() {
    Assert.assertEquals(0, sut.myAtoi("a123"));
    Assert.assertEquals(123, sut.myAtoi("123"));
    Assert.assertEquals(2147483647, sut.myAtoi("2147483648"));
    Assert.assertEquals(-2147483648, sut.myAtoi("-2147483649"));
  }
}
