package chao.algorithm.leetcode.n44;

public class WildcardMatching {

  public boolean isMatch(String s, String p) {
    return isMatch_nonrecursion(s, p);
  }

  private boolean isMatch_nonrecursion(String s, String p) {
    // Using the classical DP algorithm,calculating from bottom to top
    int m = s.length();
    int n = p.length();
    boolean[][] match = new boolean[m + 1][n + 1];

    match[0][0] = true;
    for (int i = 1; i <= m; i++) {
      match[i][0] = false;
    }

    for (int j = 1; j <= n; j++) {
      match[0][j] = (p.charAt(j - 1) == '*' && match[0][j - 1]);
    }

    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {

        char currentPatternChar = p.charAt(j - 1);
        char currentStrChar = s.charAt(i - 1);

        switch (currentPatternChar) {
          case '*':
            match[i][j] = match[i][j - 1] || match[i - 1][j];
            break;

          case '?':
            match[i][j] = match[i - 1][j - 1];
            break;

          default:
            match[i][j] = (currentStrChar == currentPatternChar) && match[i - 1][j - 1];
            break;
        }

      }

    }
    return match[m][n];
  }

  private boolean isMatch_recursion(String s, String p) {
    // Using the classical DP algorithm from top to down,recursively
    if (s.length() == 0) {
      if (p.length() == 0) {
        return true;
      }
      char nextPchar = p.charAt(0);
      if (nextPchar == '*') {
        return isMatch_recursion(s, p.substring(1));
      } else {
        return false;
      }
    } else {
      if (p.length() == 0) {
        return false;
      }
      char nextPchar = p.charAt(0);
      if (nextPchar == '?') {
        return isMatch_recursion(s.substring(1), p.substring(1));
      }
      if (nextPchar == '*') {
        return isMatch_recursion(s.substring(1), p.substring(1))
            || isMatch_recursion(s.substring(1), p) || isMatch_recursion(s, p.substring(1));
      }

      if (nextPchar == s.charAt(0)) {
        return isMatch_recursion(s.substring(1), p.substring(1));
      }

      return false;
    }

  }
}
