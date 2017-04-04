package chao.algorithm.leetcode.n76;

import org.junit.Assert;
import org.junit.Test;

public class MinimumWindowSubstringTests {
  private MinimumWindowSubstring sut = new MinimumWindowSubstring();

  @Test
  public void tests() {
    Assert.assertEquals("BANC", sut.minWindow("ADOBECODEBANC", "ABC"));
    Assert.assertEquals("aa", sut.minWindow("aa", "aa"));
  }
}
