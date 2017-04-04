package chao.algorithm.leetcode.n13;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
  public int romanToInt(String s) {
    Map<Character, Integer> romanToInt = new HashMap<>();
    romanToInt.put('I', 1);
    romanToInt.put('V', 5);
    romanToInt.put('X', 10);
    romanToInt.put('L', 50);
    romanToInt.put('C', 100);
    romanToInt.put('D', 500);
    romanToInt.put('M', 1000);

    char[] sCharArray = s.toCharArray();
    int reult = 0;
    int currenPos = 0;
    while (currenPos < s.length()) {
      int currentDigit = romanToInt.get(sCharArray[currenPos]);
      int nextPos = currenPos + 1;
      if (nextPos < s.length()) {
        int nextDigit = romanToInt.get(sCharArray[nextPos]);
        if (nextDigit > currentDigit) {
          reult += (nextDigit - currentDigit);
          currenPos += 2;
          continue;
        } else {
          reult += currentDigit;
        }
      } else {
        reult += currentDigit;
      }
      currenPos++;
    }
    return reult;
  }
}
