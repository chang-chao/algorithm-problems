package chao.algorithm.leetcode.n10;

public class RegularExpressionMatching {
  public boolean isMatch(String s, String p) {

    return isMatch_recursive(s.toCharArray(), p.toCharArray(), 0, 0);
  }

  private boolean isMatch_recursive(char[] s, char[] p, int sPos, int pPos) {
    if (sPos == s.length) {
      return isMatchEmpty(p, pPos);
    }

    if (pPos == p.length) {
      return false;
    }

    // •¶Žš—ñ‚ª‹ó”’‚Å‚È‚¢
    char nextChar = s[sPos];

    if (p.length - pPos >= 2 && p[pPos + 1] == '*') {

      if (p[pPos] == nextChar || p[pPos] == '.') {
        // .* or c*
        return isMatch_recursive(s, p, sPos + 1, pPos) || isMatch_recursive(s, p, sPos, pPos + 2)
            || isMatch_recursive(s, p, sPos + 1, pPos + 2);
      } else {
        // x*
        return isMatch_recursive(s, p, sPos, pPos + 2);
      }

    }

    if (p.length - pPos >= 1) {
      return isCharMatch(s[sPos], p[pPos]) && isMatch_recursive(s, p, sPos + 1, pPos + 1);
    }

    return false;
  }

  private boolean isCharMatch(char c, char p) {
    return c == p || p == '.';
  }

  private boolean isMatchEmpty(char[] p, int pos) {
    if (pos == p.length) {
      return true;
    }
    if (p.length - pos >= 2 && p[pos + 1] == '*') {
      return isMatchEmpty(p, pos + 2);
    }
    return false;
  }
}
