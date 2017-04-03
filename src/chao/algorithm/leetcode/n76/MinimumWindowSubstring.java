package chao.algorithm.leetcode.n76;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
  public String minWindow(String s, String t) {
    Map<Character, Integer> targetCharCount = new HashMap<>();
    char[] charArray = t.toCharArray();
    for (char c : charArray) {
      if (targetCharCount.containsKey(c)) {
        targetCharCount.put(c, targetCharCount.get(c) + 1);
      } else {
        targetCharCount.put(c, 1);
      }
    }

    int currentHead = 0;
    int currentEnd = 0;
    int remaining = t.length();

    int currentResultHead = 0;
    int currentResultLen = Integer.MAX_VALUE;

    char[] sCharArray = s.toCharArray();
    while (currentEnd < s.length()) {
      char currentEndChar = sCharArray[currentEnd];
      if (targetCharCount.containsKey(currentEndChar)) {
        targetCharCount.put(currentEndChar, targetCharCount.get(currentEndChar) - 1);
        if (targetCharCount.get(currentEndChar) >= 0) {
          remaining--;
        }

        while (remaining == 0) {
          // found one!!!
          int len = currentEnd - currentHead + 1;
          if (currentResultLen > len) {
            currentResultHead = currentHead;
            currentResultLen = len;
          }

          char currentHeadChar = sCharArray[currentHead++];

          if (targetCharCount.containsKey(currentHeadChar)) {
            targetCharCount.put(currentHeadChar, targetCharCount.get(currentHeadChar) + 1);
            if (targetCharCount.get(currentHeadChar) > 0) {
              remaining++;
            }

          }

        }

      }

      currentEnd++;

    }

    return currentResultLen == Integer.MAX_VALUE ? ""
        : s.substring(currentResultHead, currentResultHead + currentResultLen);
  }
}
