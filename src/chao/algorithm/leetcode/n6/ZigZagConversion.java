package chao.algorithm.leetcode.n6;

public class ZigZagConversion {
  public String convert(String s, int numRows) {
    StringBuffer sb = new StringBuffer();

    if (numRows == 1) {
      return s;
    }

    // first row
    int index = 0;
    while (index < s.length()) {
      sb.append(s.charAt(index));
      index += 2 * numRows - 2;
    }

    // middle rows
    if (numRows >= 3) {
      for (int rows = 1; rows < numRows - 1; rows++) {

        int idx = rows;
        while (idx < s.length()) {

          sb.append(s.charAt(idx));
          int zigIndex = idx + (numRows - idx % (2 * numRows - 2) - 1) + (numRows - rows - 1);
          if (zigIndex < s.length()) {
            sb.append(s.charAt(zigIndex));
          }

          idx += (2 * numRows - 2);

        }

      }

    }

    // last row
    if (numRows >= 2) {
      int idxLastRow = numRows - 1;
      while (idxLastRow < s.length()) {
        sb.append(s.charAt(idxLastRow));
        idxLastRow += (2 * numRows - 2);
      }
    }

    return sb.toString();
  }
}
