package chao.algorithm.leetcode.n7;

public class ReverseInteger {
  public int reverse(final int x) {
    long result = 0;

    int sign = x > 0 ? 1 : -1;

    Long processingX = Math.abs((long) x);
    while (processingX != 0) {
      long digit = processingX % 10;
      result = result * 10 + digit;
      processingX = processingX / 10;
    }
    result = result * sign;
    return (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) ? 0 : (int) result;
  }
}
