package chao.algorithm.leetcode.n30;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class SubstringWithConcatenationOfAllWordsTests {
  private SubstringWithConcatenationOfAllWords sut = new SubstringWithConcatenationOfAllWords();

  @Test
  public void tests() {
    Assert.assertArrayEquals(Arrays.asList(0, 9).toArray(),
        sut.findSubstring("barfoothefoobarman", new String[] { "foo", "bar" }).toArray());
  }
}
