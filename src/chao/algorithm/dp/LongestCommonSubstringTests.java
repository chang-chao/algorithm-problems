package chao.algorithm.dp;

import org.junit.Assert;
import org.junit.Test;

public class LongestCommonSubstringTests {
  private LongestCommonSubstring sut = new LongestCommonSubstring();

  @Test
  public void tests() {
    Assert.assertEquals("Geeks", sut.lcs("GeeksforGeeks", "GeeksQuiz"));
  }

}
