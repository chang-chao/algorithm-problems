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

    int result = 0;
    int sign = 1;

    if (startIndex < str.length()) {
      if (str.charAt(startIndex) == '-') {
        sign = -1;
        startIndex++;
      } else if (str.charAt(startIndex) == '+') {
        startIndex++;
      } else if (!isDigit(str.charAt(startIndex))) {
        return 0;
      }
    }

    while (startIndex < str.length() && isDigit(str.charAt(startIndex))) {
      char c = str.charAt(startIndex);
      int lastDigit = c - '0';

      // out of range check
      if (sign > 0) {
        if (result > 214748364) {
          return 2147483647;
        }
        if (result == 214748364) {
          if (lastDigit > 7) {
            return 2147483647;
          }
        }

      } else {
        if (result > 214748364) {
          return -2147483648;
        }
        if (result == 214748364) {
          if (lastDigit > 8) {
            return -2147483648;
          }
        }
      }
      result = result * 10 + lastDigit;
      startIndex++;
    }

    return result * sign;
  }

  private static boolean isDigit(char c) {
    return ((c - '0') >= 0 && ('9' - c) >= 0);
  }
}
