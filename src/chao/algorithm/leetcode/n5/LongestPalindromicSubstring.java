package chao.algorithm.leetcode.n5;

public class LongestPalindromicSubstring {
  public String longestPalindrome(String s) {
    if (s.isEmpty()) {
      return "";
    }
    int currentPos = 0;
    int currentLen = 1;
    char[] charArray = s.toCharArray();
    for (int i = 0; i < s.length(); i++) {
      for (int j = i + 1; j < charArray.length; j++) {
        int len = j - i + 1;
        if (len <= currentLen) {
          continue;
        }
        boolean palindromic = isPalindromic(charArray, i, len);
        if (palindromic) {
          currentLen = len;
          currentPos = i;
        }
      }
    }

    return s.substring(currentPos, currentPos + currentLen);

  }

  private boolean isPalindromic(char[] s, int pos, int len) {
    for (int i = 0; i < len / 2; i++) {
      if (s[pos + i] != s[pos + len - 1 - i]) {
        return false;
      }
    }
    return true;
  }
}
