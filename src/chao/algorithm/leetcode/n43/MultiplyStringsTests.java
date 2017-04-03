package chao.algorithm.leetcode.n43;

import org.junit.Assert;
import org.junit.Test;

public class MultiplyStringsTests {
  private MultiplyStrings2 sut = new MultiplyStrings2();

  @Test
  public void tests() {
    Assert.assertEquals("56088", sut.multiply("123", "456"));
    Assert.assertEquals("2549938021076173291188348428453047981564820005480338416070", sut.multiply("8580858267709931299173190", "297165847695175076927326490812353"));
    Assert.assertEquals("0", sut.multiply("0", "0"));
  }
}
