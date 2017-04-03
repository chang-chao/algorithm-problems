package chao.algorithm.leetcode.n8;

public class StringToInteger {
  public int myAtoi(String str) {
    int startIndex = 0;

    while (startIndex < str.length()) {
      if (str.charAt(startIndex) == ' ') {
        startIndex++;
      } else {
        break;
      }
    }

    long result = 0;
    int sign = 1;

    if (startIndex < str.length()) {
      if (str.charAt(startIndex) == '-') {
        sign = -1;
        startIndex++;
      } else if (str.charAt(startIndex) == '+') {
        startIndex++;
      }
    }

    while (startIndex < str.length() && isDigit(str.charAt(startIndex))) {
      char c = str.charAt(startIndex);
      int lastDigit = c - '0';

      // out of range check
      long r = result * 10 + lastDigit;
      long tempResult = r * sign;
      if (tempResult > Integer.MAX_VALUE) {
        return Integer.MAX_VALUE;
      }
      if (tempResult < Integer.MIN_VALUE) {
        return Integer.MIN_VALUE;

      }
      result = r;
      startIndex++;
    }

    return (int) (result * sign);
  }

  private static boolean isDigit(char c) {
    return ((c - '0') >= 0 && ('9' - c) >= 0);
  }
}
