package chao.algorithm.leetcode.n7;

public class ReverseInteger {
  public int reverse(final int x) {
    int result = 0;

    int processingX = x;
    while (processingX != 0) {
      int digit = processingX % 10;
      int newResult = result * 10 + digit;
      if ((newResult - digit) / 10 != result) {
        return 0;
      }
      result = newResult;
      processingX = processingX / 10;
    }
    return result;
  }
}
