package chao.algorithm.leetcode.n44;

public class WildcardMatching {

  public boolean isMatch(String s, String p) {
    if (s.length() == 0) {
      if (p.length() == 0) {
        return true;
      }
      char nextPchar = p.charAt(0);
      if (nextPchar == '*') {
        return isMatch(s, p.substring(1));
      } else {
        return false;
      }
    } else {
      if (p.length() == 0) {
        return false;
      }
      char nextPchar = p.charAt(0);
      if (nextPchar == '?') {
        return isMatch(s.substring(1), p.substring(1));
      }
      if (nextPchar == '*') {
        return isMatch(s.substring(1), p.substring(1)) || isMatch(s.substring(1), p)
            || isMatch(s, p.substring(1));
      }

      if (nextPchar == s.charAt(0)) {
        return isMatch(s.substring(1), p.substring(1));
      }

      return false;
    }

  }
}
