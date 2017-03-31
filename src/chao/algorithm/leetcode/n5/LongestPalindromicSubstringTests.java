package chao.algorithm.leetcode.n5;

import org.junit.Assert;
import org.junit.Test;

public class LongestPalindromicSubstringTests {
  private LongestPalindromicSubstring sut = new LongestPalindromicSubstring();

  @Test
  public void tests() {
    Assert.assertEquals("bab", sut.longestPalindrome("babad"));
    Assert.assertEquals("bb", sut.longestPalindrome("cbbd"));
    Assert.assertEquals("bb", sut.longestPalindrome("bb"));
  }
}
