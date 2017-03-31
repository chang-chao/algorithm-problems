package chao.algorithm.leetcode.n10;

import org.junit.Assert;
import org.junit.Test;

public class RegularExpressionMatchingTests {
  private RegularExpressionMatching sut = new RegularExpressionMatching();

  @Test
  public void tests() {
    Assert.assertEquals(false, sut.isMatch("aa", "a"));
    Assert.assertEquals(true, sut.isMatch("aa", "aa"));
    Assert.assertEquals(false, sut.isMatch("aaa", "aa"));
    Assert.assertEquals(true, sut.isMatch("aa", "a*"));
    Assert.assertEquals(true, sut.isMatch("aa", ".*"));
    Assert.assertEquals(true, sut.isMatch("ab", ".*"));
    Assert.assertEquals(true, sut.isMatch("aab", "c*a*b"));
  }
}
