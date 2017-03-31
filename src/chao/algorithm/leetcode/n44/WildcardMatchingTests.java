package chao.algorithm.leetcode.n44;

import org.junit.Assert;
import org.junit.Test;

public class WildcardMatchingTests {
  private WildcardMatching sut = new WildcardMatching();

  @Test
  public void tests() {
    Assert.assertEquals(false, sut.isMatch("aa", "a"));
    Assert.assertEquals(true, sut.isMatch("aa", "aa"));
    Assert.assertEquals(false, sut.isMatch("aaa", "aa"));
    Assert.assertEquals(true, sut.isMatch("aa", "*"));
    Assert.assertEquals(true, sut.isMatch("aa", "a*"));
    Assert.assertEquals(true, sut.isMatch("ab", "?*"));
    Assert.assertEquals(false, sut.isMatch("aab", "c*a*b"));
  }
}
