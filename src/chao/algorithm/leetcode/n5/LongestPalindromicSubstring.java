package chao.algorithm.leetcode.n5;

public class LongestPalindromicSubstring {
  public String longestPalindrome(String s) {
    int currentResultPos = 0, currentResultOffset = 0;
    char[] sCharArray = s.toCharArray();
    for (int pos = 0; pos < s.length(); pos++) {

      int offset = 0;
      for (int i = 1; i <= Math.min(pos, s.length() - pos - 1); i++) {
        if (sCharArray[pos - i] == sCharArray[pos + i]) {
          offset++;
        } else {
          break;
        }
      }

      if ((offset) > currentResultOffset) {
        currentResultPos = pos;
        currentResultOffset = offset;
      }

    }

    return s.substring(currentResultPos - currentResultOffset,
        currentResultPos + currentResultOffset + 1);

  }
}
