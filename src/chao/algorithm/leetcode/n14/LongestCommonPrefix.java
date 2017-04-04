package chao.algorithm.leetcode.n14;

public class LongestCommonPrefix {
  public String longestCommonPrefix(String[] strs) {
    if (strs.length == 0) {
      return "";
    }

    int currentPos = 0;
    while (true) {
      if (strs[0].length() < currentPos + 1) {
        break;
      }
      char firstC = strs[0].charAt(currentPos);

      boolean same = true;
      for (int i = 1; i < strs.length; i++) {
        if (strs[i].length() < currentPos + 1) {
          same = false;
          break;
        }
        char c = strs[i].charAt(currentPos);
        if (c != firstC) {
          same = false;
          break;
        }
      }

      if (!same) {
        break;
      }
      currentPos++;
    }


    if (currentPos == 0) {
      return "";
    }

    return strs[0].substring(0, currentPos);
  }
}
