package chao.algorithm.leetcode.n43;

import java.util.ArrayList;
import java.util.List;

public class MultiplyStrings {
  public String multiply(String num1, String num2) {
    char[] num1CharArray = num1.toCharArray();
    char[] num2CharArray = num2.toCharArray();

    List<Character> result = new ArrayList<>();

    for (int i = num2CharArray.length - 1; i >= 0; i--) {

      List<Character> multiplyResult = new ArrayList<>();

      for (int j = 0; j < num2CharArray.length - (i + 1); j++) {
        multiplyResult.add('0');
      }

      char num2Char = num2CharArray[i];
      int carrybit = 0;
      for (int j = num1CharArray.length - 1; j >= 0; j--) {
        char num1Char = num1CharArray[j];
        int oneDigitResult = atoi(num1Char) * atoi(num2Char) + carrybit;
        multiplyResult.add(itoa(oneDigitResult % 10));
        carrybit = oneDigitResult / 10;
      }

      if (carrybit != 0) {
        multiplyResult.add(itoa(carrybit));
      }

      result = add(result, multiplyResult);

    }

    StringBuffer sb = new StringBuffer();
    boolean leftmostZeroSkipped = false;
    for (int i = result.size() - 1; i >= 0; i--) {
      if (!leftmostZeroSkipped && result.get(i) == '0') {
        continue;
      }
      leftmostZeroSkipped = true;
      sb.append(result.get(i));
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

  private static List<Character> add(List<Character> n1, List<Character> n2) {

    List<Character> result = new ArrayList<>(Math.max(n1.size(), n2.size()) + 1);

    int carrybit = 0;
    int digitNo = 0;
    while (true) {

      if (n1.size() <= digitNo && n2.size() <= digitNo) {
        break;
      }
      int oneDigitResult = carrybit;
      if (n1.size() > digitNo) {
        oneDigitResult += atoi(n1.get(digitNo));
      }
      if (n2.size() > digitNo) {
        oneDigitResult += atoi(n2.get(digitNo));
      }

      result.add(itoa(oneDigitResult % 10));
      carrybit = oneDigitResult / 10;
      digitNo++;

    }

    if (carrybit > 0) {
      result.add(itoa(carrybit));
    }

    return result;
  }
}
