package chao.algorithm.leetcode.n43;

public class MultiplyStrings2 {
  public String multiply(String num1, String num2) {

    int lenN1 = num1.length();
    int lenN2 = num2.length();

    int[][] result2d = new int[lenN1 + lenN2][lenN2];
    char[] num1CharArray = num1.toCharArray();
    char[] num2CharArray = num2.toCharArray();
    for (int i = 0; i < num1CharArray.length; i++) {
      for (int j = 0; j < num2CharArray.length; j++) {

        char num1Char = num1CharArray[num1CharArray.length - 1 - i];
        char num2Char = num2CharArray[num2CharArray.length - 1 - j];
        int multiplyResult = atoi(num1Char) * atoi(num2Char);
        result2d[j + i][j] = multiplyResult;
      }
    }

    int[] result1d = new int[lenN1 + lenN2];
    for (int i = 0; i < result1d.length; i++) {
      for (int j = 0; j < lenN2; j++) {
        result1d[i] += result2d[i][j];
      }

    }
    int carrybits = 0;
    for (int i = 0; i < result1d.length; i++) {
      int r = result1d[i] + carrybits;
      result1d[i] = r % 10;
      carrybits = r / 10;
    }
    StringBuffer sb = new StringBuffer();
    boolean leftmostZeroSkipped = false;
    for (int i = result1d.length - 1; i >= 0; i--) {
      if (!leftmostZeroSkipped && result1d[i] == 0) {
        continue;
      }
      leftmostZeroSkipped = true;
      sb.append(itoa(result1d[i]));
    }
    if (sb.length() == 0) {
      sb.append('0');
    }

    return sb.toString();
  }

  private static int atoi(char a) {
    return a - '0';
  }

  private static char itoa(int digit) {
    return (char) ('0' + digit);
  }

}
